package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class AccountType{

    /*
    Type definition to set the account type
     */
    public enum AccType {
        DEFAULT("DEFAULT"),
        SAVINGS("SAVINGS"),
        CHEQUE("CHEQUE"),
        CREDIT("CREDIT"),
        ELECTRONIC_PURSE("ELECTRONIC_PURSE"),
        GIFT_STORED_VALUE_CARD("GIFT_STORED_VALUE_CARD");

        private String value;

        AccType(String value) {
            this.value = value;
        }


        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }

    private AccType accType;

    /**
     * The type of account being used
     **/
    public AccountType accountType(AccType accType) {
        this.accType = accType;
        return this;
    }

    @ApiModelProperty(value = "The Account Type")
    @JsonProperty("accountType")
    @NotNull
    public AccType getAccountType() {return accType;}

    public void setAccountType(AccountType.AccType accType) {
        this.accType = accType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account Type {\n");
        sb.append("AccType: ");
        sb.append(accType.toString());
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object other){
        if(other instanceof AccountType)
            if((((AccountType) other).getAccountType()).equals(this.accType)) return true;
        return false;
    }

    @Override
    public int hashCode(){
        return accType.hashCode();
    }

}

