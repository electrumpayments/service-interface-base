package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Base model for all payment types", discriminator = "type", subTypes = { An32TokenPayment.class,
      LoyaltyCardPayment.class, CardPayment.class, AccountPayment.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
// For the sake of correct deserialisation, we need to map from values of type to child model classes explicitly
@JsonSubTypes({ @JsonSubTypes.Type(value = An32TokenPayment.class, name = "AN_32_TOKEN"),
      @JsonSubTypes.Type(value = LoyaltyCardPayment.class, name = "LOYALTY_CARD"),
      @JsonSubTypes.Type(value = AccountPayment.class, name = "ACCOUNT"),
      @JsonSubTypes.Type(value = CardPayment.class, name = "CARD"),
      @JsonSubTypes.Type(value = RewardPayment.class, name = "REWARD") })
public class PaymentMethod {

   public enum PaymentMethodType {
      AN_32_TOKEN("AN_32_TOKEN"), LOYALTY_CARD("LOYALTY_CARD"), CARD("CARD"), ACCOUNT("ACCOUNT"), REWARD("REWARD");

      private final String value;

      PaymentMethodType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   protected PaymentMethodType type = null;

   protected String name;

   protected LedgerAmount amount;

   @ApiModelProperty(value = "The specific method of payment used")
   @JsonProperty("name")
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @ApiModelProperty(required = true, value = "The general method of payment used")
   @JsonProperty("type")
   @NotNull
   public PaymentMethodType getType() {
      return type;
   }

   public void setType(PaymentMethodType type) {
      this.type = type;
   }

   @ApiModelProperty(required = true, value = "Ledger amount of the payment")
   @JsonProperty("amount")
   @NotNull
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   @Override
   public int hashCode() {
      return Objects.hash(type);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      PaymentMethod paymentMethod = (PaymentMethod) o;
      return Objects.equals(this.type, paymentMethod.type) && Objects.equals(this.name, paymentMethod.name)
            && Objects.equals(this.amount, paymentMethod.amount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentMethod {\n");
      sb.append("    name: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
