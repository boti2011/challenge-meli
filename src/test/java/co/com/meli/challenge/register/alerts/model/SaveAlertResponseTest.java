package co.com.meli.challenge.register.alerts.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class SaveAlertResponseTest {

  private SaveAlertResponse saveAlertResponse;

  @Before
  public void before() {
    saveAlertResponse = new SaveAlertResponse();
  }

  @Test
  public void createSaveAlertResponseEmptyConstructorTest() {
    // assertions
    assertNotNull(this.saveAlertResponse);
  }

  @Test
  public void createSaveAlertRequestWithDataBySetters() {
    // setup
    this.saveAlertResponse.setDescription("OK");
    this.saveAlertResponse.setStatus(200);

    // assertions
    assertNotNull(this.saveAlertResponse);

    assertEquals(HttpStatus.OK.name(), this.saveAlertResponse.getDescription());
    assertEquals(HttpStatus.OK.value(), this.saveAlertResponse.getStatus().intValue());
  }
}
