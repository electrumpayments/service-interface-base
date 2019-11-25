package io.electrum.vas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Class to make serialising and deserializing json objects more efficient For serializing/deserializing from json file,
 * ensure the file is in the './src/test/resources/messages/' directory
 */
public class JsonUtil {

   public static String TEST_MSG_FILE_PATH = "./src/test/resources/messages/";
   private final static ObjectMapper baseMapper = new ObjectMapper();
   private final static Map<Class<?>, ObjectReader> readerCache = new HashMap<>();
   private final static Map<Class<?>, ObjectWriter> writerCache = new HashMap<>();

   static {
      baseMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      baseMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
      baseMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      baseMapper.registerModule(new JodaModule());
      baseMapper.registerModule(new Jdk8Module());
      baseMapper.registerModule(new JavaTimeModule());
   }

   @SuppressWarnings("unchecked")
   public static <T> T deserialize(String jsonStr, Class<T> clazz) throws IOException {
      if (jsonStr == null) {
         return null;
      }

      ObjectReader reader = getObjectReader(clazz);

      return (T) reader.readValue(jsonStr);
   }

   @SuppressWarnings("unchecked")
   public static <T> T deserialize(byte[] data, Class<T> clazz) throws IOException {
      if (data == null) {
         return null;
      }

      ObjectReader reader = getObjectReader(clazz);

      return (T) reader.readValue(data);
   }

   private static synchronized ObjectReader getObjectReader(Class<?> clazz) {
      ObjectReader reader = readerCache.get(clazz);
      if (reader == null) {
         reader = baseMapper.reader().forType(clazz);
         readerCache.put(clazz, reader);
      }

      return reader;
   }

   public static String serialize(Object jsonObj, Class<?> clazz) throws IOException {
      if (jsonObj == null) {
         return null;
      }

      ObjectWriter writer = getObjectWriter(clazz);

      return writer.writeValueAsString(jsonObj);
   }

   public static String serialize(Object jsonObj) throws IOException {
      if (jsonObj == null) {
         return null;
      }

      ObjectWriter writer = getObjectWriter();

      return writer.writeValueAsString(jsonObj);
   }

   private static synchronized ObjectWriter getObjectWriter(Class<?> clazz) {
      ObjectWriter writer = writerCache.get(clazz == null ? String.class : clazz);
      if (writer == null) {
         writer = clazz == null ? baseMapper.writer() : baseMapper.writer().forType(clazz);
         writerCache.put(clazz == null ? String.class : clazz, writer);
      }

      return writer;
   }

   private static synchronized ObjectWriter getObjectWriter() {
      return getObjectWriter(null);
   }

   public static ObjectMapper getBaseMapper() {
      return baseMapper;
   }

   /**
    * Method to deserialise a Json object from a file.
    *
    * @param <T>
    *           The payload for the json object
    * @param filename
    *           The name of the file with the JSon object
    * @param clazz
    *           name of Class type to be deserialized into
    * @param preserveWhitespace
    *           whether to include spaces/newline characters when reading from file
    *
    * @return the payload of the json object to be created.
    * @throws Exception
    *            Any exception found will be thrown.
    */
   public static <T> T deserialiseJsonObjectFromFile(String filename, Class<T> clazz, boolean preserveWhitespace)
         throws Exception {
      return JsonUtil.deserialize(readFileAsString(filename, preserveWhitespace), clazz);
   }

   /**
    * Method to read a Json file and return a String representation of the file.
    * 
    * @param filename
    *           Name of file to be read
    * @param preserveWhitespace
    *           whether to include spaces/newline characters when reading from file
    * 
    * @return String representation of json file
    * @throws Exception
    *            Any exceptions found trying to read file will be thrown
    */
   public static String readFileAsString(String filename, boolean preserveWhitespace) throws Exception {
      StringBuilder sb = new StringBuilder();
      try (BufferedReader br = new BufferedReader(new FileReader(TEST_MSG_FILE_PATH + filename))) {
         String line = br.readLine();
         while (line != null) {
            if (preserveWhitespace) {
               sb.append(line);
               sb.append(System.lineSeparator());
            } else {
               sb.append(line.trim());
            }
            line = br.readLine();
         }
      }
      String fileContents = sb.toString();
      if (preserveWhitespace) {
         fileContents = fileContents.substring(0, fileContents.length() - 1);
      }
      return fileContents;
   }
}