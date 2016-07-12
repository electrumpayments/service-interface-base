package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * The data required in all value added service requests
 **/
public abstract class VasAdvice {

   protected UUID id = null;
   protected UUID requestId = null;
   protected DateTime time = null;
   protected Object linkData = null;

   /**
    * The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122). This field should match the {requestId} url parameter
    **/
   public VasAdvice id(UUID id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122). This field should match the {requestId} url parameter")
   @JsonProperty("id")
   @NotNull
   public UUID getId() {
      return id;
   }

   public void setId(UUID id) {
      this.id = id;
   }

   /**
    * The UUID identifying the request that this advice relates to
    **/
   public VasAdvice requestId(UUID requestId) {
      this.requestId = requestId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The UUID identifying the request that this advice relates to")
   @JsonProperty("requestId")
   @NotNull
   public UUID getRequestId() {
      return requestId;
   }

   public void setRequestId(UUID requestId) {
      this.requestId = requestId;
   }

   /**
    * The date and time of the request in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public VasAdvice time(DateTime time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the request as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   public DateTime getTime() {
      return time;
   }

   public void setTime(DateTime time) {
      this.time = time;
   }

   /**
    * The unaltered linkData object as supplied in the related VasResponse message. Required if linkData was present in
    * the VasResponse. Shall not be populated if linkData was not present in the VasResponse, or no VasResponse was
    * received
    **/
   public VasAdvice linkData(Object linkData) {
      this.linkData = linkData;
      return this;
   }

   @ApiModelProperty(value = "The unaltered linkData object as supplied in the related VasResponse message. Required if linkData was present in the VasResponse. Shall not be populated if linkData was not present in the VasResponse, or no VasResponse was received")
   @JsonProperty("linkData")
   public Object getLinkData() {
      return linkData;
   }

   public void setLinkData(Object linkData) {
      this.linkData = linkData;
   }
}
