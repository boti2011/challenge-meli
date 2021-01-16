package co.com.meli.challenge.register.alerts.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertDto {

  private String alertId;
  private String serverName;
  private String descriptionAlert;
  private String createdAt;
  private String serverType;
}
