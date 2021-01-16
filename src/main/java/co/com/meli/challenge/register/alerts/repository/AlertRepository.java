package co.com.meli.challenge.register.alerts.repository;

import co.com.meli.challenge.register.alerts.model.AlertDto;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface AlertRepository {

  AlertDto findById(String alertId);

  CompletableFuture<String> create(AlertDto alertDto);

  CompletableFuture<String> update(AlertDto alertDto);

  CompletableFuture<String> delete(AlertDto alertDto);
}
