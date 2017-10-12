package io.electrum.vas.model;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Used to indicate barcode information for a {@link SlipLine}
 * 
 */
@ApiModel(description = "Used to indicate barcode information for a slip line.")
public class SlipBarcode {
   
   private String data;
   private String encoding;
   
   public SlipBarcode data(String data) {
      this.data = data;
      return this;
   }

   /**
    * Data to be encoded in the barcode
    * 
    * @return data
    */
   @ApiModelProperty(required = true, value = "Data to be encoded in the barcode")
   @NotNull
   public String getData() {
      return data;
   }
   
   public void setData(String data) {
      this.data = data;
   }
   
   public SlipBarcode encoding(String encoding) {
      this.encoding = encoding;
      return this;
   }

   /**
    * Specifies the encoding used in the barcode
    * 
    * @return
    */
   @ApiModelProperty(required = true, value = "Specifies the encoding used in the barcode")
   public String getEncoding() {
      return encoding;
   }
   
   public void setEncoding(String encoding) {
      this.encoding = encoding;
   }
   
   @Override
   public boolean equals(java.lang.Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      SlipBarcode slipBarcode = (SlipBarcode) o;
      return Objects.equals(this.data, slipBarcode.data) && Objects.equals(this.encoding, slipBarcode.encoding);
   }

   @Override
   public int hashCode() {
      return Objects.hash(data, encoding);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class SlipBarcode {\n");

      sb.append("    data: ").append(Utils.toIndentedString(data)).append("\n");
      sb.append("    encoding: ").append(Utils.toIndentedString(encoding)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
