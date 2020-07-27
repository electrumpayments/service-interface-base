package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Objects;

@ApiModel(description = "Model for reward-based payments. "
      + "This payment method should be used when the payment is offset using a reward programme", parent = PaymentMethod.class)
/**
 * @since v1.37.0
 */
public class RewardPayment extends PaymentMethod {

   private String rewardCode = null;

   public RewardPayment() {
      // The method used to deserialise child models based on a discriminator leaves the discriminator field null
      // So we set it explicitly in the default constructor
      setType(PaymentMethodType.REWARD);
   }

   @ApiModelProperty(required = true, value = "A code used to recognise the reward programme")
   @JsonProperty("rewardCode")
   @Size(min = 0, max = 40)
   @NotNull
   public String getRewardCode() {
      return rewardCode;
   }

   public void setRewardCode(String rewardCode) {
      this.rewardCode = rewardCode;
   }

   public RewardPayment rewardCode(String rewardCode) {
      this.setRewardCode(rewardCode);
      return this;
   }

   @Override
   public int hashCode() {
      return Objects.hash(rewardCode, name, type, amount);
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      RewardPayment rewardPayment = (RewardPayment) o;
      return Objects.equals(this.type, rewardPayment.type) && Objects.equals(this.name, rewardPayment.name)
            && Objects.equals(this.rewardCode, rewardPayment.rewardCode)
            && Objects.equals(this.amount, rewardPayment.amount);
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class RewardPayment {\n");

      sb.append("    type: ").append(Utils.toIndentedString(type)).append('\n');
      sb.append("    name: ").append(Utils.toIndentedString(name)).append('\n');
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append('\n');
      sb.append("    rewardCode: ").append(Utils.toIndentedString(rewardCode)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
