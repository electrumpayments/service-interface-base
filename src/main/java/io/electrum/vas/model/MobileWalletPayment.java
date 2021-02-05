package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

@ApiModel(description = "Model for mobile wallet payments", parent = PaymentMethod.class)
public class MobileWalletPayment extends PaymentMethod {

    private String walletId;
    private String walletProviderId;

    public MobileWalletPayment(){
        setType(PaymentMethodType.MOBILE_WALLET);
    }

    public MobileWalletPayment walletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public MobileWalletPayment walletProviderId(String walletProviderId) {
        this.walletProviderId = walletProviderId;
        return this;
    }

    @ApiModelProperty(required = true, value = "Unique identifier of the wallet issuer.")
    @JsonProperty("walletProviderId")
    public String getWalletProviderId() {
        return walletProviderId;
    }

    @ApiModelProperty(required = true, value = "Unique identify of the wallet account.")
    @JsonProperty("walletId")
    @NotNull
    public String getWalletId() {
        return walletId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MobileWalletPayment that = (MobileWalletPayment) o;
        return Objects.equals(walletId, that.walletId) && Objects.equals(walletProviderId, that.walletProviderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), walletId, walletProviderId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MobileWalletPayment {\n");

        sb.append("    type: ").append(Utils.toIndentedString(type)).append("\n");
        sb.append("    name: ").append(Utils.toIndentedString(name)).append("\n");
        sb.append("    amount: ").append(Utils.toIndentedString(amount)).append("\n");
        sb.append("    walletId: ").append(Utils.toIndentedString(walletId)).append("\n");
        sb.append("    walletProviderId: ").append(Utils.toIndentedString(walletProviderId)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
