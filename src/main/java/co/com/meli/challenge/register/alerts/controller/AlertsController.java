package co.com.meli.challenge.register.alerts.controller;

import co.com.meli.challenge.register.alerts.model.SaveAlertRequest;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;
import co.com.meli.challenge.register.alerts.service.AlertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
@Api(value = "API for register alerts")
public class AlertsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertsController.class);

  private final AlertService service;

  @ApiOperation(value = "Create alerts with all properties", response = SaveAlertResponse.class)
  @RequestMapping(method = RequestMethod.POST, produces = "application/json")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success alert create", response = SaveAlertResponse.class),
        @ApiResponse(code = 500, message = "Technical Error without business control")
      })
  @PostMapping("/create")
  public ResponseEntity<SaveAlertResponse> createAlert(@RequestBody SaveAlertRequest request) {
    LOGGER.info("ServerName: {}", request.getServerName());
    SaveAlertResponse response = service.createAlert(request);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
