package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data required in all value added service requests
 **/
public abstract class VasResponse {

   protected Object linkData = null;

   /**
    * This object may be used by the service implementation to link a payment to a payment confirmation or cancellation,
    * and should be provided unaltered by clients in corresponding requests
    **/
   public VasResponse linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "This object may be used by the ervice implementation to link a payment to a payment confirmation or cancellation, and should be provided unaltered by clients in corresponding requests")
   @JsonProperty("linkData")
   public Object getLinkData() {
      return linkData;
   }

   public void setLinkData(Object linkData) {
      this.linkData = linkData;
   }
}
