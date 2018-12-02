package com.example.parsedomfromurl.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ParseUrlService {

    /**
     * This method get all advertisements href of page
     * @param inUrl
     * @return string(all url of advertisements)
     */
    public final String parseUrl(final String inUrl) throws IOException {
        try {
            final Document doc = Jsoup.connect(inUrl).get();
            final String host = URI.create(inUrl).getHost();
            final Elements links = doc.select("a[href]");
            return "Рекламные ссылки: \n    " + links.stream()
                    .map(link -> link.attr("href"))
                    .parallel()
                    .filter(hrefUrl -> hrefUrl.contains("http") && !host.equals(URI.create(hrefUrl).getHost()))
                    .collect(Collectors.joining("\n    "));
        } catch (final IOException e) {
            log.error("Error during parsing url", e);
            throw new IOException(e);
        }
    }
}