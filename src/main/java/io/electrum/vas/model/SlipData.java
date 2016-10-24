package io.electrum.vas.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Data that may be printed on the customer slip for information purposes
 **/
@ApiModel(description = "Data that may be printed on the customer slip for information purposes")
public class SlipData {

   protected List<SlipLine> messageLines = new ArrayList<SlipLine>();
   protected int slipWidth;

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

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      SlipData slipData = (SlipData) o;
      return Objects.equals(messageLines, slipData.messageLines) && Objects.equals(slipWidth, slipData.slipWidth);
   }

   @Override
   public int hashCode() {
      return Objects.hash(messageLines, slipWidth);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SlipData {\n");

      sb.append("    messageLines: ").append(toIndentedString(messageLines)).append("\n");
      sb.append("    slipWidth: ").append(toIndentedString(slipWidth)).append("\n");
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
