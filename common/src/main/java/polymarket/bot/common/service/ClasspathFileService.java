package polymarket.bot.common.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
public class ClasspathFileService implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public JSONObject loadJsonObject(String filePath) throws IOException {
        return new JSONObject(loadResource(filePath));
    }

    public JSONArray loadJsonArray(String filePath) throws IOException {
        return new JSONArray(loadResource(filePath));
    }

    public String loadResource(String filePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + filePath);

        return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
