package polymarket.bot.model;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
public class ImageOptimized {

    @Field(DBConstants.IMAGE_OPTIMIZED.IMAGE_URL_SOURCE)
    private String imageUrlSource;

    @Field(DBConstants.IMAGE_OPTIMIZED.IMAGE_URL_OPTIMIZED)
    private String imageUrlOptimized;

    @Field(DBConstants.IMAGE_OPTIMIZED.IMAGE_SIZE_KB_SOURCE)
    private BigDecimal imageSizeKbSource;

    @Field(DBConstants.IMAGE_OPTIMIZED.IMAGE_SIZE_KB_OPTIMIZED)
    private BigDecimal imageSizeKbOptimized;

    @Field(DBConstants.IMAGE_OPTIMIZED.IMAGE_OPTIMIZED_COMPLETE)
    private Boolean imageOptimizedComplete;

    @Field(DBConstants.IMAGE_OPTIMIZED.IMAGE_OPTIMIZED_LAST_UPDATED)
    private String imageOptimizedLastUpdated;

    @Field(DBConstants.IMAGE_OPTIMIZED.REL_ID)
    private BigDecimal relID;

    @Field(DBConstants.IMAGE_OPTIMIZED.FIELD)
    private String field;

    @Field(DBConstants.IMAGE_OPTIMIZED.RELNAME)
    private String relname;

}
