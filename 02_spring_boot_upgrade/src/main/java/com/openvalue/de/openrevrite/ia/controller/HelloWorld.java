package com.openvalue.de.openrevrite.ia.controller;

import com.openvalue.de.openrevrite.ia.service.CounterService;
import javax.inject.Inject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld
{
   private final CounterService counterService;

   @Inject
   public HelloWorld(CounterService counterService) {

      this.counterService = counterService;
   }

   @RequestMapping("/")
   public String hello() {
      return "Hello World! Visited: " + counterService.incrementAndGet() + " times!";
   }
}
