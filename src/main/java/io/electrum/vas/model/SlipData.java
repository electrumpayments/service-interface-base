package io.electrum.vas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data that may be printed on the customer slip for information purposes
 **/
@ApiModel(description = "Data that may be printed on the customer slip for information purposes")
public class SlipData {

   protected List<SlipLine> messageLines = new ArrayList<SlipLine>();
   protected int slipWidth;
   protected String issuerReference = null;

   /**
    * An array of free text lines to be printed on the customer slip
    **/
   public SlipData messageLines(List<SlipLine> messageLines) {
      this.messageLines = messageLines;
      return this;
   }

   @ApiModelProperty(value = "An array of text lines and optional formatting to be printed on the customer slip.")
   @JsonProperty("messageLines")
   public List<SlipLine> getMessageLines() {
      return messageLines;
   }

   public void setMessageLines(List<SlipLine> messageLines) {
      this.messageLines = messageLines;
   }

   /**
    * The width of the slip in normal (unformatted) characters.
    **/
   public SlipData slipWidth(int slipWidth) {
      this.slipWidth = slipWidth;
      return this;
   }

   @ApiModelProperty(value = "The width of the slip in normal (unformatted) characters.")
   @JsonProperty("slipWidth")
   public int getSlipWidth() {
      return slipWidth;
   }

   public void setSlipWidth(int slipWidth) {
      this.slipWidth = slipWidth;
   }

   /**
    * An identifier that is printed on the customer slip and uniquely identifies the payment on the service provider's
    * system. This value is used by the customer to request a refund when the service supports this function, and it is
    * thus important that this number is unique.
    **/
   public SlipData issuerReference(String issuerReference) {
      this.issuerReference = issuerReference;
      return this;
   }

   @ApiModelProperty(value = "An identifier that is printed on the customer slip and uniquely identifies the payment on the service provider's system. This value is used by the customer to request a refund when the service supports this function, and it is thus important that this number is unique.")
   @JsonProperty("issuerReference")
   @Pattern(regexp = "[A-Z0-9]{1,40}")
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
      return Objects.equals(messageLines, slipData.messageLines) && Objects.equals(slipWidth, slipData.slipWidth)
            && Objects.equals(issuerReference, slipData.issuerReference);
   }

   @Override
   public int hashCode() {
      return Objects.hash(messageLines, slipWidth, issuerReference);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SlipData {\n");

      sb.append("    messageLines: ").append(Utils.toIndentedString(messageLines)).append("\n");
      sb.append("    slipWidth: ").append(Utils.toIndentedString(slipWidth)).append("\n");
      sb.append("    issuerReference: ").append(Utils.toIndentedString(issuerReference)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
