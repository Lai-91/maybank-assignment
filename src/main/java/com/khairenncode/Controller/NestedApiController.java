package com.khairenncode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("/nested")
public class NestedApiController {
    HttpClient client = HttpClient.newHttpClient();

    @GetMapping(value = "/catfact", produces = "application/json")
    public ResponseEntity<String> getRandomCatFact() throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(URI.create("https://catfact.ninja/fact")).header("Accept","application/json").GET().build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return new ResponseEntity<String>(response.body(), HttpStatus.valueOf(200));
        }
        else {
            return new ResponseEntity<String>(response.body(), HttpStatus.valueOf(response.statusCode()));
        }
    }
}
