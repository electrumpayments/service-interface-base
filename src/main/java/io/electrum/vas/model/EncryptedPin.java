package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * A PIN required to authorise a transaction.
 **/
@ApiModel(description = "A PIN required to authorise a transaction.")
public class EncryptedPin {

   private String pinBlock;
   private PinBlockFormat pinBlockFormat = PinBlockFormat.ISO_9564_FORMAT_0;
   private String accountNumber;
   private String keyName;
   private Integer keyIndex;
   private DukptFields dukptFields;

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
   @NotNull
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
   public EncryptedPin accountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
   }

   @JsonProperty("accountNumber")
   @ApiModelProperty(required = true, value = "12 digit account number used when encrypting the PIN. When account number is a card number (PAN), this is the rightmost 12 digits excluding the check digit.")
   @NotNull
   public String getAccountNumber() {
      return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
   }

   /**
    * Name of the key under which the PIN block is currently encrypted.
    */
   public EncryptedPin keyName(String keyName) {
      this.keyName = keyName;
      return this;
   }

   @JsonProperty("keyName")
   @ApiModelProperty(value = "Name of the key under which the PIN block is currently encrypted.")
   public String getKeyName() {
      return keyName;
   }

   public void setKeyName(String keyName) {
      this.keyName = keyName;
   }

   /**
    * Index of the key under which the PIN block is currently encrypted.
    */
   public EncryptedPin keyIndex(Integer keyIndex) {
      this.keyIndex = keyIndex;
      return this;
   }

   @JsonProperty("keyIndex")
   @ApiModelProperty(value = "Index of the key under which the PIN block is currently encrypted.")
   public Integer getKeyIndex() {
      return keyIndex;
   }

   public void setKeyIndex(Integer keyIndex) {
      this.keyIndex = keyIndex;
   }

   /**
    * Fields required only for DUKPT (Derived unique key per transaction) PINs.
    */
   public EncryptedPin dukptFields(DukptFields dukptFields) {
      this.dukptFields = dukptFields;
      return this;
   }

   @JsonProperty("dukptFields")
   @ApiModelProperty(value = "Fields required only for DUKPT (Derived unique key per transaction) PINs.")
   public DukptFields getDukptFields() {
      return dukptFields;
   }

   public void setDukptFields(DukptFields dukptFields) {
      this.dukptFields = dukptFields;
   }

   /**
    * Additional fields required for DUKPT (Derived Unique Key Per Transaction) PINs
    */
   public static class DukptFields {

      private String keySetId;
      private String ksn;
      private String terminalId;

      /**
       * Key set ID
       */
      public DukptFields keySetId(String keySetId) {
         this.keySetId = keySetId;
         return this;
      }

      @JsonProperty("keySetId")
      @ApiModelProperty(required = true, value = "Key set ID.")
      @NotNull
      public String getKeySetId() {
         return keySetId;
      }

      public void setKeySetId(String keySetId) {
         this.keySetId = keySetId;
      }

      /**
       * Key Serial Number (KSN)
       */
      public DukptFields ksn(String ksn) {
         this.ksn = ksn;
         return this;
      }

      @JsonProperty("ksn")
      @ApiModelProperty(required = true, value = "Key Serial Number (KSN).")
      @NotNull
      public String getKsn() {
         return ksn;
      }

      public void setKsn(String ksn) {
         this.ksn = ksn;
      }

      /**
       * Terminal ID
       */
      public DukptFields terminalId(String terminalId) {
         this.terminalId = terminalId;
         return this;
      }

      @JsonProperty("terminalId")
      @ApiModelProperty(required = true, value = "Terminal ID.")
      @NotNull
      public String getTerminalId() {
         return terminalId;
      }

      public void setTerminalId(String terminalId) {
         this.terminalId = terminalId;
      }
   }
}
