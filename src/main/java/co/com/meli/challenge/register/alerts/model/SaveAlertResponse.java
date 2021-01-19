package co.com.meli.challenge.register.alerts.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApiModel(description = "Response structure to the alert creation")
public class SaveAlertResponse {

  @ApiModelProperty(notes = "Status response")
  private Integer status;

  @ApiModelProperty(notes = "Description of response")
  private String description;
}
