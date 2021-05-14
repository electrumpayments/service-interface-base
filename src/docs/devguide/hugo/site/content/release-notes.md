This page describes changes to the Service Interface Base API implemented across different releases of the interface.

## 3.31.0
Released 14 May 2021
* Added a `channelId` field to the `Originator` class.
* Added a new `PaymentMethod` child called `QrPayment` which can be used when making a QR-based payment.

## Version 3.30.1
Released 30 April 2021
* Validation constraints on `addressLine1` and `addressLine2` of the `Address` model object were incorrect. They were
  changed from a limit of 250 characters to a limit of 100 characters.

## Version 3.30.0

### Deprecated
Released 29 April 2021
* Added new `Address` model object that contains a detailed breakdown of an address.
* Added new member variables called `addressDetails` and `profileId` to the `Customer` model object.
* Deprecated the existing `address` member variable as it will be replaced by the new `addressDetails` member variable.
* Refactored the tests a bit so that they are easier to read and add to.

## 3.29.0
Released 05 March 2021
* Added `WalletPayment` method.
* Added `amount`, `proxy`, `proxyType`, `issuer` and `pin` fields to the `PaymentMethod` model.
* Changes to the Java implementation of the base API:
  * Changed the format of `toString` output for `AccountPayment` model to match the general format of `toString` for other models.
  * The service interface base was updated to compile on Java 11.
  * Updated the `jaxb-core` dependency from version `2.2.11` to version `2.3.0`.
    * Removes warnings brought about when compiling on Java 9 or higher.
  * Updated the `jaxb-api` and jaxb-impl dependency from version `2.2.11` to version `2.3.1`.
    * Removes warnings brought about when compiling on Java 9 or higher.
  * Updated the `joda-time` dependency from version `2.9.4` to version `2.10.5`.
  * Updated the `jackson-datatype-joda` dependency from version `2.9.5` to version `2.10.0`.
  * Updated the `jackson-datatype-jdk8` dependency from version `2.8.5` to version `2.11.2`.
  * Updated the `jackson-datatype-jsr310` dependency from `2.8.5` to `2.11.2`.
  * Updated the `maven-javadoc-plugin` from version `3.1.1` to version `3.2.0`.

## 3.28.0
Released 20 August 2020
* Added `operatorId` field to the `Originator` model.

## 3.27.0
Released 31 July 2020
* Added `RewardPayment` method.
* Provided testing utilities to aid API development in the Java implementation provided by Electrum.

## 3.26.0
Released 21 July 2020
* Added Account PaymentMethod.
* Added Interfaces for HasAmounts & HasPaymentMethods. These can be used for creating shared utilities across API implementations.

## 3.25.0
Released 18 June 2020
* Added `amounts` field to the `BasicAdvice` model to support partial reversals and partial confirmations.

## 3.24.0
Released 26 May 2020
* Added support for hashed PINs (via a new sub-type of `Pin` named `HashedPin`).

## 3.23.0
Released 25 November 2019
* Added utility methods to JsonUtil class to assist in reading the contents of a file as a string and deserialising JSON objects from files.

## 3.22.0
Released 25 October 2019
* Added new field `region` to `BankAccount` model for scenarios where the `routingCode` is not sufficient to uniquely identify a bank account.

## 3.21.0
Released 23 July 2019
* Added new field `emailAddress` to `Customer` model.

## 3.20.0
Released 17 May 2019
* Added new `Account.AccountType` value `CASH_PICKUP` for cash pickup scenarios.

## 3.19.1
Released 16 May 2019
* Changed masking of `CardPayment.pan` field to partial masking instead of full masking.

## 3.19.0
Released 12 March 2019
* Added new models:
    - `Pin` a base PIN model
        - `PinClear` for PINs in the clear
        - `PinEncrypted` for encrypted PIN blocks with the PIN block format, accountNumber and the key index
* `Pin` was added to `CardPayment`, taking precedence over the existing `encyptedPin` field

## 3.18.0
Released 25 February 2019

### New Features
* Added new models:
  - `ExchangeRate` to describe the exchange rate between two currencies.
  - `Account` to describe more varied accounts in a consistent manner. This has the following sub-types defined:
    - `BankAccount`
    - `IbanAccount`
    - `IfsAccount`
    - `SwiftAccount`
    - `MobileWalletAccount`
* The limitations on the `id` field of the `Institution` model have been removed to make the field suitable for a wider range of applications. The values in this field need no longer be defined by Electrum and similar values as recognised at third parties may now be carried in this field. However, care should be taken during implementation to ensure that different parties agree on the values which will be present in these fields.

## 3.17.0
Released 16 January 2019

### New Features
* Added explicit fields for STAN and RRN values to `BasicAdvice` and `Transaction` models.

## 3.16.1
Released 09 January 2019

### New Features
* Added a `serialise(Object)` method to the `JsonUtil` class. This assists in obtaining consistently serialised String representations of Objects.

### Fixes
* Made the `msisdn` field of the `Customer` object and optional field. This restores backwards compatibility broken in v3.16.0.

## 3.16.0
Released 23 October 2018

### New Features
* Added `msisdn` as a mandatory field to the `Customer` object.

Version history prior to v3.16.0 can be obtained from the Git commit logs.
