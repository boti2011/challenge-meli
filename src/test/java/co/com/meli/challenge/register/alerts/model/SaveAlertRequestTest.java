package co.com.meli.challenge.register.alerts.model;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class SaveAlertRequestTest {

  private SaveAlertRequest saveAlertRequest;

  @Before
  public void before() {
    saveAlertRequest = new SaveAlertRequest();
  }

  @Test
  public void createSaveAlertRequestAllArgsConstructorTest() {
    this.saveAlertRequest =
        new SaveAlertRequest("Server", "Alert Desc", new Date(12314), "Virtual");
    assertNotNull(this.saveAlertRequest);
  }

  @Test
  public void createSaveAlertRequestWithDataBySetters() {
    // setup
    this.saveAlertRequest.setCreatedAt(new Date(12345));
    this.saveAlertRequest.setDescriptionAlert("DESC");
    this.saveAlertRequest.setServerName("SERVER");
    this.saveAlertRequest.setServerType("VVVV");

    // assertions
    assertNotNull(this.saveAlertRequest);

    assertEquals("DESC", this.saveAlertRequest.getDescriptionAlert());
    assertEquals(new Date(12345), this.saveAlertRequest.getCreatedAt());
    assertEquals("SERVER", this.saveAlertRequest.getServerName());
    assertEquals("VVVV", this.saveAlertRequest.getServerType());
  }
}
