package hr.hrsak.amazon.controllers;

import hr.hrsak.amazon.entity.PriceInfo;
import hr.hrsak.amazon.services.DocumentService;
import jakarta.annotation.Resource;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class PriceController {

    @Resource
    private DocumentService documentService;

    @Value("${amazon.url}")
    private String amazonUrl;

    @GetMapping("/price/{asin}")
    public ResponseEntity<PriceInfo> getPrice(@PathVariable String asin) throws IOException {
        Document document = documentService.getDocument(amazonUrl + asin);
        Element documentBody = documentService.getDocumentBody(document);
        Element priceElement = documentService.getPriceElement(documentBody);
        return ResponseEntity.ok(documentService.getPriceFromElement(priceElement));
    }
}
