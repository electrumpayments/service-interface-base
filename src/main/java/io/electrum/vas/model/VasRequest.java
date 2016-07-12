package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * The data required in all value added service requests
 **/
public abstract class VasRequest {

   protected UUID id = null;
   protected DateTime time = null;
   protected Sender sender = null;

   /**
    * The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122). This field should match the {requestId} url parameter
    **/
   public VasRequest id(UUID id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this transaction, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122). This field should match the {requestId} url parameter")
   @JsonProperty("id")
   @NotNull
   public UUID getId() {
      return id;
   }

   public void setId(UUID id) {
      this.id = id;
   }

   /**
    * The date and time of the request in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public VasRequest time(DateTime time) {
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
    * Data relating to the originator of the transaction
    **/
   public VasRequest sender(Sender sender) {
      this.sender = sender;
      return this;
   }

   @ApiModelProperty(required = true, value = "Data relating to the originator of the transaction")
   @JsonProperty("sender")
   @NotNull
   public Sender getSender() {
      return sender;
   }

   public void setSender(Sender sender) {
      this.sender = sender;
   }
}
