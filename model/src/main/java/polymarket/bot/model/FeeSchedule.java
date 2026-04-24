package polymarket.bot.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class FeeSchedule {

    @Field(DBConstants.FEE_SCHEDULE.EXPONENT)
    private BigDecimal exponent;

    @Field(DBConstants.FEE_SCHEDULE.RATE)
    private BigDecimal rate;

    @Field(DBConstants.FEE_SCHEDULE.TAKER_ONLY)
    private Boolean takerOnly;

    @Field(DBConstants.FEE_SCHEDULE.REBATE_RATE)
    private BigDecimal rebateRate;

}
