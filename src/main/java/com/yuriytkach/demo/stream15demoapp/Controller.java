package com.yuriytkach.demo.stream15demoapp;

import java.time.Duration;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class Controller {

  private final Service service;

  @GetMapping("/op/{name}")
  public ResponseEntity<String> operation(
    @PathVariable final String name
  ) {
    final String operation = service.operation(name);
    return ResponseEntity.status(200)
      .cacheControl(CacheControl.maxAge(Duration.ofDays(1))) // cache in client's browser for 1 day
      .body(operation);
  }

  @GetMapping("/op2/{name1}/{name2}")
  public String operation(
    @PathVariable final String name1,
    @PathVariable final String name2
  ) {
    return service.operation2(name1, name2);
  }

  @GetMapping("/clean/{name}")
  public String clean(
    @PathVariable final String name
  ) {
    return service.clean(name);
  }

  @GetMapping("/up/{name}")
  public String update(
    @PathVariable final String name
  ) {
    return service.update(name);
  }

}
