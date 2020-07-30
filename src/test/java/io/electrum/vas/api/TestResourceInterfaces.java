package io.electrum.vas.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import io.electrum.vas.util.Utils;

public class TestResourceInterfaces {

   /**
    * Ensures that, when overloaded interface methods are called, each overloaded method calls back to the original
    * method
    * <p>
    * This method will search for all overloads of the method called {@code methodName} in the class
    * {@code interfaceImpl}. The method with the fewest parameters is identified and is presumed to be the 'base'
    * method. Each method identified is then invoked explicitly and Mockito is used to ensure that the base method is
    * also invoked implicitly.
    * 
    * @param interfaceImpl
    *           The interface implementation against which the method is invoked.
    * @param methodName
    *           The name of the method to be tested
    * @throws Exception
    */
   public static void ensureInterfaceMethodBackwardsCompatibility(Class<?> interfaceImpl, String methodName)
         throws Exception {
      // The method with name = methodName which has the fewest parameters
      Method baseMethod = null;
      // collect all methods with the name "methodName"
      List<Method> methodsToTest = new ArrayList<>();
      baseMethod = Utils.findBaseMethod(interfaceImpl, methodName, methodsToTest);

      // call each Method with name = methodName
      // ensure that, for each method called, the Method with the fewest parameters is also called.
      Object[] paramsForExpectedMethod = new Object[baseMethod.getParameterCount()];
      for (Method methodToCall : methodsToTest) {
         Object spiedInterfaceImpl = Mockito.spy(interfaceImpl.getConstructor().newInstance());
         int numCalledParameters = methodToCall.getParameters().length;
         Object[] paramsForCalledMethod = new Object[numCalledParameters];
         methodToCall.invoke(spiedInterfaceImpl, paramsForCalledMethod);
         baseMethod.invoke(Mockito.verify(spiedInterfaceImpl), paramsForExpectedMethod);
      }
   }

   @Test
   public void testCorrectMethodCallsIdentified() throws Exception {
      ensureInterfaceMethodBackwardsCompatibility(ResourceTestInterfaceImpl.class, "correctBaseMethod");
   }

   @Test(expectedExceptions = { InvocationTargetException.class })
   public void testIncorrectMethodCallsIdentified() throws Exception {
      ensureInterfaceMethodBackwardsCompatibility(ResourceTestInterfaceImpl.class, "incorrectBaseMethod");
   }
}
