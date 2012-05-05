package ru.geochat.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/location")
public class LocationController {

  @RequestMapping(value="/index", method=RequestMethod.GET)
  public String getIndex() {
    return "map";
  }
}
