package polymarket.bot.common.util;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Base64;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.common.model.Language;

@Slf4j
public abstract class GsonUtil {

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return getGson().fromJson(json, classOfT);
    }

    public static String toJson(Object src) {
        return getGson().toJson(src);
    }

    public static Gson getGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeHierarchyAdapter(byte[].class, new ByteArrayToBase64TypeAdapter());
        return gsonBuilder.create();
    }

    private static class ByteArrayToBase64TypeAdapter implements JsonDeserializer<byte[]> {

        @Override
        public byte[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return Base64.getDecoder().decode(json.getAsString());
        }
    }

    private static class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {
        @Override
        public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                return DateUtil.convertStringToDateTime(jsonElement.getAsString(), DateUtil.ISO_DATE_TIME_FORMATTER, Language.EN_US);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            return null;
        }
    }

    private static class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {

        @Override
        public JsonElement serialize(LocalDateTime dateTime, Type type, JsonSerializationContext jsonSerializationContext) {
            try {
                return new JsonPrimitive(DateUtil.convertDateTimeToString(dateTime, DateUtil.ISO_DATE_TIME_FORMATTER, Language.EN_US));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            return null;
        }
    }

    private static class LocalDateSerializer implements JsonSerializer<LocalDate> {

        @Override
        public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
            try {
                return new JsonPrimitive(DateUtil.convertDateToString(localDate, DateUtil.ISO_DATE_FORMATTER, Language.EN_US));
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            return null;
        }
    }

    private static class LocalDateDeserializer implements JsonDeserializer<LocalDate> {
        @Override
        public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            try {
                return DateUtil.convertStringToDate(jsonElement.getAsString(), DateUtil.ISO_DATE_FORMATTER, Language.EN_US);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }

            return null;
        }
    }
}
