package io.electrum.vas.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A tender used by a customer towards a payment
 **/
@ApiModel(description = "Details of the Tender used by a customer towards a payment")
public class Tender {

   /**
    * The type of account used
    * 
    * @deprecated This account type enumeration has been superseded by the more general account type enumeration in
    *             {@link io.electrum.vas.model.AccountType} since v3.8.0. Future uses of this API should use this enumeration.
    */
   @Deprecated
   public enum AccountType {
      DEFAULT("DEFAULT"),
      SAVINGS("SAVINGS"),
      CHEQUE("CHEQUE"),
      CREDIT("CREDIT"),
      UNIVERSAL("UNIVERSAL"),
      ELECTRONIC_PURSE("ELECTRONIC_PURSE"),
      STORED_VALUE("STORED_VALUE");

      private String value;

      AccountType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   /**
    * The type of tender used
    */
   public enum TenderType {
      CASH("CASH"),
      CHEQUE("CHEQUE"),
      CREDIT_CARD("CREDIT_CARD"),
      DEBIT_CARD("DEBIT_CARD"),
      WALLET("WALLET"),
      ROUNDING("ROUNDING"),
      GIFT_CARD("GIFT_CARD"),
      LOYALTY_CARD("LOYALTY_CARD"),
      OTHER("OTHER");

      private String value;

      TenderType(String value) {
         this.value = value;
      }

      @Override
      @JsonValue
      public String toString() {
         return String.valueOf(value);
      }
   }

   private AccountType accountType = AccountType.DEFAULT;
   private LedgerAmount amount = null;
   private String cardNumber = null;
   private String reference = null;
   private TenderType tenderType = null;

   /**
    * The type of account
    **/
   public Tender accountType(AccountType accountType) {
      this.accountType = accountType;
      return this;
   }

   @ApiModelProperty(value = "The type of account")
   @JsonProperty("accountType")
   public AccountType getAccountType() {
      return accountType;
   }

   public void setAccountType(AccountType accountType) {
      this.accountType = accountType;
   }

   /**
    * The tendered amount
    **/
   public Tender amount(LedgerAmount amount) {
      this.amount = amount;
      return this;
   }

   @ApiModelProperty(required = true, value = "The tendered amount")
   @JsonProperty("amount")
   @NotNull
   @Valid
   public LedgerAmount getAmount() {
      return amount;
   }

   public void setAmount(LedgerAmount amount) {
      this.amount = amount;
   }

   /**
    * A PCI compliant masked card number, with at least the first 6 digits in the clear. Only applicable to card based
    * transactions
    **/
   public Tender cardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
      return this;
   }

   @ApiModelProperty(value = "A PCI compliant masked card number, with at least the first 6 digits in the clear. Only applicable to card based transactions")
   @JsonProperty("cardNumber")
   @Pattern(regexp = "[0-9]{6}[0-9*]{0,13}")
   public String getCardNumber() {
      return cardNumber;
   }

   public void setCardNumber(String cardNumber) {
      this.cardNumber = cardNumber;
   }

   /**
    * A free text reference
    **/
   public Tender reference(String reference) {
      this.reference = reference;
      return this;
   }

   @ApiModelProperty(value = "A free text reference")
   @JsonProperty("reference")
   @Length(max = 40)
   public String getReference() {
      return reference;
   }

   public void setReference(String reference) {
      this.reference = reference;
   }

   /**
    * The type of tender used
    **/
   public Tender tenderType(TenderType tenderType) {
      this.tenderType = tenderType;
      return this;
   }

   @ApiModelProperty(required = true, value = "The type of tender used")
   @JsonProperty("tenderType")
   @NotNull
   public TenderType getTenderType() {
      return tenderType;
   }

   public void setTenderType(TenderType tenderType) {
      this.tenderType = tenderType;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      Tender tender = (Tender) o;
      return Objects.equals(accountType, tender.accountType) && Objects.equals(amount, tender.amount)
            && Objects.equals(cardNumber, tender.cardNumber) && Objects.equals(reference, tender.reference)
            && Objects.equals(tenderType, tender.tenderType);
   }

   @Override
   public int hashCode() {
      return Objects.hash(accountType, amount, cardNumber, reference, tenderType);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class Tender {\n");

      sb.append("    accountType: ").append(Utils.toIndentedString(accountType)).append("\n");
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
      sb.append("    cardNumber: ").append(Utils.toIndentedString(cardNumber)).append("\n");
      sb.append("    reference: ").append(Utils.toIndentedString(reference)).append("\n");
      sb.append("    tenderType: ").append(Utils.toIndentedString(tenderType)).append("\n");
      sb.append("}");
      return sb.toString();
   }
}
