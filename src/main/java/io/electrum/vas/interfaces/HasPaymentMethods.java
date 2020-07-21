package io.electrum.vas.interfaces;

import java.util.List;

import io.electrum.vas.model.PaymentMethod;

/**
 * An interface for use within child service-interface projects. This enables one to implement utilities across multiple
 * api implementations which use the Payment Methods model.
 */
public interface HasPaymentMethods {

   List<PaymentMethod> getPaymentMethods();

   void setPaymentMethods(List<PaymentMethod> paymentMethods);
}
