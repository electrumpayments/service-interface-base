package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.electrum.sdk.masking2.MaskAll;
import io.electrum.sdk.masking2.MaskPan;
import io.electrum.sdk.masking2.Masked;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Model for card-based payments", parent = PaymentMethod.class)
public class CardPayment extends PaymentMethod {

   private String pan = null;
   private String expiryDate = null;
   private PosInfo posInfo = null;
   /**
    * encrytedPin
    *
    * @deprecated As of v3.19.0 due to the addition of the {@link Pin Pin} model, use {@link CardPayment#pin} instead.
    */
   @Deprecated
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
   @Masked(MaskPan.class)
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

   /**
    * Sets the encryptedPin field and returns the CardPayment object.
    *
    * @param encryptedPin
    * @return The CardPayment object with the EncryptedPin set
    * @deprecated As of v3.19.0 due to the addition of the {@link Pin Pin} model, use {@link CardPayment#pin(Pin pin)}
    *             instead.
    */
   @Deprecated
   public CardPayment encryptedPin(EncryptedPin encryptedPin) {
      this.encryptedPin = encryptedPin;
      return this;
   }

   /**
    * The encrypted PIN associated with this card in HEX format.
    *
    * @return encryptedPin
    * @deprecated As of v3.19.0 due to the addition of the {@link Pin Pin} model, use {@link CardPayment#getPin()}
    *             instead.
    **/
   @ApiModelProperty(value = "The encrypted pin number associated with the card in HEX format.")
   @JsonProperty("encryptedPin")
   @Deprecated
   public EncryptedPin getEncryptedPin() {
      return encryptedPin;
   }

   /**
    * Sets the encryptedPin field.
    *
    * @param encryptedPin
    * @deprecated As of v3.19.0 due to the addition of the {@link Pin Pin} model, use {@link CardPayment#setPin(Pin)}
    *             instead.
    */
   @Deprecated
   public void setEncryptedPin(EncryptedPin encryptedPin) {
      this.encryptedPin = encryptedPin;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      if (!super.equals(o))
         return false;
      CardPayment that = (CardPayment) o;
      return Objects.equals(pan, that.pan) && Objects.equals(expiryDate, that.expiryDate)
            && Objects.equals(posInfo, that.posInfo) && Objects.equals(encryptedPin, that.encryptedPin);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), pan, expiryDate, posInfo, encryptedPin);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class CardPayment {\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    issuer: ").append(Utils.toIndentedString(issuer)).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    proxy: ").append(Utils.toIndentedString(proxy)).append("\n");
      sb.append("    proxyType: ").append(Utils.toIndentedString(proxyType)).append("\n");
      sb.append("    pan: ").append(Utils.toIndentedString(new MaskAll().mask(pan))).append("\n");
      sb.append("    expiryDate: ").append(Utils.toIndentedString(expiryDate)).append("\n");
      sb.append("    posInfo: ").append(Utils.toIndentedString(posInfo)).append("\n");
      sb.append("    encryptedPin: ").append(Utils.toIndentedString(encryptedPin)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
