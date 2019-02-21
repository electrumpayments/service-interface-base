This page describes changes to the Service Interface Base API implemented across different releases of the interface.

## 3.18.0
Released TBC February 2019

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
