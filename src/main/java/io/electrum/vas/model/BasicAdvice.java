package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.joda.time.DateTime;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The data required in all advice messages
 **/
@ApiModel(description = "The data required in all advice messages")
public class BasicAdvice implements VasMessage {

   protected String id;
   protected String requestId;
   protected DateTime time;
   protected List<ThirdPartyIdentifier> thirdPartyIdentifiers = new ArrayList<ThirdPartyIdentifier>();
   protected String stan = null;
   protected String rrn = null;
   protected Amounts amounts = null;

   /**
    * The randomly generated UUID identifying this advice, as defined for a variant 4 UUID in [RFC
    * 4122](https://tools.ietf.org/html/rfc4122)
    **/
   public BasicAdvice id(String id) {
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
   public BasicAdvice requestId(String requestId) {
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
   public BasicAdvice time(DateTime time) {
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
   public BasicAdvice transactionIdentifiers(List<ThirdPartyIdentifier> transactionIdentifiers) {
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

   /**
    * The System Trace Audit Number can be used to locate transactions across different systems.
    */
   public BasicAdvice stan(String stan) {
      this.stan = stan;
      return this;
   }

   @ApiModelProperty(required = false, value = "The System Trace Audit Number can be used to locate transactions across different systems.")
   @JsonProperty("stan")
   public String getStan() {
      return stan;
   }

   public void setStan(String stan) {
      this.stan = stan;
   }

   /**
    * This is a reference set by the original source of the transaction.
    */
   public BasicAdvice rrn(String rrn) {
      this.rrn = rrn;
      return this;
   }

   @ApiModelProperty(required = false, value = "This is a reference set by the original source of the transaction.")
   @JsonProperty("rrn")
   public String getRrn() {
      return rrn;
   }

   public void setRrn(String rrn) {
      this.rrn = rrn;
   }

   public BasicAdvice amounts(Amounts amounts) {
      this.amounts = amounts;
      return this;
   }

   @ApiModelProperty(required = false, value = "These are amounts that are part of the advice message" +
           " It doesnt make sense to populate requestAmount even if its possible. approvedAmount contains the final transaction amount(amount that was payed out), " +
           "if approvedAmount is not set then it means that this is a full reversal(nothing was payed out).")
   @JsonProperty("amounts")
   public Amounts getAmounts() {
      return amounts;
   }

   public void setAmounts(Amounts amounts) {
      this.amounts = amounts;
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
      sb.append("    stan: ").append(Utils.toIndentedString(stan));
      sb.append("    rrn: ").append(Utils.toIndentedString(rrn));
      sb.append("    amounts: ").append(Utils.toIndentedString(amounts)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
