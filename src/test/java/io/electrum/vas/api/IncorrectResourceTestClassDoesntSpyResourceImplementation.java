package io.electrum.vas.api;

import javax.ws.rs.GET;

public class IncorrectResourceTestClassDoesntSpyResourceImplementation {
   static ResourceTestInterface resourceInterface = new ResourceTestInterfaceImpl();

   public ResourceTestInterface getResourceImplementation() {
      return resourceInterface;
   }

   public void resourceMethod(Object obj) {
   }

   @GET
   public void resourceMethod(Object obj, Object obj2) {
      resourceMethod(obj);
   }
}
