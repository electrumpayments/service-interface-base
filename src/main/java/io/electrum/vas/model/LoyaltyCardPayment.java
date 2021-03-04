package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@ApiModel(description = "Model for payments made using loyalty programme cards", parent = PaymentMethod.class)
public class LoyaltyCardPayment extends PaymentMethod {

   private String cardNumber = null;

   public LoyaltyCardPayment() {
      // The method used to deserialise child models based on a discriminator leaves the discriminator field null
      // So we set it explicitly in the default constructor
      setType(PaymentMethodType.LOYALTY_CARD);
   }

   @ApiModelProperty(required = true, value = "Primary account number of the loyalty programme card used to make a payment")
   @JsonProperty("cardNumber")
   @NotNull
   @Pattern(regexp = "[0-9]{16}")
   public String getCardNumber() {
      return cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      if (!super.equals(o)) return false;
      LoyaltyCardPayment that = (LoyaltyCardPayment) o;
      return Objects.equals(cardNumber, that.cardNumber);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), cardNumber);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class LoyaltyCardPayment {\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    issuer: ").append(Utils.toIndentedString(issuer)).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    proxy: ").append(Utils.toIndentedString(proxy)).append("\n");
      sb.append("    proxyType: ").append(Utils.toIndentedString(proxyType)).append("\n");
      sb.append("    cardNumber: ").append(Utils.toIndentedString(cardNumber)).append("\n");
      sb.append('}');
      return sb.toString();
   }
}
