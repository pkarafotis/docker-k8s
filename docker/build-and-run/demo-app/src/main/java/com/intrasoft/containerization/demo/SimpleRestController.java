package com.intrasoft.containerization.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

  private static final Logger logger = LoggerFactory.getLogger(SimpleRestController.class);

  @Value("${greetings.message}")
  private String msg;

  @RequestMapping("/")
  public String printMsg() {
    logger.debug("printMsg endpoint was called!!!");
    return msg;
  }
}
