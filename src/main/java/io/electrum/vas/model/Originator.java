package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import java.util.Objects;

/**
 * The Originator object encapsulates data relating to the originator of the transaction
 */
@ApiModel(description = "The Originator object encapsulates data relating to the originator of the transaction")
public class Originator {

   private Institution institution = null;
   private String terminalId = null;
   private Merchant merchant = null;
   private String operatorId = null;

   /**
    * The institution originating the request, as issued by Electrum
    **/
   public Originator institution(Institution institution) {
      this.institution = institution;
      return this;
   }

   @ApiModelProperty(required = true, value = "The institution originating the request, as issued by Electrum")
   @JsonProperty("institution")
   @NotNull
   @Valid
   public Institution getInstitution() {
      return institution;
   }

   public void setInstitution(Institution institution) {
      this.institution = institution;
   }

   /**
    * The id that uniquely identifies each device or system in an originator's institution capable of sending requests.
    * Required for transactions initiated from physical card entry or point-of-sale devices
    **/
   public Originator terminalId(String terminalId) {
      this.terminalId = terminalId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The ID that uniquely identifies each device or system in an originator's institution capable of sending requests. Required for transactions initiated from physical card entry or point-of-sale devices")
   @JsonProperty("terminalId")
   @Length(min = 8, max = 8)
   @NotNull
   public String getTerminalId() {
      return terminalId;
   }

   public void setTerminalId(String terminalId) {
      this.terminalId = terminalId;
   }

   /**
    * Merchant data. Required if available
    **/
   public Originator merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(required = true, value = "Merchant data. Required if available")
   @JsonProperty("merchant")
   @NotNull
   @Valid
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   /**
    * The ID that uniquely identifies the person operating the terminal specified by the terminalId field.
    * @since 3.28.0
    */
   public Originator operatorId(String operatorId) {
      this.operatorId = operatorId;
      return this;
   }

   @ApiModelProperty(required = false, value = "The ID that uniquely identifies the person operating the terminal specified by the terminalId field.")
   @JsonProperty("operatorId")
   @Length(max = 30)
   public String getOperatorId() {
      return operatorId;
   }

   public void setOperatorId(String operatorId) {
      this.operatorId = operatorId;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Originator originator = (Originator) o;
      return Objects.equals(institution, originator.institution) && Objects.equals(terminalId, originator.terminalId)
            && Objects.equals(merchant, originator.merchant) && Objects.equals(operatorId, originator.operatorId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(institution, terminalId, merchant, operatorId);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Originator {\n");
      sb.append("    institution: ").append(Utils.toIndentedString(institution)).append('\n');
      sb.append("    terminalId: ").append(Utils.toIndentedString(terminalId)).append('\n');
      sb.append("    merchant: ").append(Utils.toIndentedString(merchant)).append('\n');
      sb.append("    operatorId: ").append(Utils.toIndentedString(operatorId)).append('\n');
      sb.append("}");
      return sb.toString();
   }
}
