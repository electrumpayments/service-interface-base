package io.electrum.vas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @since v1.31.0
 */
@ApiModel(description = "Model for QR-based payments. "
      + "This payment method should be used when a QR code is presented for payment.", parent = PaymentMethod.class)
public class QrPayment extends PaymentMethod {

   private String tranId = null;

   private String partnerPaymentToken = null;

   public QrPayment() {
      setType(PaymentMethodType.QR);
   }

   @ApiModelProperty(required = true, value = "The unique transaction identifier related to this transaction.")
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

   @Override
   public String toString() {
      final StringBuilder sb = new StringBuilder("QrPayment{");
      sb.append("type=").append(type);
      sb.append(", name='").append(name).append('\'');
      sb.append(", amount=").append(amount);
      sb.append(", issuer=").append(issuer);
      sb.append(", pin=").append(pin);
      sb.append(", proxy='").append(proxy).append('\'');
      sb.append(", proxyType=").append(proxyType);
      sb.append(", tranId='").append(tranId).append('\'');
      sb.append(", partnerPaymentToken='").append(partnerPaymentToken).append('\'');
      sb.append('}');
      return sb.toString();
   }
}
