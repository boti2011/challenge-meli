package co.com.meli.challenge.register.alerts.model.dto;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AlertServerDtoTest {

  private AlertServerDto alertServerDto;

  @Before
  public void before() {
    this.alertServerDto = new AlertServerDto();
  }

  @Test
  public void createSaveAlertRequestAllArgsConstructorTest() {
    this.alertServerDto = new AlertServerDto("1234-123sd-123csd");
    assertNotNull(this.alertServerDto);
  }

  @Test
  public void createSaveAlertRequestWithDataBySetters() {
    // setup
    this.alertServerDto.setCreatedAt(new Date(12345));
    this.alertServerDto.setDescriptionAlert("DESC");
    this.alertServerDto.setServerName("SERVER");
    this.alertServerDto.setServerType("VVVV");
    this.alertServerDto.setAlertId("48sada-asd48sad-asdas9-asda5");

    // assertions
    assertNotNull(this.alertServerDto);

    assertEquals("DESC", this.alertServerDto.getDescriptionAlert());
    assertEquals(new Date(12345), this.alertServerDto.getCreatedAt());
    assertEquals("SERVER", this.alertServerDto.getServerName());
    assertEquals("VVVV", this.alertServerDto.getServerType());
    assertEquals("48sada-asd48sad-asdas9-asda5", this.alertServerDto.getAlertId());
  }
}
