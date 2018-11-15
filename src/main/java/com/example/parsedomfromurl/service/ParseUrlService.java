package com.example.parsedomfromurl.service;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class ParseUrlService {
    private final static Logger logger = Logger.getLogger(ParseUrlService.class);

    public String parseUrl(String inUrl) {
        try {
            Document doc = Jsoup.connect(inUrl).get();
            String host = URI.create(inUrl).getHost();
            Elements links = doc.select("a[href]");
            StringBuilder result = new StringBuilder("Рекламные ссылки: \n");
            links.stream()
                    .map(link -> link.attr("href"))
                    .filter(hrefUrl -> hrefUrl.contains("http"))
                    .filter(hrefUrl -> !host.equals(URI.create(hrefUrl).getHost()))
                    .forEach(hrefUrl -> result.append("    ").append(hrefUrl).append("\n"));
            return inUrl;
        } catch (Exception e) {
            logger.error("Error during parsing url", e);
            return "Exception";
        }
    }
}
