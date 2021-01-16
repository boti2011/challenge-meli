package co.com.meli.challenge.register.alerts.service;

import co.com.meli.challenge.register.alerts.model.AlertDto;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;

public interface AlertService {

  SaveAlertResponse createAlert(AlertDto alertDto);
}
