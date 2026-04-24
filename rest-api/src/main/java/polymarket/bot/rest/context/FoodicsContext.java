package polymarket.bot.rest.context;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodicsContext {

    private static final ThreadLocal<FoodicsContext> threadLocal = new ThreadLocal<FoodicsContext>();

    private String accessToken;

    public static void unset() {
        threadLocal.remove();
    }

    public static FoodicsContext safeGet() {
        FoodicsContext context = threadLocal.get();
        if (context == null) {
            context = new FoodicsContext();
            threadLocal.set(context);
        }
        return context;
    }
}
