package io.electrum.vas.api;

import javax.ws.rs.GET;

import org.mockito.Mockito;

public class IncorrectResourceTestClassWithoutGetResourceImplementationMethod {
   static ResourceTestInterface resourceInterface = Mockito.spy(new ResourceTestInterfaceImpl());

   public void resourceMethod(Object obj) {
   }

   @GET
   public void resourceMethod(Object obj, Object obj2) {
      resourceMethod(obj);
   }
}
