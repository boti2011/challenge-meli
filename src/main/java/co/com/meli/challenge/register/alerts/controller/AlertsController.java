package co.com.meli.challenge.register.alerts.controller;

import co.com.meli.challenge.register.alerts.model.AlertDto;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alerts")
public class AlertsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertsController.class);

  @PostMapping("/save")
  public ResponseEntity<SaveAlertResponse> handler(@RequestBody AlertDto request) {
    LOGGER.info("ServerName: {}", request.getServerName());
    SaveAlertResponse response = new SaveAlertResponse();
    response.setDescription("OK");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
