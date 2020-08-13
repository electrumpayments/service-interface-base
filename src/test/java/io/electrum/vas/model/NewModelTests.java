package io.electrum.vas.model;

import io.electrum.vas.JsonUtil;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Arrays;

public class NewModelTests {

   @Test(description = "Test we can serialise a model to the expected value.", dataProvider = "serialisedObjectDataProvider")
   public void testSerialisedObject(Object objectToSerialise, String expectedValue) throws IOException {
      String serializedValue = JsonUtil.serialize(objectToSerialise);
      Assert.assertEquals(serializedValue, expectedValue);
   }

   @Test(description = "Test we can deserialise a model to the expected value.", dataProvider = "deserialisedObjectDataProvider")
   public void testDeserialisedObject(String stringToDeserialise, Object expectedObject) throws IOException {
      Object deserialisedObject = JsonUtil.deserialize(stringToDeserialise, expectedObject.getClass());
      Assert.assertEquals(deserialisedObject, expectedObject);
   }

   @Test(description = "Test we can deserialise what we serialised and get back to where we started.", dataProvider = "serialiseDeserialiseObjectDataProvider")
   public void testSerialiseDeserialiseObject(Object testObject) throws IOException {
      Assert.assertEquals(JsonUtil.deserialize(JsonUtil.serialize(testObject), testObject.getClass()), testObject);
   }

   @Test(description = "Test we can serialise what we deserialised and get back to where we started.", dataProvider = "deserialiseSerialiseObjectDataProvider")
   public void testDeserialiseSerialiseObject(String testString, Class<?> classOfObject) throws IOException {
      Assert.assertEquals(JsonUtil.serialize(JsonUtil.deserialize(testString, classOfObject)), testString);
   }

   @Test(description = "Test we keep the ordinal value of an enum constant.", dataProvider = "ordinalDataProvider")
   public void testOrdinal(Enum<?> enumeration, int expectedOrdinal) throws IOException {
      Assert.assertEquals(enumeration.ordinal(), expectedOrdinal);
   }

   @Test(description = "Test we are set up to recursively validate sub-fields.", dataProvider = "recursiveValidationOnSubFieldsDataProvider")
   public void testRecursiveValidationOnSubFields(Object objectWithInvalidSubField, Object objectWithValidSubField)
         throws IOException {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      // should fail because a sub-field should fail validation
      Assert.assertFalse(validator.validate(objectWithInvalidSubField).isEmpty());
      // should pass because sub-fields are valid
      Assert.assertTrue(validator.validate(objectWithValidSubField).isEmpty());
   }

