package io.electrum.vas.model;

import java.util.ArrayList;
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
 **/
@ApiModel(description = "Basic advice response information.")
public class BasicAdviceResponse {

   protected String id;
   protected String requestId;
   protected DateTime time;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();

   /**
    * The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public BasicAdviceResponse id(String id) {
      this.id = id;
      return this;
   }

   @ApiModelProperty(required = true, value = "The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC 4122](https://tools.ietf.org/html/rfc4122)")
   @JsonProperty("id")
   @NotNull
   public String getId() {
      return id;
   }

   public void setId(String id) {
      this.id = id;
   }

   /**
    * The UUID identifying the request that this advice relates to
    **/
   public BasicAdviceResponse requestId(String requestId) {
      this.requestId = requestId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The UUID identifying the request that this advice relates to")
   @JsonProperty("requestId")
   @NotNull
   public String getRequestId() {
      return requestId;
   }

   public void setRequestId(String requestId) {
      this.requestId = requestId;
   }

   /**
    * The date and time of the message in UTC, as recorded by the sender. The format shall be as defined for date-time
    * in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional
    * time-secfrac be included up to millisecond precision
    **/
   public BasicAdviceResponse time(DateTime time) {
      this.time = time;
      return this;
   }

   @ApiModelProperty(required = true, value = "The date and time of the message as recorded by the sender. The format shall be as defined for date-time in [RFC 3339 section 5.6](https://tools.ietf.org/html/rfc3339#section-5.6). It is recommended that the optional time-secfrac be included up to millisecond precision")
   @JsonProperty("time")
   @NotNull
   @Valid
   public DateTime getTime() {
      return time;
   }

   public void setTime(DateTime time) {
      this.time = time;
   }

   /**
    * The unaltered thirdPartyIdentifiers array as supplied in the related BasicResponse message. Required if
    * thirdPartyIdentifiers field was present in the BasicResponse. If no thirdPartyIdentifiers was received in the
    * BasicResponse or no BasicResponse was received then this should be set to the thirdPartyIdentifiers sent in the
    * original request.
    **/
   public BasicAdviceResponse transactionIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
      this.thirdPartyIdentifiers = transactionIdentifiers;
      return this;
   }

   @ApiModelProperty(required = true, value = "The unaltered thirdPartyIdentifiers array as supplied in the related BasicResponse message. Required if thirdPartyIdentifiers field was present in the BasicResponse. If no thirdPartyIdentifiers was received in the BasicResponse or no BasicResponse was received then this should be set to the thirdPartyIdentifiers sent in the original request.")
   @JsonProperty("thirdPartyIdentifiers")
   @NotNull
   @Valid
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
