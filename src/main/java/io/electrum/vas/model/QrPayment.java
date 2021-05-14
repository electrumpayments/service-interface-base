package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.electrum.vas.Utils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @since v3.31.0
 */
@ApiModel(description = "Model for QR-based payments. "
      + "This payment method should be used when a QR code is presented for payment.", parent = PaymentMethod.class)
public class QrPayment extends PaymentMethod {

   private String tranId = null;

   private String partnerPaymentToken = null;

   public QrPayment() {
      setType(PaymentMethodType.QR);
   }

   @ApiModelProperty(required = true, value = "The unique transaction identifier related to this transaction. The tranId is embedded in sub-Tag 00 of the Electrum MAIT.")
   @JsonProperty("tranId")
   @NotNull
   public String getTranId() {
      return tranId;
   }

   public void setTranId(String tranId) {
      this.tranId = tranId;
   }

   /**
    * The unique transaction identifier related to this transaction.
    *
    * @param tranId
    *           The transaction ID.
    * @return this object.
    **/
   public QrPayment tranId(String tranId) {
      this.tranId = tranId;
      return this;
   }

   @ApiModelProperty(required = false, value = "A payment token received from the Partner.")
   @JsonProperty("partnerPaymentToken")
   public String getPartnerPaymentToken() {
      return partnerPaymentToken;
   }

   public void setPartnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
   }

   /**
    * A payment token received from the Partner. This field
    * should be populated if known. A Partner may expect to receive this value in the {@link QrPayment}.
    *
    * @param partnerPaymentToken
    *           The partner's payment token.
    * @return this object.
    **/
   public QrPayment partnerPaymentToken(String partnerPaymentToken) {
      this.partnerPaymentToken = partnerPaymentToken;
      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof QrPayment)) return false;
      if (!super.equals(o)) return false;
      QrPayment qrPayment = (QrPayment) o;
      return tranId.equals(qrPayment.tranId) && Objects.equals(partnerPaymentToken, qrPayment.partnerPaymentToken);
   }

   @Override
   public int hashCode() {
      return Objects.hash(super.hashCode(), tranId, partnerPaymentToken);
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("class QrPayment {\n");
      sb.append("    name: ").append(Utils.toIndentedString(name)).append('\n');
      sb.append("    type: ").append(Utils.toIndentedString(type)).append('\n');
      sb.append("    amount: ").append(Utils.toIndentedString(amount)).append('\n');
      sb.append("    issuer: ").append(Utils.toIndentedString(issuer)).append('\n');
      sb.append("    pin: ").append(Utils.toIndentedString(pin)).append('\n');
      sb.append("    proxy: ").append(Utils.toIndentedString(proxy)).append('\n');
      sb.append("    proxyType: ").append(Utils.toIndentedString(proxyType)).append('\n');
      sb.append("    tranId: ").append(Utils.toIndentedString(tranId)).append('\n');
      sb.append("    partnerPaymentToken: ").append(Utils.toIndentedString(partnerPaymentToken)).append('\n');
      sb.append('}');
      return sb.toString();
   }
}
