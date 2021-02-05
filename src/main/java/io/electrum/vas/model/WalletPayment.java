package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@ApiModel(description = "Model for mobile wallet payments", parent = PaymentMethod.class)
public class WalletPayment extends PaymentMethod {

    private String walletId;

    public WalletPayment(){
        setType(PaymentMethodType.WALLET);
    }

    public WalletPayment walletId(String walletId) {
        this.walletId = walletId;
        return this;
    }


    @ApiModelProperty(required = true, value = "The unique identifier of the wallet account making the payment.")
    @JsonProperty("walletId")
    @NotNull
    public String getWalletId() {
        return walletId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WalletPayment walletPayment = (WalletPayment) o;
        return Objects.equals(this.type, walletPayment.type) && Objects.equals(this.name, walletPayment.name)
                && Objects.equals(this.amount, walletPayment.amount)
                && Objects.equals(this.walletId, walletPayment.walletId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), walletId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WalletPayment {\n");

        sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
        sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
        sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
        sb.append("    walletId: ").append(Utils.toIndentedString(walletId)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
