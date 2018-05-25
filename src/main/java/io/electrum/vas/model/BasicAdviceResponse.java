package io.electrum.vas.model;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Basic advice response information.
 * @deprecated Rather use the @link [BasicAdvice} object for Advice responses
 **/
@ApiModel(description = "Basic advice response information.")
public class BasicAdviceResponse extends BasicAdvice {
   /**
    * The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public BasicAdviceResponse id(String id) {
      return (BasicAdviceResponse) super.id(id);
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @JsonProperty("id")
   @NotNull
   @Override
   public String getId() {
      return super.getId();
   }

   @Override
   public void setId(String id) {
      super.setId(id);
   }

   /**
    * The UUID identifying the request that this advice relates to
    **/
   public BasicAdviceResponse requestId(String requestId) {
      return (BasicAdviceResponse) super.requestId(requestId);
   }

   @ApiModelProperty(required = true, value = "The UUID identifying the request that this advice relates to")
   @JsonProperty("requestId")
   @NotNull
   @Override
   public String getRequestId() {
      return super.getRequestId();
   }

   @Override
   public void setRequestId(String requestId) {
      super.setRequestId(requestId);
   }

   /**
    * The date and time of the message in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public BasicAdviceResponse time(DateTime time) {
      return (BasicAdviceResponse) super.time(time);
   }

   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   @Valid
   @Override
   public DateTime getTime() {
      return super.getTime();
   }

   @Override
   public void setTime(DateTime time) {
      super.setTime(time);
   }

   /**
    * The unaltered thirdPartyIdentifiers array as supplied in the related BasicResponse message. Required if
    * thirdPartyIdentifiers field was present in the BasicResponse. If no thirdPartyIdentifiers was received in the
    * BasicResponse or no BasicResponse was received then this should be set to the thirdPartyIdentifiers sent in the
    * original request.
    **/
   public BasicAdviceResponse transactionIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      return (BasicAdviceResponse) super.transactionIdentifiers(transactionIdentifiers);
   }

   @ApiModelProperty(required = true, value = "The unaltered thirdPartyIdentifiers array as supplied in the related BasicResponse message. Required if thirdPartyIdentifiers field was present in the BasicResponse. If no thirdPartyIdentifiers was received in the BasicResponse or no BasicResponse was received then this should be set to the thirdPartyIdentifiers sent in the original request.")
   @JsonProperty("thirdPartyIdentifiers")
   @NotNull
   @Valid
   @Override
   public List<ThirdPartyIdentifier> getThirdPartyIdentifiers() {
      return super.getThirdPartyIdentifiers();
   }

   @Override
   public void setThirdPartyIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      super.setThirdPartyIdentifiers(transactionIdentifiers);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      BasicAdviceResponse vasAdvice = (BasicAdviceResponse) o;
      return Objects.equals(id, vasAdvice.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class BasicAdviceResponse {\n");

      sb.append("    id: ").append(Utils.toIndentedString(id)).append("\n");
      sb.append("    requestId: ").append(Utils.toIndentedString(requestId)).append("\n");
      sb.append("    time: ").append(Utils.toIndentedString(time)).append("\n");
      sb.append("    thirdPartyIdentifiers: ").append(Utils.toIndentedString(thirdPartyIdentifiers)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
