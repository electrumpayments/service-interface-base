package io.electrum.vas;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class to make serialising and deserializing json objects more efficient
 */
public class JsonUtil {
   private final static ObjectMapper baseMapper = new ObjectMapper();
   private final static Map<Class<?>, ObjectReader> readerCache = new HashMap<>();
   private final static Map<Class<?>, ObjectWriter> writerCache = new HashMap<>();

   static {
      baseMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      baseMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
      baseMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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

   private static synchronized ObjectWriter getObjectWriter(Class<?> clazz) {
      ObjectWriter writer = writerCache.get(clazz);
      if (writer == null) {
         writer = baseMapper.writer().forType(clazz);
         writerCache.put(clazz, writer);
      }

      return writer;
   }

   public static ObjectMapper getBaseMapper() {
      return baseMapper;
   }
}