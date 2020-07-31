package io.electrum.vas.api;

import javax.ws.rs.GET;

import org.mockito.Mockito;

public class IncorrectResourceTestClassWithoutDefaultConstructor {
   static ResourceTestInterface resourceInterface = Mockito.spy(new ResourceTestInterfaceImpl());

   public IncorrectResourceTestClassWithoutDefaultConstructor(Object obj) {
      // eliminates default constructor
   }

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
