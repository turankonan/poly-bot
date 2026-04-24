package polymarket.bot.common.util;

import org.json.JSONObject;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.common.context.BaseContext;
import polymarket.bot.common.model.Language;

@Slf4j
public abstract class I18NUtil {

    public static <T> T object(Language language, T ar, T en) {
        if (language == null) {
            language = Language.AR_SA;
        }

        switch (language) {
            case EN_US:
                return en;
            default:
                return ar;
        }
    }

    public static String text(Language language, String ar, String en) {
        if (language == null) {
            language = Language.AR_SA;
        }

        switch (language) {
            case EN_US:
                return en;
            default:
                return ar;
        }
    }

    public static <T> T object(T ar, T en) {
        return object(BaseContext.safeGet().getLanguage(), ar, en);
    }

    public static String text(String ar, String en) {
        return text(BaseContext.safeGet().getLanguage(), ar, en);
    }

    public static String replaceString(String message, JSONObject args) {
        if (args == null) {
            return message;
        }

        for (Object a : args.keySet()) {
            Object value = args.get(a.toString());
            if (value != null) {
                message = StringUtils.replace(message, "{" + a + "}", value.toString());
            }
        }

        return message;
    }
}
