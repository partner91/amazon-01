package hr.hrsak.amazon.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import hr.hrsak.amazon.entity.PriceInfo;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public interface DocumentService {



    Document getDocument(String url) throws IOException;

    Element getDocumentBody(Document document);

    Element getPriceElement(Element body);

    PriceInfo getPriceFromElement(Element priceElement) throws JsonProcessingException;
}
