package co.com.meli.challenge.register.alerts.model.dto;

import co.com.meli.challenge.register.alerts.model.SaveAlertRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertServerDto extends SaveAlertRequest {

  private String alertId;
}
