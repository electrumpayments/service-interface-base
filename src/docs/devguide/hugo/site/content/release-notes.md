This page describes changes to the Service Interface Base API implemented across different releases of the interface.

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
