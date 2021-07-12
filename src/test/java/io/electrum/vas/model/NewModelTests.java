package io.electrum.vas.model;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.electrum.vas.JsonUtil;

public class NewModelTests {

   private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss.SSSZ");
   private Customer customer;
   private Address address;
   private Originator originator;
   private BasicAdvice basicAdvice;
   private PinHashed pinHashed;
   private PaymentMethod rewardPayment;
   private PaymentMethod walletPayment;
   private PaymentMethod cardPayment;
   private PaymentMethod qrPayment;
   private PaymentMethod loyaltyCardPayment;

   @BeforeMethod
   protected void createPayloads() {
      customer = new Customer()
            .firstName("Patrick")
            .lastName("Colborne")
            .address("41 Sheila Street, Edenvale, Gauteng, 1609")
            .dateOfBirth(new DateTime(1995, 7, 28, 0, 0, DateTimeZone.UTC))
            .status("active")
            .msisdn("27762463297")
            .emailAddress("pcolborne@gmail.com")
            .addressDetails(new Address()
                  .addressLine1("41 Sheila Street")
                  .addressLine2("Edenvale")
                  .city("Johannesburg")
                  .region("GP")
                  .country("ZA")
                  .postalCode("1609"))
            .profileId("188a66d6-166f-4010-9a8e-ea4d3bb22a09");

      address = new Address()
            .addressLine1("41 Sheila Street")
            .addressLine2("Edenvale")
            .city("Johannesburg")
            .region("GP")
            .country("ZA")
            .postalCode("1609");

      originator = new Originator()
            .operatorId("someOperatorID");

      basicAdvice = new BasicAdvice()
            .id("123456ID")
            .requestId("requestId1")
            .time(DateTime.parse("07/06/2013 10:11:59.000Z", DATE_TIME_FORMATTER).toDateTime())
            .rrn("12345rrn")
            .stan("12345stan")
            .transactionIdentifiers(Collections.singletonList(new ThirdPartyIdentifier()
                  .institutionId("1234InsId")
                  .transactionIdentifier("1234transId")))
            .amounts(new Amounts()
                  .approvedAmount(new LedgerAmount()
                        .amount(9000L)
                        .currency("710")
                        .ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT)));

      pinHashed = new PinHashed()
            .hash("ABCD")
            .hashedPinParameters(new HashedPinParameters()
                  .name("SHA-256"));
      
      rewardPayment = new RewardPayment()
            .rewardCode("EasterPromotions2021")
            .amount(new LedgerAmount()
                  .amount(456L)
                  .currency("710"))
            .name(null);

      walletPayment =
            new WalletPayment().walletId("0712345678")
                  .walletPocket(new WalletPocket().pocketId("12345").pocketName("Cash Pocket"))
                  .amount(new LedgerAmount().amount(456L).currency("710"));

      cardPayment = new CardPayment()
            .amount(new LedgerAmount()
                  .amount(456L)
                  .currency("710"))
            .name("Card Payment")
            .issuer(new Institution()
                  .id("1234InsId")
                  .name("Institution"))
            .proxy("12345")
            .proxyType(ProxyType.UNKNOWN)
            .pin(new PinEncrypted()
                  .type(Pin.PinType.ENCRYPTED_PIN));

      qrPayment = new QrPayment()
            .tranId("bc228730-ab68-45e2-b91c-bc7d53640edb")
            .partnerPaymentToken("71b36fcc-4a2e-47d4-b716-815b6dfef1f1")
            .amount(new LedgerAmount()
            .amount(456L)
            .currency("710"))
            .name("QR Payment")
            .issuer(new Institution()
                  .id("1234InsId")
                  .name("Institution"))
            .proxy("12345")
            .proxyType(ProxyType.UNKNOWN);

