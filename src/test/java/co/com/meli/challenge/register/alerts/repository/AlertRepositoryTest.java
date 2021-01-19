package co.com.meli.challenge.register.alerts.repository;

import co.com.meli.challenge.register.alerts.model.dto.AlertServerDto;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlertRepositoryTest {

  @InjectMocks private AlertRepositoryImpl alertRepository;

  @Mock private JdbcTemplate template;

  private AlertServerDto alertServerDto;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    alertServerDto = new AlertServerDto();
  }

  @Test
  public void persistAlertSuccess() {
    // setup
    alertServerDtoWithData();

    // execution
    String result = alertRepository.create(this.alertServerDto);

    // assertions
    assertEquals("CREATED", result);
  }

  public void alertServerDtoWithData() {
    this.alertServerDto.setServerType("Virtual");
    this.alertServerDto.setServerName("SERVER");
    this.alertServerDto.setDescriptionAlert("Alert");
    this.alertServerDto.setCreatedAt(new Date(123123));
    this.alertServerDto.setAlertId("sadasd-asdasd-asdasd-sadasd");
  }
}
