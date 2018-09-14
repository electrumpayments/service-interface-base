package io.electrum.vas.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model for card-based payments", parent = PaymentMethod.class)
public class CardPayment extends PaymentMethod {

   private String pan = null;
   private String expiryDate = null;
   private PosInfo posInfo = null;
   private EncryptedPin encryptedPin = null;

   public CardPayment() {
      setType(PaymentMethodType.CARD);
   }

   /**
    * Primary account number that uniquely identifies this card.
    *
    * @return pan
    **/
   @ApiModelProperty(required = true, value = "Primary account number that uniquely identifies this card.")
   @JsonProperty("pan")
   @NotNull
   @Pattern(regexp = "[0-9]{1,19}")
   public String getPan() {
      return pan;
   }

   public void setPan(String pan) {
      this.pan = pan;
   }

   public CardPayment expiryDate(String expiryDate) {
      this.expiryDate = expiryDate;
      return this;
   }

   /**
    * The card expiry date, in YYMM format.
    *
    * @return expiryDate
    **/
   @ApiModelProperty(value = "The card expiry date, in YYMM format.")
   @JsonProperty("expiryDate")
   @Pattern(regexp = "[0-9]{4}")
   public String getExpiryDate() {
      return expiryDate;
   }

   public void setExpiryDate(String expiryDate) {
      this.expiryDate = expiryDate;
   }

   /**
    * Information about the POS
    *
    * @return posInfo
    */
   public PosInfo getPosInfo() {
      return posInfo;
   }

   public void setPosInfo(PosInfo posInfo) {
      this.posInfo = posInfo;
   }

   public CardPayment encryptedPin(EncryptedPin encryptedPin) {
      this.encryptedPin = encryptedPin;
      return this;
   }

   /**
    * The encrypted pin number associated with the card in HEX format.
    *
    * @return encryptedPin
    **/
   @ApiModelProperty(value = "The encrypted pin number associated with the card in HEX format.")
   @JsonProperty("encryptedPin")
   public EncryptedPin getEncryptedPin() {
      return encryptedPin;
   }

   public void setEncryptedPin(EncryptedPin encryptedPin) {
      this.encryptedPin = encryptedPin;
   }

}
