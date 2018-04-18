package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

/**
 * A PIN required to authorise a transaction.
 **/
@ApiModel(description = "A PIN required to authorise a transaction. Please read the documentation for all required fields in the event that a PIN block is simply to be passed through to a third party, where the invoking client and said third party have previously agreed on all the parameters used when generating the PIN.")
public class EncryptedPin {

   private String pinBlock;
   private PinBlockFormat pinBlockFormat = PinBlockFormat.ISO_9564_FORMAT_0;
   private String accountNumber;
   private Integer keyIndex;

   /**
    * Hexadecimal string representing the encrypted PIN to be used.
    */
   public EncryptedPin pinBlock(String pinBlock) {
      this.pinBlock = pinBlock;
      return this;
   }

   @JsonProperty("pinBlock")
   @ApiModelProperty(required = true, value = "Hexadecimal string representing the encrypted PIN to be used.")
   @NotNull
   @Pattern(regexp = "[a-fA-F0-9]{16}")
   public String getPinBlock() {
      return pinBlock;
   }

   public void setPinBlock(String pinBlock) {
      this.pinBlock = pinBlock;
   }

   /**
    * PIN block format that was used when encrypting the PIN. Defaults to ISO_9564_FORMAT_0.
    */
   private EncryptedPin pinBlockFormat(PinBlockFormat pinBlockFormat) {
      this.pinBlockFormat = pinBlockFormat;
      return this;
   }

   @JsonProperty("pinBlockFormat")
   @ApiModelProperty(value = "PIN block format that was used when encrypting the PIN. Defaults to ISO_9564_FORMAT_0.")
   @XmlElement(defaultValue = "ISO_9564_FORMAT_0")
   public PinBlockFormat getPinBlockFormat() {
      return pinBlockFormat;
   }

   public void setPinBlockFormat(PinBlockFormat pinBlockFormat) {
      this.pinBlockFormat = pinBlockFormat;
   }

   /**
    * 12 digit account number used when encrypting the PIN.
    * When account number is a card number (PAN), this is the rightmost 12 digits excluding the check digit.
    * If the ultimate goal is to pass only the pinBlock to a third party system, where the accountNumber used has been
    * agreed upon between the invoking client and said third party, then this field may be set to twelve zeros
    * ("000000000000").
    */
   public EncryptedPin accountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
   }

   @JsonProperty("accountNumber")
   @ApiModelProperty(required = true, value = "12 digit account number used when encrypting the PIN. When account number is a card number (PAN), this is the rightmost 12 digits excluding the check digit. If the ultimate goal is to pass only the pinBlock to a third party system, where the accountNumber used has been agreed upon between the invoking client and said third party, then this field may be set to twelve zeros (\"000000000000\").")
   @NotNull
   @Pattern(regexp = "[0-9]{12}")
   public String getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   /**
    * Index of the key under which the PIN block is encrypted. Where keys are exchanged in TR-31 KeyBlock format,
    * this should be set to the key version number field of the key used for encryption. If this field is not populated,
    * the most recently exchanged key will be used. Note that omitting this field may require a higher level of
    * synchronization during automated key exchange in some environments.
    */
   public EncryptedPin keyIndex(Integer keyIndex) {
      this.keyIndex = keyIndex;
      return this;
   }

   @JsonProperty("keyIndex")
   @ApiModelProperty(value = "Index of the key under which the PIN block is encrypted. Where keys are exchanged in TR-31 KeyBlock format, this should be set to the key version number field of the key used for encryption. If this field is not populated, the most recently exchanged key will be used. Note that omitting this field may require a higher level of synchronization during automated key exchange in some environments.")
   public Integer getKeyIndex() {
      return keyIndex;
   }

   public void setKeyIndex(Integer keyIndex) {
      this.keyIndex = keyIndex;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      final EncryptedPin that = (EncryptedPin) o;
      return Objects.equals(pinBlock, that.pinBlock) && pinBlockFormat == that.pinBlockFormat && Objects.equals(accountNumber,
            that.accountNumber) && Objects.equals(keyIndex, that.keyIndex);
   }

   @Override
   public int hashCode() {
      return Objects.hash(pinBlock, pinBlockFormat, accountNumber, keyIndex);
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("class EncryptedPin {\n");
      sb.append("    pinBlock: ").append(Utils.toIndentedString(pinBlock)).append("\n");
      sb.append("    pinBlockFormat: ").append(Utils.toIndentedString(pinBlockFormat)).append("\n");
      sb.append("    accountNumber: ").append(Utils.toIndentedString(accountNumber)).append("\n");
      sb.append("    keyIndex: ").append(Utils.toIndentedString(keyIndex)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
