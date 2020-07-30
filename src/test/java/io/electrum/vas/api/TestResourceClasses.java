package io.electrum.vas.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.mockito.Mockito;
import org.mockito.exceptions.misusing.NotAMockException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.electrum.vas.util.Utils;

public class TestResourceClasses {

   /**
    * Equivalent to calling
    * {@link #ensureResourceOperationMethodBackwardsCompatibility(Class, String, Class, String, String)} with parameters
    * {@code ensureResourceOperationMethodBackwardsCompatibility(resourceClass, operationMethodName, interfaceClass, interfaceMethodName, "getResourceImplementation")}
    * 
    * @param resourceClass
    * @param operationMethodName
    * @param interfaceClass
    * @param interfaceMethodName
    * @throws Exception
    */
   public static void ensureResourceOperationMethodBackwardsCompatibility(
         Class<?> resourceClass,
         String operationMethodName,
         Class<?> interfaceClass,
         String interfaceMethodName)
         throws Exception {
      ensureResourceOperationMethodBackwardsCompatibility(
            resourceClass,
            operationMethodName,
            interfaceClass,
            interfaceMethodName,
            "getResourceImplementation");
   }

   /**
    * Ensures that methods in the resource classes which define operations will ultimately call back to the original
    * interface method
    * <p>
    * This method will search for the method called {@code operationMethodName} in the class {@code resourceClass}. This
    * method may be overloaded and only the overload with one of the following annotations is considered:
    * <ul>
    * <li>javax.ws.rs.GET</li>
    * <li>javax.ws.rs.POST</li>
    * <li>javax.ws.rs.PUT</li>
    * <li>javax.ws.rs.DELETE</li>
    * </ul>
    * It is presumed that one of the above annotations denotes an 'operation method' i.e. one that is called when an API
    * operation is performed.
    * <p>
    * Once the 'operation method' has been identified, the method is explicitly invoked on an object of the
    * {@code resourceClass}. Mockito is then used to verify that the method called {@code interfaceMethodName} of the
    * interface {@code interfaceName} is implicitly invoked.
    * <p>
    * There are a few requirements of the {@code resourceClass}:
    * <ol>
    * <li>There must be a default constructor.</li>
    * <li>There must be a method, called {@code getResourceImplementationMethodName} without parameters, which returns
    * an instance of the {@code interfaceName} interface.</li>
    * <li>The {@code getResourceImplementationMethodName} method must return a spied instance of the
    * {@code interfaceName} interface i.e. one created by calling {@link Mockito.spy(Object)} on an instance of the
    * {@code interfaceName}.</li>
    * </ol>
    * 
    * @param resourceClass
    *           The concrete implementation of the resource class. This class should not override any methods in the
    *           abstract parent class. It should simply provide a spied instance of the {@code interfaceClass}
    *           interface.
    * @param operationMethodName
    *           The name of the method in the resource class which is invoked when an API operation is performed.
    * @param interfaceClass
    *           The concrete implementation of the interface whose methods are to be invoked when an API operation is
    *           performed.
    * @param interfaceMethodName
    *           The name of the method in the ({@code interfaceClass}) interface which is invoked when the
    *           aforementioned API operation is performed.
    * @param getResourceImplementationMethodName
    *           The name of the method in the {@code resourceClass} which provides an instance of the
    *           {@code interfaceClass}. Note that this instance should be a {@link Mockito#spy} of an actual
    *           {@code interfaceClass} object.
    * @throws Exception
    */
   public static void ensureResourceOperationMethodBackwardsCompatibility(
         Class<?> resourceClass,
         String operationMethodName,
         Class<?> interfaceClass,
         String interfaceMethodName,
         String getResourceImplementationMethodName)
         throws Exception {
      // First identify the interface method which should be called when the resource class processes an operation
      Method targettedInterfaceMethod = Utils.findBaseMethod(interfaceClass, interfaceMethodName);
      if (targettedInterfaceMethod == null) {
         Assert.fail("No method called " + interfaceMethodName + " in " + interfaceClass.getSimpleName());
      }
      Method[] resourceMethods = resourceClass.getMethods();
      for (Method resourceMethod : resourceMethods) {
         // if the method denotes an API operation
         if (resourceMethod.getName().equals(operationMethodName)
               && (resourceMethod.getAnnotation(javax.ws.rs.GET.class) != null
                     || resourceMethod.getAnnotation(javax.ws.rs.POST.class) != null
                     || resourceMethod.getAnnotation(javax.ws.rs.PUT.class) != null
                     || resourceMethod.getAnnotation(javax.ws.rs.DELETE.class) != null)) {
            Object[] interfaceMethodParameters = new Object[targettedInterfaceMethod.getParameterCount()];
            Object resourceClassInstance;
            try {
               resourceClassInstance = resourceClass.getConstructor().newInstance();
            } catch (NoSuchMethodException nsme) {
               throw new Exception(
                     "The resource class does not meet condition 1 of this method (There must be a default constructor).",
                     nsme);
            }
            Object spiedInterfaceImpl;
            try {
               spiedInterfaceImpl =
                     resourceClassInstance.getClass()
                           .getDeclaredMethod(getResourceImplementationMethodName)
                           .invoke(resourceClassInstance);
            } catch (NoSuchMethodException nsme) {
               throw new Exception(
                     "There must be a method, called " + getResourceImplementationMethodName
                           + "(), which returns an instance of the interfaceName interface",
                     nsme);
            }
            Object[] resourceMethodParameters = new Object[resourceMethod.getParameterCount()];
            // call the method which defines the operation
            resourceMethod.invoke(resourceClassInstance, resourceMethodParameters);
            // ensure that the matching interface method was called
            try {
               targettedInterfaceMethod.invoke(Mockito.verify(spiedInterfaceImpl), interfaceMethodParameters);
            } catch (NotAMockException name) {
               throw new Exception(
                     "The resource class does not meet condition 3 of this method (The "
                           + getResourceImplementationMethodName
                           + "() method must return a spied instance of the interfaceName interface i.e. one created by calling Mockito.spy(Object) on an instance of the interfaceName).",
                     name);
            }
         }
      }
   }

