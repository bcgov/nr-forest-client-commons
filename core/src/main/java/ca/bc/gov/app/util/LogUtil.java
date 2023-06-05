package ca.bc.gov.app.util;

import java.util.function.Consumer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.event.Level;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LogUtil {
  /**
   * <p><b>Log Content</b></p>
   * Log the content of the future at the specified level.
   *
   * @param <T> The type that will be passed through the future.
   * @return the same content of the future
   */
  public static <T> Consumer<T> logContent(Logger logger, Level logLevel) {
    return message -> logger.atLevel(logLevel).log("{}", message);
  }
}
