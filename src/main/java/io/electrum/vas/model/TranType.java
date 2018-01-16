package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "Indicates the transaction type (i.e Goods and Services or Cash Withdrawal)")
/*
Indicates the transaction type (i.e Goods and Services or Cash Withdrawal)
 */
    public enum TranType {
        GOODS_AND_SERVICES("GOODS_AND_SERVICES"),
        CASH_WITHDRAWAL("CASH_WITHDRAWAL"),
        DEBIT_ADJUSTMENT("DEBIT_ADJUSTMENT"),
        GOODS_AND_SERVICES_WITH_CASH_BACK("GOODS_AND_SERVICES_WITH_CASH_BACK"),
        NON_CASH("NON_CASH"),
        RETURNS("RETURNS"),
        DEPOSIT("DEPOSIT"),
        CREDIT_ADJUSTMENT("CREDIT_ADJUSTMENT"),
        GENERAL_CREDIT("GENERAL_CREDIT"),
        AVAILABLE_FUNDS_INQUIRY("AVAILABLE_FUNDS_INQUIRY"),
        BALANCE_INQUIRY("BALANCE_INQUIRY"),
        GENERAL_INQUIRY("GENERAL_INQUIRY"),
        CARD_VERIFICATION_INQUIRY("CARD_VERIFICATION_INQUIRY"),
        CARDHOLDER_ACCOUNTS_TRANSFER("CARDHOLDER_ACCOUNTS_TRANSFER"),
        GENERAL_TRANSFER("GENERAL_TRANSFER"),
        PAYMENT_FROM_ACCOUNT("PAYMENT_FROM_ACCOUNT"),
        GENERAL_PAYMENT("GENERAL_PAYMENT"),
        PAYMENT_TO_ACCOUNT("PAYMENT_TO_ACCOUNT"),
        PAYMENT_FROM_ACCOUNT_TO_ACCOUNT("PAYMENT_FROM_ACCOUNT_TO_ACCOUNT"),
        PLACE_HOLD_ON_CARD("PLACE_HOLD_ON_CARD"),
        GENERAL_ADMIN("GENERAL_ADMIN"),
        CHANGE_PIN("CHANGE_PIN");

        private String value;

        TranType(String value) {
            this.value = value;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }




