package ca.bc.gov.app.dto.submissions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Enum representing the kind of submission process.
 */
public enum SubmissionProcessKindEnum {
  HOT,
  COLD;

  private static final Map<String, SubmissionProcessKindEnum> CONSTANTS = new HashMap<>();

  static {
    for (SubmissionProcessKindEnum c : values()) {
      CONSTANTS.put(c.name(), c);
    }
  }

  /**
   * Returns the SubmissionProcessKindEnum corresponding to the given value.
   * If the value is not found, it defaults to COLD.
   *
   * @param value the value to look up
   * @return the corresponding SubmissionProcessKindEnum, or COLD if not found
   */
  public static SubmissionProcessKindEnum fromValue(String value) {
    SubmissionProcessKindEnum constant = CONSTANTS.get(value);
    return Objects.requireNonNullElse(constant, COLD);
  }
}