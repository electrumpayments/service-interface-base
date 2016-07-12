package io.electrum.vas.example.api;

import io.electrum.vas.example.model.ExampleConfirmation;
import io.electrum.vas.example.model.ExampleRequest;
import io.electrum.vas.example.model.ExampleReversal;

import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

public interface IExampleResource {

   void createTran(
         String id,
         ExampleRequest body,
         SecurityContext securityContext,
         AsyncResponse asyncResponse,
         HttpHeaders httpHeaders,
         UriInfo uriInfo);

   void confirmTran(
         String id,
         String requestId,
         ExampleConfirmation body,
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
