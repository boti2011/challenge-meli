package co.com.meli.challenge.register.alerts.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveAlertRequest {

  @JsonProperty("server")
  private String serverName;

  @JsonProperty("description")
  private String descriptionAlert;

  @JsonProperty("created_at")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  private Date createdAt;

  @JsonProperty("server_type")
  private String serverType;
}
