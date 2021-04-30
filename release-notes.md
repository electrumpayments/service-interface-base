# Service Interface Base Release Notes

<!-- README:
  * Add new entries to the top of this file (under this comment), making sure to specify the correct version number and release date.
  * Make sure you include a concise description of all changes since the previous release. Check the git history to be sure.
  * Group the descriptions under the relevant headings (but don’t include a heading if there are no changes under it):
    - Breaking Changes -> Changes that break backwards compatability. These will correspond to a major version release.
    - New Features -> Changes that would, in the absence of any breaking changes, constitute a minor version release.
    - Fixed -> Bugfixes that would, in the absence of any new features or breaking changes, constitute a patch version release.
    - Deprecated -> Any classes or methods that have been deprecated.
  * Make use of Markdown formatting:
    - Run ‘$curl cheat.sh/markdown’ from your command line to get a quick overview of markdown.
    - Use the convention of enclosing class, variable and method names in backticks so that they render as monospace.
    - Try and avoid special characters as far as possible
-->

## Version 3.30.1 - 30 April 2021

## Bug Fixes

* Validation constraints on `addressLine1` and `addressLine2` of the `Address` model object were incorrect. They were
  changed from a limit of 250 characters to a limit of 100 characters.

## Version 3.30.0 - 29 April 2021

### New Features

* Added new `Address` model object that contains a detailed breakdown of an address.
* Added new member variables called `addressDetails` and `profileId` to the `Customer` model object.
* Deprecated the existing `address` member variable as it will be replaced by the new `addressDetails` member variable.
* Refactored the tests a bit so that they are easier to read and add to.
