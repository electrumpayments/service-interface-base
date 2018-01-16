package io.electrum.vas.model;


import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;



    @ApiModel(description = "Indicates the type of account being used in a transaction")
    /*
    Indicates the type of account being used in a transaction
     */
    public enum AccountType {
        DEFAULT("DEFAULT"),
        SAVINGS("SAVINGS"),
        CHEQUE("CHEQUE"),
        CREDIT("CREDIT"),
        ELECTRONIC_PURSE("ELECTRONIC_PURSE"),
        GIFT_STORED_VALUE_CARD("GIFT_STORED_VALUE_CARD");

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







