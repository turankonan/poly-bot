package polymarket.bot.common.interceptor;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import polymarket.bot.common.constants.RequestHeaderConstants;
import polymarket.bot.common.context.BaseContext;
import polymarket.bot.common.model.Language;

@Component
@Slf4j
public class BaseInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        setRequestContext(request);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        BaseContext.unset();
        MDC.clear();
    }

    private void setRequestContext(HttpServletRequest request) {
        BaseContext context = BaseContext.safeGet();

        String langKey = request.getHeader(RequestHeaderConstants.LANGUAGE);
        String buildNumber = request.getHeader(RequestHeaderConstants.BUILD_NUMBER);
        String messageId = request.getHeader(RequestHeaderConstants.MESSAGE_ID);
        String sessionId = request.getHeader(RequestHeaderConstants.SESSION_ID);
        String forwardedFor = request.getHeader(RequestHeaderConstants.FORWARDED_FOR);

        String txKey = (StringUtils.hasText(messageId) ? messageId : "") + "::" + Thread.currentThread().getId() + "::" + System.nanoTime();
        context.setMessageId(txKey);

        if (StringUtils.hasText(langKey)) {
            Language l = Language.from(langKey);
            context.setLanguage(l);
        }

        if (StringUtils.hasText(forwardedFor)) {
            context.setClientIp(forwardedFor);
        }

        if (StringUtils.hasText(sessionId)) {
            context.setSessionId(sessionId);
        }

        if (StringUtils.hasText(buildNumber) && NumberUtils.isDigits(buildNumber)) {
            context.setBuildNumber(Integer.valueOf(buildNumber));
        } else {
            context.setBuildNumber(0);
        }

        if (StringUtils.hasText(messageId)) {
            context.setMessageId(messageId);
        }

        MDC.put("contextLog", context.log());
    }
}
