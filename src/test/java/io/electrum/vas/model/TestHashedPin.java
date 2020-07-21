package io.electrum.vas.model;

import java.io.IOException;

import javax.validation.Validation;
import javax.validation.Validator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHashedPin {

   @Test(description = "Test we set the type of Pin correctly.")
   public void testType() throws IOException {
      Assert.assertEquals(new PinHashed().getType(), Pin.PinType.HASHED_PIN);
   }

   @Test(description = "Test we permit the allowed characters in the hash field (i.e. capitalised hexadecimal characters).")
   public void testAllowedHashCharacters() throws IOException {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      Assert.assertTrue(validator.validate(new PinHashed().hash("1234567890ABCDEF")).isEmpty());
   }

   @Test(description = "Test we don't permit the disallowed characters in the hash field.")
   public void testDisallowedHashCharacters() throws IOException {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      Assert.assertFalse(validator.validate(new PinHashed().hash("a")).isEmpty()); // lower case hex characters
      Assert.assertFalse(validator.validate(new PinHashed().hash("G")).isEmpty()); // upper case non-hex characters
   }

   @Test(description = "Test we don't permit empty strings.")
   public void testMinLimit() throws IOException {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      Assert.assertFalse(validator.validate(new PinHashed().hash("")).isEmpty()); // disallow empty strings
      Assert.assertTrue(validator.validate(new PinHashed().hash("A")).isEmpty()); // otherwise allow it
   }
}
