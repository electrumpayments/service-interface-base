package io.electrum.vas.example.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import io.electrum.vas.example.model.ErrorDetail;
import io.electrum.vas.example.model.ExampleReversal;
import io.electrum.vas.model.TenderAdvice;
import io.electrum.vas.model.Transaction;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.ResponseHeader;

@Path("/transactions")
@Consumes({ "application/json" })
@Produces({ "application/json" })
@Api(description = "the example transactions API", authorizations = { @Authorization("httpBasic") })
public abstract class ExampleResource {

   protected abstract IExampleResource getResourceImplementation();

   @POST
   @Path("/{requestId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "Create a transaction request", notes = "Create a transactions resource.")
   @ApiResponses(value = {
         @ApiResponse(code = 201, message = "Created", response = Transaction.class, responseHeaders = { @ResponseHeader(name = "Location", description = "The location of the created transaction resource", response = String.class) }),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void createTran(
         @ApiParam(value = "The randomly generated UUID of this request", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "A transaction request", required = true) Transaction body,
         @Context SecurityContext securityContext,
         @Context AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().createTran(requestId, body, securityContext, asyncResponse, httpHeaders, uriInfo);
   }

   @POST
   @Path("/{requestId}/confirmations/{adviceId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "An example confirmation advice", notes = "If a createTran request previously succeeded with a 201 status it must be confirmed or reversed to complete the transaction. confirmTran can only succeed if a transaction was created but not cancelled. confirmTran must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. confirmTran may be called repeatedly on the same payment resource without negative effect, but the first successfully received message shall be actioned by the service implementation. It is thus not acceptable to alter the message contents during repeats")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void confirmTran(
         @ApiParam(value = "The UUID of the related createTran request", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "The randomly generated UUID of this advice", required = true) @PathParam("adviceId") String adviceId,
         @ApiParam(value = "A payment confirmation", required = true) TenderAdvice body,
         @Context SecurityContext securityContext,
         @Context AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().confirmTran(
            adviceId,
            requestId,
            body,
            securityContext,
            asyncResponse,
            httpHeaders,
            uriInfo);
   }

   @POST
   @Path("/{requestId}/reversals/{adviceId}")
   @Consumes({ "application/json" })
   @Produces({ "application/json" })
   @ApiOperation(value = "An example reversal advice", notes = "If a createTran request previously succeeded with a 201 status it must be confirmed or reversed to complete the transaction. reverseTran can only succeed if a transaction was created but not cancelled. confirmTran must be repeated until a final HTTP status code is received (not 500 or 504). If a status code of either 500 or 504 is received, or no response is received, the request must be repeated. confirmTran may be called repeatedly on the same payment resource without negative effect, but the first successfully received message shall be actioned by the service implementation. It is thus not acceptable to alter the message contents during repeats")
   @ApiResponses(value = { @ApiResponse(code = 202, message = "Accepted"),
         @ApiResponse(code = 400, message = "Bad request", response = ErrorDetail.class),
         @ApiResponse(code = 500, message = "Internal Server Error", response = ErrorDetail.class),
         @ApiResponse(code = 503, message = "Service Unavailable", response = ErrorDetail.class),
         @ApiResponse(code = 504, message = "Gateway Timeout", response = ErrorDetail.class) })
   public void reverseTran(
         @ApiParam(value = "The UUID of the related createTran request", required = true) @PathParam("requestId") String requestId,
         @ApiParam(value = "The randomly generated UUID of this advice", required = true) @PathParam("adviceId") String adviceId,
         @ApiParam(value = "A payment reversal", required = true) ExampleReversal body,
         @Context SecurityContext securityContext,
         @Context AsyncResponse asyncResponse,
         @Context HttpHeaders httpHeaders,
         @Context UriInfo uriInfo) {

      getResourceImplementation().reverseTran(
            adviceId,
            requestId,
            body,
            securityContext,
            asyncResponse,
            httpHeaders,
            uriInfo);
   }
}
