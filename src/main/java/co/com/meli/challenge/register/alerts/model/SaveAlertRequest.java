package co.com.meli.challenge.register.alerts.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Structure to receive alert's information")
public class SaveAlertRequest {

  @ApiModelProperty(notes = "Server Name for register alert")
  @JsonProperty("server")
  private String serverName;

  @ApiModelProperty(notes = "Description of alert")
  @JsonProperty("description")
  private String descriptionAlert;

  @ApiModelProperty(notes = "Creation Date of Alert")
  @JsonProperty("created_at")
  @JsonFormat(pattern = "dd-MM-yyyy hh:mm:ss")
  private Date createdAt;

  @ApiModelProperty(notes = "Server Type")
  @JsonProperty("server_type")
  private String serverType;
}
