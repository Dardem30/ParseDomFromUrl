package com.example.parsedomfromurl.controller;

import com.example.parsedomfromurl.service.ParseUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParserController {
    private final ParseUrlService parseUrlService;

    @Autowired
    public ParserController(ParseUrlService parseUrlService) {
        this.parseUrlService = parseUrlService;
    }

    @PostMapping(value = "/parseUrl")
    public ResponseEntity<String> parseUrl(final @RequestParam("url") String url) {
        return ResponseEntity.ok(parseUrlService.parseUrl(url));
    }
}
