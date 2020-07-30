package io.electrum.vas.api;

import javax.ws.rs.GET;

import org.mockito.Mockito;

/**
 * Correctly matches the three conditions of the
 * {@link TestResourceClasses#ensureResourceOperationMethodBackwardsCompatibility(Class, String, Class, String)} method.
 * 
 * @author timwhelan
 *
 */
public class CorrectResourceTestClass {
   static ResourceTestInterface resourceInterface = Mockito.spy(new ResourceTestInterfaceImpl());

   public ResourceTestInterface getResourceImplementation() {
      return resourceInterface;
   }

   public void correctResourceMethod(Object obj) {
      getResourceImplementation().correctBaseMethod(obj);
   }

   /**
    * Correctly calls back to base method.
    * 
    * @param obj
    * @param obj2
    */
   @GET
   public void correctResourceMethod(Object obj, Object obj2) {
      correctResourceMethod(obj);
   }

   public void incorrectResourceMethod(Object obj) {
      getResourceImplementation().incorrectBaseMethod(obj);
   }

   /**
    * Incorrectly does not call back to base method.
    * 
    * @param obj
    * @param obj2
    */
   @GET
   public void incorrectResourceMethod(Object obj, Object obj2) {
   }
}
