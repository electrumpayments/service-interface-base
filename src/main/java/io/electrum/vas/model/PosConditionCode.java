package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumerates the recognised condition codes of the POS.
 */
public enum PosConditionCode {
   NORMAL_PRESENTMENT("NORMAL_PRESENTMENT"),
   CUSTOMER_NOT_PRESENT("CUSTOMER_NOT_PRESENT"),
   CUSTOMER_PRESENT_AND_CARD_NOT_PRESENT("CUSTOMER_PRESENT_AND_CARD_NOT_PRESENT"),
   CUSTOMER_IDENTITY_VERIFIED("CUSTOMER_IDENTITY_VERIFIED"),
   PUBLIC_UTILITY_TERMINAL("PUBLIC_UTILITY_TERMINAL"),
   CUSTOMER_TERMINAL("CUSTOMER_TERMINAL"),
   MANUAL_REVERSAL("MANUAL_REVERSAL"),
   UNATTENDED_TERMINAL_AND_CARD_CAN_BE_RETAINED("UNATTENDED_TERMINAL_AND_CARD_CAN_BE_RETAINED"),
   UNATTENDED_TERMINAL_AND_CARD_CANNOT_BE_RETAINED("UNATTENDED_TERMINAL_AND_CARD_CANNOT_BE_RETAINED");

   private String value;

   PosConditionCode(String value) {
      this.value = value;
   }

   public String getValue() {
      return value;
   }

   @JsonCreator
   public static PosConditionCode fromValue(String text) {
      for (PosConditionCode b : PosConditionCode.values()) {
         if (String.valueOf(b.value).equals(text)) {
            return b;
         }
      }
      return null;
   }

   @Override
   public String toString() {
      return String.valueOf(value);
   }
}
