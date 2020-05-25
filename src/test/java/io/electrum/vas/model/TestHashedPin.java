package io.electrum.vas.model;

import java.io.IOException;

import javax.validation.Validation;
import javax.validation.Validator;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.electrum.vas.JsonUtil;

public class TestHashedPin {

   @Test(description = "Test we can serialise a hashed PIN to the expected value.")
   public void testSerialisedPinHashed() throws IOException {
      PinHashed hashedPin = new PinHashed().hash("ABCD").hashedPinParameters(new HashedPinParameters().name("SHA-256"));
      String serializedValue = JsonUtil.serialize(hashedPin);
      String expectedValue =
            "{\"type\":\"HASHED_PIN\",\"hash\":\"ABCD\",\"hashedPinParameters\":{\"name\":\"SHA-256\"}}";
      Assert.assertEquals(serializedValue, expectedValue);
   }

   @Test(description = "Test we can deserialise a hashed PIN to the expected value.")
   public void testDeserialisedPinHashed() throws IOException {
      String serializedValue =
            "{\"type\":\"HASHED_PIN\",\"hash\":\"ABCD\",\"hashedPinParameters\":{\"name\":\"SHA-256\"}}";
      PinHashed hashedPin = JsonUtil.deserialize(serializedValue, PinHashed.class);
      PinHashed expectedHashedPin =
            new PinHashed().hash("ABCD").hashedPinParameters(new HashedPinParameters().name("SHA-256"));
      Assert.assertEquals(hashedPin, expectedHashedPin);
   }

   @Test(description = "Test we can deserialise what we serialised and get back to where we started.")
   public void testSerialiseDeserialisePinHashed() throws IOException {
      PinHashed hashedPin = new PinHashed().hash("ABCD").hashedPinParameters(new HashedPinParameters().name("SHA-256"));
      Assert.assertEquals(JsonUtil.deserialize(JsonUtil.serialize(hashedPin), PinHashed.class), hashedPin);
   }

   @Test(description = "Test we can serialise what we deserialised and get back to where we started.")
   public void testDeserialiseSerialisePinHashed() throws IOException {
      String serializedValue =
            "{\"type\":\"HASHED_PIN\",\"hash\":\"ABCD\",\"hashedPinParameters\":{\"name\":\"SHA-256\"}}";
      Assert.assertEquals(JsonUtil.serialize(JsonUtil.deserialize(serializedValue, PinHashed.class)), serializedValue);
   }

   @Test(description = "Test we set the type of Pin correctly.")
   public void testType() throws IOException {
      Assert.assertEquals(new PinHashed().getType(), Pin.PinType.HASHED_PIN);
   }

   @Test(description = "Test we keep the ordinal value of HASHED_PIN constant.")
   public void testPinTypeOrdinal() throws IOException {
      Assert.assertEquals(Pin.PinType.HASHED_PIN.ordinal(), 2);
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

   @Test(description = "Test we are set up to recirsively validate sub-fields.")
   public void testRecursiveValidationToSubFields() throws IOException {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      // should fail because HashedPinParameters should fail
      Assert.assertFalse(
            validator.validate(new PinHashed().hash("A").hashedPinParameters(new HashedPinParameters())).isEmpty());
      // Validation should pass when sub-fields are valid
      Assert.assertTrue(
            validator.validate(new PinHashed().hash("A").hashedPinParameters(new HashedPinParameters().name("MyAlg")))
                  .isEmpty());
   }
}
