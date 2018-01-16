package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class TransactionType{

    /*
    Type definition to set the transaction type
     */
    public enum TransType {
        GOODS_AND_SERVICES("Goods And Services"),
        CASH_WITHDRAWAL("Cash Withdrawal"),
        DEBIT_ADJUSTMENT("Debit Adjustment"),
        GOODS_AND_SERVICES_WITH_CASH_BACK("Goods And Services With Cash Back"),
        NON_CASH("Non Cash"),
        RETURNS("Returns"),
        DEPOSIT("Deposit"),
        CREDIT_ADJUSTMENT("Credit Adjustment"),
        GENERAL_CREDIT("General Credit"),
        AVAILABLE_FUNDS_INQUIRY("Available Funds Inquiry"),
        BALANCE_INQUIRY("Balance Inquiry"),
        GENERAL_INQUIRY("General Inquiry"),
        CARD_VERIFICATION_INQUIRY("Card Verification Inquiry"),
        CARDHOLDER_ACCOUNTS_TRANSFER("Cardholder Accounts Transfer"),
        GENERAL_TRANSFER("General Transfer"),
        PAYMENT_FROM_ACCOUNT("Payment From Account"),
        GENERAL_PAYMENT("General Payment"),
        PAYMENT_TO_ACCOUNT("Payment To Account"),
        PAYMENT_FROM_ACCOUNT_TO_ACCOUNT("Payment From Account To Account"),
        PLACE_HOLD_ON_CARD("Place Hold On Card"),
        GENERAL_ADMIN("General Admin"),
        CHANGE_PIN("Change Pin");

        private String value;

        TransType(String value) {
            this.value = value;
        }


        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

        private TransType transType;

        /**
         * The type of transation
         **/
        public TransactionType transactionType(TransType transType) {
            this.transType = transType;
            return this;
        }

        @ApiModelProperty(value = "The Transaction Type")
        @JsonProperty("transactionType")
        @NotNull
        public TransType getTransactionType() {return transType;}

        public void setTransactionType(TransactionType.TransType transType) {
            this.transType = transType;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("class Transaction Type {\n");
            sb.append("TransType: ");
            sb.append(transType.toString());
            return sb.toString();
        }

        @Override
        public boolean equals(Object other){
            if(other instanceof TransactionType)
                if((((TransactionType) other).getTransactionType()).equals(this.transType)) return true;
            return false;
        }

        @Override
        public int hashCode(){
            return transType.hashCode();
        }

    }

