package dev.rvz.escola.shared.domain.events;

import java.time.LocalDateTime;
import java.util.Map;

public interface Event {
    LocalDateTime moment();

    TypeEvent type();

    Map<String, Object> getInfo();
}
