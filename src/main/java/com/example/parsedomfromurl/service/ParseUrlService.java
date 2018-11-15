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
            return inUrl;
        } catch (Exception e) {
            logger.error("Error during parsing url", e);
            return "Exception";
        }
    }
}
