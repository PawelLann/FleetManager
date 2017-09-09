package com.fleet.manager.api.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

  @RequestMapping("/")
  String helloRox() {
    return "Welcome to Fleet Manager";
  }
}
