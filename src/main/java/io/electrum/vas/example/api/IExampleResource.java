package io.electrum.vas.example.api;

import io.electrum.vas.example.model.ExampleReversal;
import io.electrum.vas.model.TenderAdvice;
import io.electrum.vas.model.Transaction;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IExampleResource {

   void createTran(
         String id,
         Transaction body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void confirmTran(
         String id,
         String requestId,
         TenderAdvice body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void reverseTran(
         String id,
         String requestId,
         ExampleReversal body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);
}
