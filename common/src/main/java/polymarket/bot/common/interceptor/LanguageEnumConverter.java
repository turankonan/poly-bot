package polymarket.bot.common.interceptor;

import org.springframework.core.convert.converter.Converter;

import lombok.extern.slf4j.Slf4j;
import polymarket.bot.common.model.Language;

@Slf4j
public class LanguageEnumConverter implements Converter<String, Language> {

    @Override
    public Language convert(String source) {
        return Language.from(source);
    }
}