   @Test
   public void testCorrectResourceOperationsIdentified() throws Exception {
      ensureResourceOperationMethodBackwardsCompatibility(
            CorrectResourceTestClass.class,
            "correctResourceMethod",
            ResourceTestInterfaceImpl.class,
            "correctBaseMethod");
   }

   @Test(expectedExceptions = { InvocationTargetException.class })
   public void testIncorrectResourceOperationsIdentified() throws Exception {
      ensureResourceOperationMethodBackwardsCompatibility(
            CorrectResourceTestClass.class,
            "incorrectResourceMethod",
            ResourceTestInterfaceImpl.class,
            "incorrectBaseMethod");
   }

   @Test
   public void testMissingDefaultConstructor() throws Exception {
      try {
         ensureResourceOperationMethodBackwardsCompatibility(
               IncorrectResourceTestClassWithoutDefaultConstructor.class,
               "resourceMethod",
               ResourceTestInterfaceImpl.class,
               "incorrectBaseMethod");
         Assert.fail("This should have failed due to a missing default constructor");
      } catch (Exception e) {
         Assert.assertTrue(e.getCause() instanceof NoSuchMethodException);
         Assert.assertEquals(
               e.getMessage(),
               "The resource class does not meet condition 1 of this method (There must be a default constructor).");
      }
   }

   @Test
   public void testMissingGetResourceImplementationMethod() throws Exception {
      try {
         ensureResourceOperationMethodBackwardsCompatibility(
               IncorrectResourceTestClassWithoutGetResourceImplementationMethod.class,
               "resourceMethod",
               ResourceTestInterfaceImpl.class,
               "incorrectBaseMethod");
         Assert.fail("This should have failed due to a missing getResourceImplementation method");
      } catch (Exception e) {
         Assert.assertTrue(e.getCause() instanceof NoSuchMethodException);
         Assert.assertEquals(
               e.getMessage(),
               "The resource class does not meet condition 2 of this method (There must be a method, getResourceImplementation(), which returns an instance of the interfaceName interface).");
      }
   }

   @Test
   public void testDoesntSpyResourceImplementation() throws Exception {
      try {
         ensureResourceOperationMethodBackwardsCompatibility(
               IncorrectResourceTestClassDoesntSpyResourceImplementation.class,
               "resourceMethod",
               ResourceTestInterfaceImpl.class,
               "incorrectBaseMethod");
         Assert.fail("This should have failed due to the resource interface not being mocked");
      } catch (Exception e) {
         Assert.assertTrue(e.getCause() instanceof NotAMockException);
         Assert.assertEquals(
               e.getMessage(),
               "The resource class does not meet condition 3 of this method (The getResourceImplementation() method must return a spied instance of the interfaceName interface i.e. one created by calling Mockito.spy(Object) on an instance of the interfaceName).");
      }
   }
}