package co.com.meli.challenge.register.alerts.controller;

import co.com.meli.challenge.register.alerts.model.SaveAlertRequest;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;
import co.com.meli.challenge.register.alerts.service.AlertService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class AlertsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertsController.class);

  private final AlertService service;

  @PostMapping("/create")
  public ResponseEntity<SaveAlertResponse> createAlert(@RequestBody SaveAlertRequest request) {
    LOGGER.info("ServerName: {}", request.getServerName());
    SaveAlertResponse response = service.createAlert(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
