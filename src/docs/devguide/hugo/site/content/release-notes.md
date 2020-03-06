This page describes changes to the Service Interface Base API implemented across different releases of the interface.

## 3.24.0
Released TBA
* Added `@Uuid` annotation which will validate that a `String` field, parameter or return of a method forms a valid `UUID`.

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
