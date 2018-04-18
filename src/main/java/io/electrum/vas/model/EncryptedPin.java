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
@ApiModel(description = "A PIN required to authorise a transaction. EncryptionParameters should be provided where the service will be performing operations on the encrypted PIN, such as PIN translation. Only the PIN block need be provided where the service is expected to forward it to a third party, where the calling client and said third party have agreed upon encryption parameters beforehand.")
public class EncryptedPin {

   private String pinBlock;
   private EncryptionParameters encryptionParameters;

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
    * Parameters pertaining to the generation of the {@link #pinBlock}. Required if the service is to perform any
    * operations on the encrypted PIN, such as translation.
    */
   public EncryptedPin encryptionParameters(EncryptionParameters encryptionParameters) {
      this.encryptionParameters = encryptionParameters;
      return this;
   }

   @JsonProperty("encryptionParameters")
   @ApiModelProperty(value = "Parameters pertaining to the generation of the pinBlock. Required if the service is to perform any operations on the encrypted PIN, such as PIN translation.")
   public EncryptionParameters getEncryptionParameters() {
      return encryptionParameters;
   }

   public void setEncryptionParameters(EncryptionParameters encryptionParameters) {
      this.encryptionParameters = encryptionParameters;
   }

   @ApiModel(description = "Parameters pertaining to the generation of the PIN block. Required if the service is to perform any operations on the encrypted PIN, such as translation.")
   public static class EncryptionParameters {
      private PinBlockFormat pinBlockFormat = PinBlockFormat.ISO_9564_FORMAT_0;
      private String accountNumber;
      private Integer keyIndex;

      /**
       * PIN block format that was used when encrypting the PIN. Defaults to ISO_9564_FORMAT_0.
       */
      public EncryptionParameters pinBlockFormat(PinBlockFormat pinBlockFormat) {
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
       */
      public EncryptionParameters accountNumber(String accountNumber) {
         this.accountNumber = accountNumber;
         return this;
      }

      @JsonProperty("accountNumber")
      @ApiModelProperty(required = true, value = "12 digit account number used when encrypting the PIN. When account number is a card number (PAN), this is the rightmost 12 digits excluding the check digit.")
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
      public EncryptionParameters keyIndex(Integer keyIndex) {
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
         final EncryptionParameters that = (EncryptionParameters) o;
         return pinBlockFormat == that.pinBlockFormat && Objects.equals(accountNumber, that.accountNumber)
                && Objects.equals(keyIndex, that.keyIndex);
      }

      @Override
      public int hashCode() {
         return Objects.hash(pinBlockFormat, accountNumber, keyIndex);
      }

      @Override
      public String toString() {
         final StringBuilder sb = new StringBuilder();
         sb.append("class EncryptionParameters {\n");
         sb.append("    pinBlockFormat: ").append(Utils.toIndentedString(pinBlockFormat)).append("\n");
         sb.append("    accountNumber: ").append(Utils.toIndentedString(accountNumber)).append("\n");
         sb.append("    keyIndex: ").append(Utils.toIndentedString(keyIndex)).append("\n");
         sb.append("}");
         return sb.toString();
      }
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      final EncryptedPin that = (EncryptedPin) o;
      return Objects.equals(pinBlock, that.pinBlock) && Objects.equals(encryptionParameters, that.encryptionParameters);
   }

   @Override
   public int hashCode() {
      return Objects.hash(pinBlock, encryptionParameters);
   }

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder();
      sb.append("class EncryptedPin {\n");
      sb.append("    pinBlock: ").append(Utils.toIndentedString(pinBlock)).append("\n");
      sb.append("    encryptionParameters: ").append(Utils.toIndentedString(encryptionParameters)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
