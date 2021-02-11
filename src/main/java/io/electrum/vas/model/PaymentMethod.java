package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.sdk.masking2.Masked;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Base model for all payment types", discriminator = "type", subTypes = { An32TokenPayment.class,
      LoyaltyCardPayment.class, CardPayment.class, AccountPayment.class })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
// For the sake of correct deserialisation, we need to map from values of type to child model classes explicitly
@JsonSubTypes({ @JsonSubTypes.Type(value = AccountPayment.class, name = "ACCOUNT"),
      @JsonSubTypes.Type(value = An32TokenPayment.class, name = "AN_32_TOKEN"),
      @JsonSubTypes.Type(value = LoyaltyCardPayment.class, name = "LOYALTY_CARD"),
      @JsonSubTypes.Type(value = CardPayment.class, name = "CARD"),
      @JsonSubTypes.Type(value = RewardPayment.class, name = "REWARD"),
      @JsonSubTypes.Type(value = WalletPayment.class, name = "WALLET") })
public class PaymentMethod {

   public enum PaymentMethodType {
      AN_32_TOKEN("AN_32_TOKEN"),
      LOYALTY_CARD("LOYALTY_CARD"),
      CARD("CARD"),
      ACCOUNT("ACCOUNT"),
      REWARD("REWARD"),
      WALLET("WALLET");

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

   protected Institution issuer;

   protected Pin pin;

   protected String proxy;

   protected ProxyType proxyType;

   @ApiModelProperty(value = "The specific method of payment used")
   @JsonProperty("name")
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public PaymentMethod name(String name) {
      this.setName(name);
      return this;
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

   public PaymentMethod type(PaymentMethodType type) {
      this.setType(type);
      return this;
   }

   @ApiModelProperty(value = "Ledger amount of the payment")
   @JsonProperty("amount")
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   public PaymentMethod amount(LedgerAmount amount) {
      this.setAmount(amount);
      return this;
   }

   @ApiModelProperty(value = "The institution which is responsible for managing this payment method (e.g. the card issuer, the wallet provider, the token provider etc.)")
   @JsonProperty("issuer")
   public Institution getIssuer() {
      return issuer;
   }

   public void setIssuer(Institution issuer) {
      this.issuer = issuer;
   }

   public PaymentMethod issuer(Institution issuer) {
      this.setIssuer(issuer);
      return this;
   }

   @ApiModelProperty(value = "The PIN associated with this payment method. Various PIN formats are supported (clear, encrypted, hashed etc.)")
   @JsonProperty("pin")
   public Pin getPin() {
      return pin;
   }

   public void setPin(Pin pin) {
      this.pin = pin;
   }

   public PaymentMethod pin(Pin pin) {
      this.setPin(pin);
      return this;
   }

   @ApiModelProperty(value = "An alternative identifier for the customer's source of funds.")
   @JsonProperty("proxy")
   @Size(min = 0, max = 40)
   @Masked
   public String getProxy() {
      return proxy;
   }

   public void setProxy(String proxy) {
      this.proxy = proxy;
   }

   public PaymentMethod proxy(String proxy) {
      this.setProxy(proxy);
      return this;
   }

   @ApiModelProperty(value = "An enumerated value describing the type of value used as the proxy.")
   @JsonProperty("proxyType")
   public ProxyType getProxyType() {
      return proxyType;
   }

   public void setProxyType(ProxyType proxyType) {
      this.proxyType = proxyType;
   }

   public PaymentMethod proxyType(ProxyType proxyType) {
      this.setProxyType(proxyType);
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      PaymentMethod that = (PaymentMethod) o;
      return type == that.type && Objects.equals(name, that.name) && Objects.equals(amount, that.amount)
            && Objects.equals(issuer, that.issuer) && Objects.equals(pin, that.pin) && Objects.equals(proxy, that.proxy)
            && proxyType == that.proxyType;
   }

   @Override
   public int hashCode() {
      return Objects.hash(type);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class PaymentMethod {\n");
      sb.append("    name: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    issuer: ").append(Utils.toIndentedString(issuer)).append("\n");
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append("\n");
      sb.append("    proxy: ").append(Utils.toIndentedString(proxy)).append("\n");
      sb.append("    proxyType: ").append(Utils.toIndentedString(proxyType)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
