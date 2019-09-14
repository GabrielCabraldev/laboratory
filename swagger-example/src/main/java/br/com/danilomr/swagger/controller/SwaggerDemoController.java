package br.com.danilomr.swagger.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class SwaggerDemoController {

    @GetMapping("/{key}")
    public ResponseEntity<String> get(@PathVariable(value = "key", required = true) final String key) {
        return ResponseEntity.ok("API returned " + key);
    }

}
