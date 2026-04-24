package polymarket.bot.common.model;

import java.util.Locale;

public enum Language {

    EN_US("en-US"),
    AR_SA("ar-sa"),
    EN("en"),
    AR("ar");

    private String value;

    Language(String value) {
        this.value = value;
    }

    public static Language from(String language) {
        for (Language l : values()) {
            if (l.getValue().equals(language)) {
                return l;
            }
        }

        return null;
    }

    public String getValue() {
        return value;
    }

    public Locale getLocale() {
        return new Locale(getValue());
    }

}
