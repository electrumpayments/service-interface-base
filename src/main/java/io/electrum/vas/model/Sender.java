package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

/**
 * The Sender object encapsulates data relating to the originator of the transaction
 */
@ApiModel(description = "The Sender object encapsulates data relating to the originator of the transaction")
public class Sender {

   private Institution institution = null;
   private String terminalId = null;
   private String referenceNumber = null;
   private Merchant merchant = null;

   /**
    * The institution originating the request, as issued by Electrum
    **/
   public Sender institution(Institution institution) {
      this.institution = institution;
      return this;
   }

   @ApiModelProperty(required = true, value = "The institution originating the request, as issued by Electrum")
   @JsonProperty("institution")
   @NotNull
   public Institution getInstitution() {
      return institution;
   }

   public void setInstitution(Institution institution) {
      this.institution = institution;
   }

   /**
    * The id that uniquely identifies each device or system in a sender institution capable of sending requests.
    * Required for transactions initiated from physical card entry or point-of-sale devices
    **/
   public Sender senderId(String terminalId) {
      this.terminalId = terminalId;
      return this;
   }

   @ApiModelProperty(required = true, value = "The ID that uniquely identifies each device or system in a sender institution capable of sending requests. Required for transactions initiated from physical card entry or point-of-sale devices")
   @JsonProperty("terminalId")
   @Pattern(regexp = "[a-zA-Z0-9]{8}")
   public String getTerminalId() {
      return terminalId;
   }

   public void setTerminalId(String terminalId) {
      this.terminalId = terminalId;
   }

   /**
    * A reference number useful to the sender for identifying transactions, also knows as a retrieval reference number
    **/
   public Sender referenceNumber(String referenceNumber) {
      this.referenceNumber = referenceNumber;
      return this;
   }

   @ApiModelProperty(value = "A reference number useful to the sender for identifying transactions, also knows as a retrieval reference number")
   @JsonProperty("referenceNumber")
   @Pattern(regexp = "[A-Za-z0-9 ]{0,12}")
   public String getReferenceNumber() {
      return referenceNumber;
   }

   public void setReferenceNumber(String referenceNumber) {
      this.referenceNumber = referenceNumber;
   }

   /**
    * Merchant data. Required if available
    **/
   public Sender merchant(Merchant merchant) {
      this.merchant = merchant;
      return this;
   }

   @ApiModelProperty(value = "Merchant data. Required if available")
   @JsonProperty("merchant")
   public Merchant getMerchant() {
      return merchant;
   }

   public void setMerchant(Merchant merchant) {
      this.merchant = merchant;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Sender sender = (Sender) o;
      return Objects.equals(institution, sender.institution) && Objects.equals(terminalId, sender.terminalId)
            && Objects.equals(merchant, sender.merchant);
   }

   @Override
   public int hashCode() {
      return Objects.hash(institution, terminalId, merchant);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Sender {\n");
      sb.append("    institution: ").append(toIndentedString(institution)).append("\n");
      sb.append("    terminalId: ").append(toIndentedString(terminalId)).append("\n");
      sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
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
