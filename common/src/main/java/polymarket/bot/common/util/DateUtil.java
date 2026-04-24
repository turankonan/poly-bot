package polymarket.bot.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.common.context.BaseContext;
import polymarket.bot.common.model.Language;

@Slf4j
public abstract class DateUtil {

    public final static DateTimeFormatter ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));
    public final static DateTimeFormatter ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE.withZone(ZoneId.from(ZoneOffset.UTC));
    public final static DateTimeFormatter CUSTOM_yyyyMMdd_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_yyyyMMdd_hhmm_FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_yyyy_MM_dd_hh_mm_ss_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_hhmm_FORMATTER = DateTimeFormatter.ofPattern("hh:mm").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_EMMMddyyyy_FORMATTER = DateTimeFormatter.ofPattern("E, MMM dd, yyyy").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_MMMddyyyy_FORMATTER_AR = DateTimeFormatter.ofPattern("dd MMM، yyyy").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_MMMddyyyy_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_MMMddyyyyHHmm_FORMATTER_AR = DateTimeFormatter.ofPattern("dd MMM، yyyy HH:mm").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_MMMddyyyyHHmm_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_dd_MM_yy_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yy").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_MMM_yy_FORMATTER = DateTimeFormatter.ofPattern("MMM-yy").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_yyyy_FORMATTER = DateTimeFormatter.ofPattern("yyyy").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_yy_FORMATTER = DateTimeFormatter.ofPattern("yy").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_MMMdd_FORMATTER = DateTimeFormatter.ofPattern("MMM dd").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_dd_FORMATTER = DateTimeFormatter.ofPattern("dd").withZone(ZoneOffset.UTC);
    public final static DateTimeFormatter CUSTOM_MMMM_FORMATTER = DateTimeFormatter.ofPattern("MMMM").withZone(ZoneOffset.UTC);

    public static String contentDateWithLanguageForReport(LocalDateTime dateTime, Language language) {
        if (dateTime != null) {
            if (language.equals(Language.EN) || language.equals(Language.EN_US)) {
                return DateUtil.convertDateTimeToString(dateTime, DateUtil.CUSTOM_MMMddyyyy_FORMATTER, language);
            } else {
                return DateUtil.convertDateTimeToString(dateTime, DateUtil.CUSTOM_MMMddyyyy_FORMATTER_AR, language);
            }
        }

        return null;
    }

    public static String contentDateWithLanguage(LocalDateTime dateTime, Language language) {
        if (dateTime != null) {
            if (dateTime.getHour() == 0 && dateTime.getMinute() == 0) {
                if (language.equals(Language.EN) || language.equals(Language.EN_US)) {
                    return DateUtil.convertDateTimeToString(dateTime, DateUtil.CUSTOM_MMMddyyyy_FORMATTER, language);
                } else {
                    return DateUtil.convertDateTimeToString(dateTime, DateUtil.CUSTOM_MMMddyyyy_FORMATTER_AR, language);
                }
            } else {
                if (language.equals(Language.EN) || language.equals(Language.EN_US)) {
                    return DateUtil.convertDateTimeToString(dateTime, DateUtil.CUSTOM_MMMddyyyyHHmm_FORMATTER, language);
                } else {
                    return DateUtil.convertDateTimeToString(dateTime, DateUtil.CUSTOM_MMMddyyyyHHmm_FORMATTER_AR, language);
                }
            }
        }

        return null;
    }

    public static String convertDateTimeToString(LocalDateTime dateTime, String pattern) {
        return convertDateTimeToString(dateTime, formatter(pattern, BaseContext.safeGet().getLanguage()), BaseContext.safeGet().getLanguage());
    }

    public static String convertDateTimeToString(LocalDateTime dateTime, String pattern, Language language) {
        return convertDateTimeToString(dateTime, formatter(pattern, language), language);
    }

    public static String convertDateToString(HijrahDate date, String pattern, Language language) {
        return convertDateToString(date, formatter(pattern, language), language);
    }

    public static String convertDateToString(LocalDate date, String pattern, Language language) {
        return convertDateToString(date, formatter(pattern, language), language);
    }

    public static LocalDateTime convertStringToDateTime(String date, String pattern, Language language) {
        return convertStringToDateTime(date, formatter(pattern, language), language);
    }

    public static LocalDate convertStringToDate(String date, String pattern, Language language) {
        return convertStringToDate(date, formatter(pattern, language), language);
    }

    public static LocalTime convertStringToLocalTime(String time) {
        if (StringUtils.hasText(time)) {
            return LocalTime.parse(time);
        }

        return null;
    }

    public static String convertDateTimeToString(LocalDateTime dateTime, DateTimeFormatter formatter) {
        if (dateTime != null) {
            try {
                return localeFormatter(formatter, BaseContext.safeGet().getLanguage()).format(dateTime);
            } catch (Exception e) {
                log.error("convertStringToDateTime got exception message: {}", e.getMessage(), e);
            }
        }

        return null;
    }

    public static String convertDateTimeToString(LocalDateTime dateTime, DateTimeFormatter formatter, Language language) {
        if (dateTime != null) {
            try {
                return localeFormatter(formatter, language).format(dateTime);
            } catch (Exception e) {
                log.error("convertStringToDateTime got exception message: {}", e.getMessage(), e);
            }
        }

        return null;
    }

    public static String convertDateToString(HijrahDate dateTime, DateTimeFormatter formatter, Language language) {
        if (dateTime != null) {
            try {
                return localeFormatter(formatter, language).format(dateTime);
            } catch (Exception e) {
                log.error("convertStringToDateTime got exception message: {}", e.getMessage(), e);
            }
        }

        return null;
    }

    public static String convertDateToString(LocalDate dateTime, DateTimeFormatter formatter) {
        return convertDateToString(dateTime, formatter, BaseContext.safeGet().getLanguage());
    }

    public static String convertDateToString(LocalDate dateTime, DateTimeFormatter formatter, Language language) {
        if (dateTime != null) {
            try {
                return localeFormatter(formatter, language).format(dateTime);
            } catch (Exception e) {
                log.error("convertStringToDateTime got exception message: {}", e.getMessage(), e);
            }
        }

        return null;
    }

    public static LocalDateTime convertStringToDateTime(String date, DateTimeFormatter formatter, Language language) {
        if (StringUtils.hasText(date)) {
            try {
                return LocalDateTime.parse(date, localeFormatter(formatter, language));
            } catch (Exception e) {
                log.error("convertDateTimeToString got exception message: {}", e.getMessage(), e);
            }
        }

        return null;
    }

    public static LocalDate convertStringToDate(String date, DateTimeFormatter formatter) {
        return convertStringToDate(date, formatter, BaseContext.safeGet().getLanguage());
    }

    public static LocalDate convertStringToDate(String date, DateTimeFormatter formatter, Language language) {
        if (StringUtils.hasText(date)) {
            try {
                return LocalDate.parse(date, localeFormatter(formatter, language));
            } catch (Exception e) {
                log.error("convertDateTimeToString got exception message: {}", e.getMessage(), e);
            }
        }

        return null;
    }

    private static DateTimeFormatter formatter(String pattern, Language language) {
        return localeFormatter(DateTimeFormatter.ofPattern(pattern).withZone(ZoneOffset.UTC), language);
    }

    private static DateTimeFormatter localeFormatter(DateTimeFormatter formatter, Language language) {
        if (Language.AR_SA.equals(language) || Language.AR.equals(language)) {
            formatter = formatter.withLocale(new Locale("ar", "SA"));
        }

        return formatter;
    }
}
