package co.com.meli.challenge.register.alerts.service;

import co.com.meli.challenge.register.alerts.model.SaveAlertRequest;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;
import co.com.meli.challenge.register.alerts.model.domain.Status;
import co.com.meli.challenge.register.alerts.model.dto.AlertServerDto;
import co.com.meli.challenge.register.alerts.repository.AlertRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertServiceImpl.class);

  private final AlertRepository repository;

  @Override
  public SaveAlertResponse createAlert(SaveAlertRequest saveAlertRequest) {
    LOGGER.info("Request: {}", saveAlertRequest.getDescriptionAlert());

    SaveAlertResponse response = new SaveAlertResponse();
    AlertServerDto alertServerDto = new AlertServerDto();
    alertServerDto.setAlertId(UUID.randomUUID().toString());
    alertServerDto.setCreatedAt(saveAlertRequest.getCreatedAt());
    alertServerDto.setDescriptionAlert(saveAlertRequest.getDescriptionAlert());
    alertServerDto.setServerName(saveAlertRequest.getServerName());
    alertServerDto.setServerType(saveAlertRequest.getServerType());

    final String result = repository.create(alertServerDto);
    if (Status.CREATED.toString().equals(result)) {
      response.setDescription(HttpStatus.OK.name());
      response.setStatus(HttpStatus.OK.value());
    } else {
      response.setDescription(HttpStatus.INTERNAL_SERVER_ERROR.name());
      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
    return response;
  }
}
