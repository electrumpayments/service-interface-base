package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumerates the supported PIN block formats
 */
public enum PinBlockFormat {
   ISO_9564_FORMAT_0("ISO_9564_FORMAT_0"),
   ISO_9564_FORMAT_1("ISO_9564_FORMAT_1"),
   ISO_9564_FORMAT_3("ISO_9564_FORMAT_3");

   private String value;

   PinBlockFormat(String value) {
      this.value = value;
   }

   public String getValue() {
      return value;
   }

   @JsonCreator
   public static PinBlockFormat fromValue(String text) {
      for (PinBlockFormat b : PinBlockFormat.values()) {
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
