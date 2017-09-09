package com.fleet.manager.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@RestController
public class AppController {

  @RequestMapping("/")
  String helloRox() {
    return "Welcome to Fleet Manager";
  }
}
