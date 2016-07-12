package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Data that may be printed on the custoemr slip for information purposes
 **/
@ApiModel(description = "Data that may be printed on the custoemr slip for information purposes")
public class SlipData {

   private List<String> messageLines = new ArrayList<>();
   private String phoneNumber = null;
   private String issuerReference = null;

   /**
    * An array of free text lines to be printed on the customer slip
    **/
   public SlipData messageLines(List<String> messageLines) {
      this.messageLines = messageLines;
      return this;
   }

   @ApiModelProperty(value = "An array of free text lines to be printed on the customer slip")
   @JsonProperty("messageLines")
   public List<String> getMessageLines() {
      return messageLines;
   }

   public void setMessageLines(List<String> messageLines) {
      this.messageLines = messageLines;
   }

   /**
    * The call centre phone number
    **/
   public SlipData phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
   }

   @ApiModelProperty(value = "The call centre phone number")
   @JsonProperty("phoneNumber")
   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   /**
    * An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer's
    * system. This value is used by the customer to request a refund when the service supports this function, and it is
    * thus important that this number is unique
    **/
   public SlipData issuerReference(String issuerReference) {
      this.issuerReference = issuerReference;
      return this;
   }

   @ApiModelProperty(required = true, value = "An identifier that is printed on the customer slip and uniquely identifies the payment on the bill issuer's system. This value is used by the customer to request a refund when the service supports this function, and it is thus important that this number is unique")
   @JsonProperty("issuerReference")
   @NotNull
   @Pattern(regexp = "[A-Z0-9]{1,20}")
   public String getIssuerReference() {
      return issuerReference;
   }

   public void setIssuerReference(String issuerReference) {
      this.issuerReference = issuerReference;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      SlipData slipData = (SlipData) o;
      return Objects.equals(messageLines, slipData.messageLines) && Objects.equals(phoneNumber, slipData.phoneNumber)
            && Objects.equals(issuerReference, slipData.issuerReference);
   }

   @Override
   public int hashCode() {
      return Objects.hash(messageLines, phoneNumber, issuerReference);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SlipData {\n");

      sb.append("    messageLines: ").append(toIndentedString(messageLines)).append("\n");
      sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
      sb.append("    issuerReference: ").append(toIndentedString(issuerReference)).append("\n");
      sb.append("}");
      return sb.toString();
   }

   /**
    * Convert the given object to string with each line indented by 4 spaces (except the first line).
    */
   private String toIndentedString(Object o) {
      if (o == null) {
         return "null";
      }
      return o.toString().replace("\n", "\n    ");
   }
}