   @DataProvider(name = "serialisedObjectDataProvider")
   public Object[][] serialisedObjectDataProvider() {
      DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss.SSSZ");
      return new Object[][] {
            //@formatter:off
              {new PinHashed().hash("ABCD").hashedPinParameters(new HashedPinParameters().name("SHA-256")), "{\"type\":\"HASHED_PIN\",\"hash\":\"ABCD\",\"hashedPinParameters\":{\"name\":\"SHA-256\"}}"},
              {new BasicAdvice().amounts(new Amounts()).id("123456ID").requestId("requestId1").time(DateTime.parse("07/06/2013 08:11:59.000Z", formatter)
                      .toDateTime(DateTimeZone.UTC)).rrn("12345rrn").stan("12345stan").transactionIdentifiers(Arrays.asList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId"))),
                      "{\"id\":\"123456ID\",\"requestId\":\"requestId1\",\"time\":\"2013-06-07T08:11:59.000Z\",\"thirdPartyIdentifiers\":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}]," +
                              "\"stan\":\"12345stan\",\"rrn\":\"12345rrn\",\"amounts\":{}}"},
              {new RewardPayment().rewardCode("EasterPromotions2021").amount(new LedgerAmount().amount(456L).currency("710")).name(null),
                    "{\"type\":\"REWARD\",\"amount\":{\"amount\":456,\"currency\":\"710\"},\"rewardCode\":\"EasterPromotions2021\"}"},
              {new Originator().operatorId("someOperatorID"), "{\"operatorId\":\"someOperatorID\"}"}
              //@formatter:on
      };
   }

   @DataProvider(name = "deserialisedObjectDataProvider")
   public Object[][] deserialisedObjectDataProvider() {
      DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss.SSSZ");
      return new Object[][] {
            //@formatter:off
              {"{\"type\":\"HASHED_PIN\",\"hash\":\"ABCD\",\"hashedPinParameters\":{\"name\":\"SHA-256\"}}", new PinHashed().hash("ABCD").hashedPinParameters(new HashedPinParameters().name("SHA-256"))},
              {"{\"id\":\"123456ID\",\"requestId\":\"requestId1\",\"time\":\"2013-06-07T08:11:59.000Z\",\"thirdPartyIdentifiers\":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}]," +
                      "\"stan\":\"12345stan\",\"rrn\":\"12345rrn\",\"amounts\":{\"approvedAmount\":{\"amount\":9000,\"currency\":\"710\",\"ledgerIndicator\":\"DEBIT\"}}}", new BasicAdvice().id("123456ID").requestId("requestId1").time(DateTime.parse("07/06/2013 10:11:59.000Z", formatter)
                      .toDateTime()).rrn("12345rrn").stan("12345stan").transactionIdentifiers(Arrays.asList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId")))
                      .amounts(new Amounts().approvedAmount(new LedgerAmount().amount(9000L).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT))
              )},
              {"{\"type\":\"REWARD\",\"amount\":{\"amount\":456,\"currency\":\"710\"},\"rewardCode\":\"EasterPromotions2021\"}",
                 new RewardPayment().rewardCode("EasterPromotions2021").amount(new LedgerAmount().amount(456L).currency("710")).name(null)
              },
              {"{\"operatorId\":\"someOperatorID\"}", new Originator().operatorId("someOperatorID")}
              //@formatter:on
      };
   }

   @DataProvider(name = "serialiseDeserialiseObjectDataProvider")
   public Object[][] serialiseDeserialiseObjectDataProvider() {
      return new Object[][] {
            //@formatter:off
              {new PinHashed().hash("ABCD").hashedPinParameters(new HashedPinParameters().name("SHA-256"))},
              {new BasicAdvice().amounts(new Amounts()).id("123456ID").requestId("requestId").time(DateTime.now().toDateTime(DateTimeZone.UTC)).rrn("12345rrn").stan("12345stan")
                      .transactionIdentifiers(Arrays.asList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId")))},
              {new BasicAdvice()
                      .amounts(new Amounts().approvedAmount(new LedgerAmount().amount(9000L).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT))).requestId("requestId")
                      .time(DateTime.now().toDateTime(DateTimeZone.UTC)).rrn("12345rrn").stan("12345stan")
                      .transactionIdentifiers(Arrays.asList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId")))},
              {new RewardPayment().rewardCode("EasterPromotions2021").amount(new LedgerAmount().amount(456L).currency("710")).name(null)},
              {new Originator().operatorId("someOperatorID")}
              //@formatter:on
      };
   }

   @DataProvider(name = "deserialiseSerialiseObjectDataProvider")
   public Object[][] deserialiseSerialiseObjectDataProvider() {
      return new Object[][] {
            //@formatter:off
              {"{\"type\":\"HASHED_PIN\",\"hash\":\"ABCD\",\"hashedPinParameters\":{\"name\":\"SHA-256\"}}", PinHashed.class},
              {"{\"id\":\"123456ID\",\"requestId\":\"requestId1\",\"time\":\"2013-06-07T08:11:59.000Z\",\"thirdPartyIdentifiers\":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}]," +
                      "\"stan\":\"12345stan\",\"rrn\":\"12345rrn\",\"amounts\":{}}", BasicAdvice.class},
              {"{\"id\":\"123456ID\",\"requestId\":\"requestId1\",\"time\":\"2013-06-07T08:11:59.000Z\",\"thirdPartyIdentifiers\":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}]," +
                      "\"stan\":\"12345stan\",\"rrn\":\"12345rrn\",\"amounts\":{\"approvedAmount\":{\"amount\":9000,\"currency\":\"710\",\"ledgerIndicator\":\"DEBIT\"}}}", BasicAdvice.class},
              {"{\"type\":\"REWARD\",\"amount\":{\"amount\":456,\"currency\":\"710\"},\"rewardCode\":\"EasterPromotions2021\"}", RewardPayment.class},
              {"{\"operatorId\":\"someOperatorID\"}", Originator.class}
              //@formatter:on
      };
   }

   @DataProvider(name = "ordinalDataProvider")
   public Object[][] ordinalDataProvider() {
      return new Object[][] {
       //@formatter:off
       {Pin.PinType.HASHED_PIN, 2}
       //@formatter:on
      };
   }

   @DataProvider(name = "recursiveValidationOnSubFieldsDataProvider")
   public Object[][] recursiveValidationOnSubFieldsDataProvider() {
      DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
      return new Object[][] {
            //@formatter:off
              {new PinHashed().hash("A").hashedPinParameters(new HashedPinParameters()), new PinHashed().hash("A").hashedPinParameters(new HashedPinParameters().name("MyAlg"))},
              {new BasicAdvice().id("123456ID").requestId("requestId").time(DateTime.now().toDateTime(DateTimeZone.UTC))
                      .amounts(new Amounts().approvedAmount(new LedgerAmount().amount(null).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT)))
                      .transactionIdentifiers(Arrays.asList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId"))),
                      new BasicAdvice().id("123456ID").requestId("requestId").time(DateTime.now().toDateTime(DateTimeZone.UTC))
                              .amounts(new Amounts().approvedAmount(new LedgerAmount().amount(10000L).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT)))
                              .transactionIdentifiers(Arrays.asList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId")))}
              //@formatter:on
      };
   }

}
