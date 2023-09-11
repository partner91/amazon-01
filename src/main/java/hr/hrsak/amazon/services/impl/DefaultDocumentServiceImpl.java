package hr.hrsak.amazon.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr.hrsak.amazon.entity.PriceInfo;
import hr.hrsak.amazon.services.DocumentService;
import jakarta.annotation.Resource;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DefaultDocumentServiceImpl implements DocumentService {
    @Value("${amazon.class.price}")
    private String priceClass;

    @Resource
    private OkHttpClient client;

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public Document getDocument(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try(Response response = client.newCall(request).execute()) {
            String html = response.body().string();
            return Jsoup.parse(html);
        } catch (IOException e) {
            throw new IOException("Error while getting document from url: " + url, e);
        }

    }

    @Override
    public Element getDocumentBody(Document document) {
        return  document.body();
    }

    @Override
    public Element getPriceElement(Element body) {
        return body.select(priceClass).first();
    }

    @Override
    public PriceInfo getPriceFromElement(Element priceElement) throws JsonProcessingException {
        String jsonString = priceElement.text();
        JSONObject jsonObject = new JSONObject(jsonString);
        String[] keys = JSONObject.getNames(jsonObject);
        JSONArray jsonArray = jsonObject.getJSONArray(keys[0]);
        JSONObject finalValues = jsonArray.getJSONObject(0);
        return objectMapper.readValue(finalValues.toString(), PriceInfo.class);
}
}
