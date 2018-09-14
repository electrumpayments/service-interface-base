package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.vas.Utils;
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

   @Override
   public int hashCode() {
      return Objects.hash(pan, expiryDate, posInfo, encryptedPin, name, type);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      CardPayment cardPayment = (CardPayment) o;
      return Objects.equals(this.type, cardPayment.type) && Objects.equals(this.name, cardPayment.name)
            && Objects.equals(this.pan, cardPayment.pan) && Objects.equals(this.expiryDate, cardPayment.expiryDate)
            && Objects.equals(this.posInfo, cardPayment.posInfo)
            && Objects.equals(this.encryptedPin, cardPayment.encryptedPin);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class CardPayment {\n");

      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    pan: ").append(Utils.toIndentedString(pan)).append("\n");
      sb.append("    expiryDate: ").append(Utils.toIndentedString(expiryDate)).append("\n");
      sb.append("    posInfo: ").append(Utils.toIndentedString(posInfo)).append("\n");
      sb.append("    encryptedPin: ").append(Utils.toIndentedString(encryptedPin)).append("\n");

      sb.append("}");
      return sb.toString();
   }
}
