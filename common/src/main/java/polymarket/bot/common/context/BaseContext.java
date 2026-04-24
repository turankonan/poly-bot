package polymarket.bot.common.context;

import org.springframework.util.StringUtils;

import lombok.Getter;
import lombok.Setter;
import polymarket.bot.common.model.Language;

@Getter
@Setter
public class BaseContext {

    private static final ThreadLocal<BaseContext> threadLocal = new ThreadLocal<BaseContext>();

    private Integer buildNumber;
    private String messageId;
    private String clientIp;
    private String deviceId;
    private Language language;
    private String environment;
    private String accessToken;
    private String sessionId;

    public static void unset() {
        threadLocal.remove();
    }

    public static BaseContext safeGet() {
        BaseContext context = threadLocal.get();
        if (context == null) {
            context = new BaseContext();
            threadLocal.set(context);
        }
        return context;
    }

    public String log() {
        StringBuilder builder = new StringBuilder();

        builder.append(" FORWARDED_IP: ");
        if (StringUtils.hasText(getClientIp())) {
            builder.append(getClientIp());
        }

        builder.append(" ENVIRONMENT: ");
        if (StringUtils.hasText(getEnvironment())) {
            builder.append(getEnvironment());
        }

        builder.append(" BUILD_NUMBER: ");
        if (getBuildNumber() != null) {
            builder.append(getBuildNumber());
        }

        builder.append(" DEVICE_ID: ");
        if (StringUtils.hasText(getDeviceId())) {
            builder.append(getDeviceId());
        }

        builder.append(" LOCALE_KEY: ");
        if (getLanguage() != null) {
            builder.append(getLanguage().getValue());
        }

        return builder.toString();
    }

    public String token() {
        if (StringUtils.hasText(getAccessToken())) {
            return "Bearer " + getAccessToken();
        }

        return null;
    }

    public Boolean loggedIn() {
        return StringUtils.hasText(getAccessToken());
    }
}
