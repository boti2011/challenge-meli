package co.com.meli.challenge.register.alerts.service;

import co.com.meli.challenge.register.alerts.model.AlertDto;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;
import co.com.meli.challenge.register.alerts.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertServiceImpl.class);

  private final AlertRepository repository;

  @Override
  public SaveAlertResponse createAlert(AlertDto alertDto) {
    LOGGER.info("Request: {}", alertDto.getAlertId());

    AlertDto alert = repository.findById(alertDto.getAlertId());
    SaveAlertResponse response = new SaveAlertResponse();
    response.setDescription(alert.getDescriptionAlert());
    return response;
  }
}
