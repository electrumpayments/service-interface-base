package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Indicates the type of account being used in a transaction process.")
/*
 * Indicates the type of account being used in a transaction process.
 */
/**
 * The type of account
 */
public enum AccountType {
   DEFAULT("DEFAULT"),
   SAVINGS("SAVINGS"),
   CHEQUE("CHEQUE"),
   CREDIT("CREDIT"),
   UNIVERSAL("UNIVERSAL"),
   ELECTRONIC_PURSE("ELECTRONIC_PURSE"),
   GIFT_CARD("GIFT_CARD"),
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
