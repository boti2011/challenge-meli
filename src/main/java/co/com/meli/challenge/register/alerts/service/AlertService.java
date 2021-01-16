package co.com.meli.challenge.register.alerts.service;

import co.com.meli.challenge.register.alerts.model.SaveAlertRequest;
import co.com.meli.challenge.register.alerts.model.SaveAlertResponse;

public interface AlertService {

  SaveAlertResponse createAlert(SaveAlertRequest saveAlertRequest);
}
