package io.electrum.vas.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.model.VasAdvice;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * An advice that notifies of the unsuccessful completion of a transaction
 */
public abstract class ExampleReversal extends VasAdvice {

   protected ExampleRequest request = null;

   /**
    * The request this reversal refers to
    **/
   public ExampleReversal request(ExampleRequest request) {
      this.request = request;
      return this;
   }

   @ApiModelProperty(required = true, value = "The request this reversal refers to")
   @JsonProperty("request")
   @NotEmpty
   public ExampleRequest getRequests() {
      return request;
   }

   public void setRequest(ExampleRequest request) {
      this.request = request;
   }
}
