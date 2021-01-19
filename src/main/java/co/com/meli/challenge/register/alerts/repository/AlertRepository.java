package co.com.meli.challenge.register.alerts.repository;

import co.com.meli.challenge.register.alerts.model.dto.AlertServerDto;

public interface AlertRepository {

  String create(AlertServerDto alertServerDto);
}
