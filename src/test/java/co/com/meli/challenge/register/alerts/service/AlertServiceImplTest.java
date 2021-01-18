package co.com.meli.challenge.register.alerts.service;

import co.com.meli.challenge.register.alerts.model.SaveAlertRequest;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;
import co.com.meli.challenge.register.alerts.repository.AlertRepository;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
public class AlertServiceImplTest {

  @TestConfiguration
  static class EmployeeServiceImplTestContextConfiguration {

    @Autowired private AlertRepository repository;

    @Bean
    public AlertServiceImpl service() {
      return new AlertServiceImpl(repository);
    }
  }

  @MockBean private AlertRepository repository;

  @Autowired private AlertService service;

  private SaveAlertRequest request;

  @Before
  public void Before() {
    MockitoAnnotations.initMocks(this);
    this.request = new SaveAlertRequest();
  }

  @Test
  public void createAlertTestSuccess() {
    // setup
    requestCreateAlertWithData();
    String repositoryResponse = "CREATED";

    Mockito.when(repository.create(Mockito.any())).thenReturn(repositoryResponse);

    // execution
    final SaveAlertResponse responseService = service.createAlert(this.request);

    // asserts
    assertNotNull(responseService);

    assertEquals("OK", responseService.getDescription());
    assertEquals(200, responseService.getStatus());
  }

  @Test
  public void createAlertTestError() {
    // setup
    requestCreateAlertWithData();
    String repositoryResponse = "ERROR";

    Mockito.when(repository.create(Mockito.any())).thenReturn(repositoryResponse);

    // execution
    final SaveAlertResponse responseService = service.createAlert(this.request);

    // asserts
    assertNotNull(responseService);

    assertEquals("INTERNAL_SERVER_ERROR", responseService.getDescription());
    assertEquals(500, responseService.getStatus());
  }

  public void requestCreateAlertWithData() {
    this.request.setServerType("Virtual");
    this.request.setServerName("SERVER");
    this.request.setDescriptionAlert("Alert");
    this.request.setCreatedAt(new Date(123123));
  }
}
