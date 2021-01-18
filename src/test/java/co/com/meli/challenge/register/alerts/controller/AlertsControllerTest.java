package co.com.meli.challenge.register.alerts.controller;

import co.com.meli.challenge.register.alerts.model.SaveAlertRequest;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;
import co.com.meli.challenge.register.alerts.service.AlertService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AlertsControllerTest {

  @InjectMocks private AlertsController controller;

  @Mock private AlertService service;

  private SaveAlertResponse saveAlertResponse;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    this.saveAlertResponse = new SaveAlertResponse();
    fillSuccessResponseWithData();
  }

  @Test
  public void createAlertSuccess() {
    // setup
    fillSuccessResponseWithData();

    // execution
    final ResponseEntity<SaveAlertResponse> response =
        controller.createAlert(new SaveAlertRequest());

    // assertions
    assertNotNull(response);

    assertEquals(200, response.getStatusCodeValue());
    assertEquals("OK", response.getStatusCode().name());
  }

  public void fillSuccessResponseWithData() {
    this.saveAlertResponse.setStatus(200);
    this.saveAlertResponse.setDescription("OK");
  }
}
