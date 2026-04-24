package polymarket.bot.sync.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class SlugUtil {

    private static final long FIVE_MINUTES_SECONDS = 300L;
    private static final long FIFTEEN_MINUTES_SECONDS = 900L;
    private static final long FOUR_HOURS_SECONDS = 14400L;

    public static final String ETH_SLUG_PREFIX = "eth-updown";
    public static final String SOL_SLUG_PREFIX = "sol-updown";
    public static final String DOGE_SLUG_PREFIX = "doge-updown";
    public static final String HYPE_SLUG_PREFIX = "hype-updown";
    public static final String XRP_SLUG_PREFIX = "xrp-updown";
    public static final String BNB_SLUG_PREFIX = "bnb-updown";
    public static final String BTC_SLUG_PREFIX = "btc-updown";

    public static final String BITCOIN_SLUG_PREFIX = "bitcoin-up-or-down";
    public static final String ETHEREUM_SLUG_PREFIX = "ethereum-up-or-down";
    public static final String SOLANA_SLUG_PREFIX = "solana-up-or-down";
    public static final String DOGECOIN_SLUG_PREFIX = "dogecoin-up-or-down";
    public static final String RIPPLE_SLUG_PREFIX = "xrp-up-or-down";
    public static final String HYPERLIQUID_SLUG_PREFIX = "hype-up-or-down";
    public static final String BNB2_SLUG_PREFIX = "bnb-up-or-down";

    public static String next5mSlug(String base) {
        long now = Instant.now().getEpochSecond();
        long nextSlot = ((now / FIVE_MINUTES_SECONDS) + 1) * FIVE_MINUTES_SECONDS;
        return base + "-5m-" + nextSlot;
    }

    public static String next15mSlug(String base) {
        long now = Instant.now().getEpochSecond();
        long nextSlot = ((now / FIFTEEN_MINUTES_SECONDS) + 1) * FIFTEEN_MINUTES_SECONDS;
        return base + "-15m-" + nextSlot;
    }

    public static String next4hSlug(String base) {
        long now = Instant.now().getEpochSecond();
        long nextSlot = ((now / FOUR_HOURS_SECONDS) + 1) * FOUR_HOURS_SECONDS;
        return base + "-4h-" + nextSlot;
    }

    public static String next1hSlug(String base) {
        ZonedDateTime nextHour = ZonedDateTime.now(ZoneId.of("America/New_York"))
                .plusHours(1)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        String datePart = nextHour.format(DateTimeFormatter.ofPattern("MMMM-d-yyyy", Locale.ENGLISH)).toLowerCase();
        String hourPart = nextHour.format(DateTimeFormatter.ofPattern("ha", Locale.ENGLISH)).toLowerCase();
        return base + "-" + datePart + "-" + hourPart + "-et";
    }

    public static String nextDailySlug(String base) {
        LocalDate tomorrow = LocalDate.now(ZoneOffset.UTC).plusDays(1);
        String formatted = tomorrow.format(DateTimeFormatter.ofPattern("MMMM-d-yyyy", Locale.ENGLISH)).toLowerCase();
        return base + "-on-" + formatted;
    }

}
