package polymarket.bot.model;

import org.json.JSONObject;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import polymarket.bot.common.model.Language;
import polymarket.bot.common.util.I18NUtil;

@Data
public class MultilingualText {

    @Field(DBConstants.BASE.AR_SA)
    private String arSA;

    @Field(DBConstants.BASE.EN_US)
    private String enUS;

    public String text() {
        return I18NUtil.text(getArSA(), getEnUS());
    }

    public static MultilingualText with(JSONObject jsonObject) {

        MultilingualText text = new MultilingualText();
        text.setArSA(jsonObject.getString(Language.AR_SA.getValue()));
        text.setEnUS(jsonObject.getString(Language.EN_US.getValue()));

        return text;
    }

    public static MultilingualText with(String value) {
        return with(value, value);
    }

    public static MultilingualText with(String ar, String en) {

        MultilingualText text = new MultilingualText();
        text.setArSA(ar);
        text.setEnUS(en);

        return text;
    }
}