      loyaltyCardPayment =
            new LoyaltyCardPayment().cardNumber("1111222233334444")
                  .amount(new LedgerAmount().amount(100L).currency("710"))
                  .name("Loyalty Card Payment")
                  .issuer(new Institution().id("1234InsId").name("Institution"))
                  .proxy("12345")
                  .proxyType(ProxyType.UNKNOWN);
   }

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
   public void testOrdinal(Enum<?> enumeration, int expectedOrdinal) {
      Assert.assertEquals(enumeration.ordinal(), expectedOrdinal);
   }

   @Test(description = "Test we are set up to recursively validate sub-fields.", dataProvider = "recursiveValidationOnSubFieldsDataProvider")
   public void testRecursiveValidationOnSubFields(Object objectWithInvalidSubField, Object objectWithValidSubField) {
      Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
      // should fail because a sub-field should fail validation
      Assert.assertFalse(validator.validate(objectWithInvalidSubField).isEmpty());
      // should pass because sub-fields are valid
      Set<ConstraintViolation<Object>> set = validator.validate(objectWithValidSubField);

      if (!set.isEmpty()) {
         for (ConstraintViolation<?> s : set) {
            System.out.printf("Field '%s' violates the contraints since '%s'%n",
                    s.getPropertyPath().toString(), s.getMessage());
         }
      }
      Assert.assertTrue(validator.validate(objectWithValidSubField).isEmpty());
   }

   @DataProvider(name = "serialisedObjectDataProvider")
   public Object[][] serialisedObjectDataProvider() throws Exception {
      return new Object[][] {
            //@formatter:off
              {pinHashed, JsonUtil.readFileAsString(PayloadFileLocations.PIN_HASHED, false)},
              {basicAdvice, JsonUtil.readFileAsString(PayloadFileLocations.BASIC_ADVICE, false)},
              {rewardPayment, JsonUtil.readFileAsString(PayloadFileLocations.REWARD_PAYMENT, false)},
              {originator, JsonUtil.readFileAsString(PayloadFileLocations.ORIGINATOR, false)},
              {walletPayment, JsonUtil.readFileAsString(PayloadFileLocations.WALLET_PAYMENT, false)},
              {cardPayment, JsonUtil.readFileAsString(PayloadFileLocations.CARD_PAYMENT, false)},
              {qrPayment, JsonUtil.readFileAsString(PayloadFileLocations.QR_PAYMENT, false)},
              {address, JsonUtil.readFileAsString(PayloadFileLocations.ADDRESS, false)},
              {loyaltyCardPayment, JsonUtil.readFileAsString(PayloadFileLocations.LOYALTY_CARD_PAYMENT, false)},
              //@formatter:on
      };
   }

   @DataProvider(name = "deserialisedObjectDataProvider")
   public Object[][] deserialisedObjectDataProvider() throws Exception {
      return new Object[][] {
            //@formatter:off
              {JsonUtil.readFileAsString(PayloadFileLocations.PIN_HASHED, false), pinHashed},
              {JsonUtil.readFileAsString(PayloadFileLocations.BASIC_ADVICE, false), basicAdvice},
              {JsonUtil.readFileAsString(PayloadFileLocations.REWARD_PAYMENT, false), rewardPayment},
              {JsonUtil.readFileAsString(PayloadFileLocations.ORIGINATOR, false), originator},
              {JsonUtil.readFileAsString(PayloadFileLocations.WALLET_PAYMENT, false), walletPayment},
              {JsonUtil.readFileAsString(PayloadFileLocations.CARD_PAYMENT, false), cardPayment},
              {JsonUtil.readFileAsString(PayloadFileLocations.QR_PAYMENT, false), qrPayment},
              {JsonUtil.readFileAsString(PayloadFileLocations.CUSTOMER, false), customer},
              {JsonUtil.readFileAsString(PayloadFileLocations.ADDRESS, false), address},
              {JsonUtil.readFileAsString(PayloadFileLocations.LOYALTY_CARD_PAYMENT, false), loyaltyCardPayment}
              //@formatter:on
      };
   }

   @DataProvider(name = "serialiseDeserialiseObjectDataProvider")
   public Object[][] serialiseDeserialiseObjectDataProvider() {
      return new Object[][] {
            //@formatter:off
              {pinHashed},
              {basicAdvice},
              {new BasicAdvice()
                      .amounts(new Amounts().approvedAmount(new LedgerAmount().amount(9000L).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT))).requestId("requestId")
                      .time(DateTime.now().toDateTime(DateTimeZone.UTC)).rrn("12345rrn").stan("12345stan")
                      .transactionIdentifiers(Collections.singletonList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId")))},
              {rewardPayment},
              {originator},
              {walletPayment},
              {cardPayment},
              {qrPayment},
              {address},
              {loyaltyCardPayment}
              //@formatter:on
      };
   }

   @DataProvider(name = "deserialiseSerialiseObjectDataProvider")
   public Object[][] deserialiseSerialiseObjectDataProvider() throws Exception {
      return new Object[][] {
            //@formatter:off
              {JsonUtil.readFileAsString(PayloadFileLocations.PIN_HASHED, false), PinHashed.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.BASIC_ADVICE, false), BasicAdvice.class},
              {"{\"id\":\"123456ID\",\"requestId\":\"requestId1\",\"time\":\"2013-06-07T08:11:59.000Z\",\"thirdPartyIdentifiers\":[{\"institutionId\":\"1234InsId\",\"transactionIdentifier\":\"1234transId\"}]," +
                      "\"stan\":\"12345stan\",\"rrn\":\"12345rrn\",\"amounts\":{\"approvedAmount\":{\"amount\":9000,\"currency\":\"710\",\"ledgerIndicator\":\"DEBIT\"}}}", BasicAdvice.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.REWARD_PAYMENT, false), RewardPayment.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.ORIGINATOR, false), Originator.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.WALLET_PAYMENT, false), WalletPayment.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.CARD_PAYMENT, false), CardPayment.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.QR_PAYMENT, false), QrPayment.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.ADDRESS, false), Address.class},
              {JsonUtil.readFileAsString(PayloadFileLocations.LOYALTY_CARD_PAYMENT, false), LoyaltyCardPayment.class}
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
              // {invalid example, valid example}
              {new PinHashed().hash("A").hashedPinParameters(new HashedPinParameters()), new PinHashed().hash("A").hashedPinParameters(new HashedPinParameters().name("MyAlg"))},
              {new BasicAdvice().id("123456ID").requestId("requestId").time(DateTime.now().toDateTime(DateTimeZone.UTC))
                      .amounts(new Amounts().approvedAmount(new LedgerAmount().amount(null).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT)))
                      .transactionIdentifiers(Collections.singletonList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId"))),
                      new BasicAdvice().id("123456ID").requestId("requestId").time(DateTime.now().toDateTime(DateTimeZone.UTC))
                              .amounts(new Amounts().approvedAmount(new LedgerAmount().amount(10000L).currency("710").ledgerIndicator(LedgerAmount.LedgerIndicator.DEBIT)))
                              .transactionIdentifiers(Collections.singletonList(new ThirdPartyIdentifier().institutionId("1234InsId").transactionIdentifier("1234transId")))},
              // validates that the `operatorId` field has length max 30
              {new Originator().terminalId("terminal").operatorId("String with more than thirty chars")
                      .institution(new Institution().id("institution id").name("institution name"))
                      .merchant(new Merchant().merchantId("123451234512345")
                      .merchantType("1234")
                      .merchantName(new MerchantName().city("cpt").name("name").country("ZA").region("ZA"))),
                      new Originator().terminalId("terminal").operatorId("String less than thirty")
                              .institution(new Institution().id("institution id").name("institution name"))
                              .merchant(new Merchant().merchantId("123451234512345")
                              .merchantType("1234")
                              .merchantName(new MerchantName().city("cpt").name("name").country("ZA").region("ZA")))
              },
              // validates that the `operatorId` field is optional i.e. can be null and thus is not set
              {new Originator().terminalId("terminal").operatorId("String with more than thirty chars")
                      .institution(new Institution().id("institution id").name("institution name"))
                      .merchant(new Merchant().merchantId("123451234512345")
                      .merchantType("1234")
                      .merchantName(new MerchantName().city("cpt").name("name").country("ZA").region("ZA"))),
                      new Originator().terminalId("terminal")
                              .institution(new Institution().id("institution id").name("institution name"))
                              .merchant(new Merchant().merchantId("123451234512345")
                              .merchantType("1234")
                              .merchantName(new MerchantName().city("cpt").name("name").country("ZA").region("ZA")))
              },
              {new WalletPayment().walletId(null).walletPocket(new WalletPocket())
                      .amount(new LedgerAmount().amount(456L).currency(null)),
                      new WalletPayment().walletId("0712345678")
                              .walletPocket(new WalletPocket().pocketName("Cash Pocket"))
                              .amount(new LedgerAmount().amount(456L).currency(
                              "710"))},
              {new CardPayment()
                    .amount(new LedgerAmount().amount(456L).currency("wrong"))
                    .name("Card Payment")
                    .issuer(new Institution().id("1234InsId").name("ThisInstitutionNameIsTooLong12345678912345"))
                    .proxy("12345")
                    .proxyType(ProxyType.UNKNOWN)
                    .pin(new PinEncrypted()),
               new CardPayment()
                     .pan("1234567891234567891")
                     .amount(new LedgerAmount().amount(456L).currency("710")).name("Card Payment")
                     .issuer(new Institution().id("1234InsId").name("Institution"))
                     .proxy(null)
                     .proxyType(ProxyType.UNKNOWN)},
              {new QrPayment()
                  .amount(new LedgerAmount().amount(456L).currency("wrong")).name("QR Payment")
                  .issuer(new Institution().id("1234InsId").name("ThisInstitutionNameIsTooLong12345678912345"))
                  .proxy("12345")
                  .proxyType(ProxyType.UNKNOWN),
               new QrPayment().tranId("e0aef114-f719-41c1-889e-4d18464254a0")
                   .partnerPaymentToken("4cc290e1-4018-4b28-9779-eba9fcb8004c")
                  .amount(new LedgerAmount().amount(456L).currency("710")).name("QR Payment")
                  .issuer(new Institution().id("1234InsId").name("Institution"))
                  .proxy(null)
                  .proxyType(ProxyType.UNKNOWN)},
              {new Address()
                    .addressLine1("41 Sheila Street")
                    .addressLine2("Edenvale")
                    .city("Johannesburg")
                    .region("Gauteng")
                    .country("ZA")
                    .postalCode("1609"),
               new Address()
                    .addressLine1("41 Sheila Street")
                    .addressLine2("Edenvale")
                    .city("Johannesburg")
                    .region("GP")
                    .country("ZA")
                    .postalCode("1609")},
              {new WalletPocket().pocketId("12345"), new WalletPocket().pocketId("12345").pocketName("Cash Pocket")},
              {new LoyaltyCardPayment().cardNumber("abfecc"), loyaltyCardPayment}
              //@formatter:on
      };
   }
}
