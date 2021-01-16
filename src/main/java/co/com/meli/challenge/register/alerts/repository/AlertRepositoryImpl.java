package co.com.meli.challenge.register.alerts.repository;

import co.com.meli.challenge.register.alerts.model.domain.Status;
import co.com.meli.challenge.register.alerts.model.dto.AlertServerDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AlertRepositoryImpl implements AlertRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertRepositoryImpl.class);

  private final JdbcTemplate template;

  @Override
  public String create(AlertServerDto alertServerDto) {
    LOGGER.info("Create Process" + alertServerDto.getAlertId());
    String sql =
        "INSERT INTO SERVER_ALERTS (ALERT_ID, "
            + "SERVER_ID, "
            + "DESCRIPTION_ALERT, "
            + "CREATED_AT, "
            + "SERVER_TYPE) "
            + "VALUES (?,?,?,?,?)";

    template.update(
        sql,
        alertServerDto.getAlertId(),
        alertServerDto.getServerName(),
        alertServerDto.getDescriptionAlert(),
        alertServerDto.getCreatedAt(),
        alertServerDto.getServerType());
    return Status.CREATED.name();
  }
}
