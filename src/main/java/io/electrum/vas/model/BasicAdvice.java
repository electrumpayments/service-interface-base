package io.electrum.vas.model;

import io.electrum.vas.Utils;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The data required in all value added service requests
 **/
@ApiModel(description = "The data required in all value added service requests")
public class BasicAdvice {

   protected UUID id = null;
   protected UUID requestId = null;
   protected DateTime time = null;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = null;

   /**
    * The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public BasicAdvice id(UUID id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
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
   public BasicAdvice requestId(UUID requestId) {
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
    * The date and time of the message in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public BasicAdvice time(DateTime time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   public DateTime getTime() {
      return time;
   }

   public void setTime(DateTime time) {
      this.time = time;
   }

   /**
    * The unaltered thirdPartyIdentifiers array as supplied in the related BasicResponse message. Required if thirdPartyIdentifiers field was
    * present in the BasicResponse. If no thirdPartyIdentifiers was received in the BasicResponse or no BasicResponse was received
    * then this should be set to the thirdPartyIdentifiers sent in the original request.
    **/
   public BasicAdvice transactionIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
      return this;
   }

   @ApiModelProperty(required = true, value = "The unaltered thirdPartyIdentifiers array as supplied in the related BasicResponse message. Required if thirdPartyIdentifiers field was present in the BasicResponse. If no thirdPartyIdentifiers was received in the BasicResponse or no BasicResponse was received then this should be set to the thirdPartyIdentifiers sent in the original request.")
   @JsonProperty("thirdPartyIdentifiers")
   @NotNull
   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return thirdPartyIdentifiers;
   }

   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      BasicAdvice vasAdvice = (BasicAdvice) o;
      return Objects.equals(id, vasAdvice.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BasicAdvice {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
