package co.com.meli.challenge.register.alerts.repository;

import co.com.meli.challenge.register.alerts.model.AlertDto;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AlertRepositoryImpl implements AlertRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertRepositoryImpl.class);

  private final JdbcTemplate template;

  @Override
  public AlertDto findById(String alertId) {
    try {
      String sql = "SELECT * FROM SERVER_ALERTS WHERE ALERT_ID = ?";
      LOGGER.info("SQL: {}", sql);
      return template.queryForObject(
          sql,
          new Object[] {alertId},
          (rs, rowNum) ->
              new AlertDto(
                  rs.getString("ALERT_ID"),
                  rs.getString("SERVER_NAME"),
                  rs.getString("DESCRIPTION_ALERT"),
                  rs.getString("CREATED_AT"),
                  rs.getString("SERVER_TYPE")));

    } catch (EmptyResultDataAccessException e) {
      LOGGER.info("Error AlertRepositoryImpl findById: {}", e);
      throw null;
    }
  }

  @Override
  public CompletableFuture<String> create(AlertDto alertDto) {
    return null;
  }

  @Override
  public CompletableFuture<String> update(AlertDto alertDto) {
    return null;
  }

  @Override
  public CompletableFuture<String> delete(AlertDto alertDto) {
    return null;
  }
}
