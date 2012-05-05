package ru.geochat.web.controllers;

import java.io.IOException;
import java.io.Writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

  private static Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

  @RequestMapping(value = "/say/{name}", method = RequestMethod.GET)
  public void hello(@PathVariable("name") String name, Writer writer) throws IOException {
    logger.info("Invoked rest method hello with param {}", name);
    writer.write("Hello, " + name);
  }

}
