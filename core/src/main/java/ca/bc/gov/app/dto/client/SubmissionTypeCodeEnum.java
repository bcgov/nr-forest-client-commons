package ca.bc.gov.app.dto.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration representing different types of submissions.
 * <p>
 * This enum defines various types of submissions identified by unique codes (e.g., SPP, RNC, AAC).
 * It includes a static block to initialize a map for reverse lookup, allowing retrieval of enum
 * instances by their name. This feature facilitates the conversion from string values to their
 * corresponding enum instances, especially useful in parsing data from external sources or user
 * input.
 * </p>
 */
@Getter
@AllArgsConstructor
public enum SubmissionTypeCodeEnum {
  SPP("Submission pending processing"),
  RNC("Review new client"),
  AAC("Auto approved client"),
  RAC("Review approved client"),
  SSD("Staff submitted data");

  private final String description;
  private static final Map<String, SubmissionTypeCodeEnum>
      CONSTANTS = new HashMap<>();

  static {
    for (SubmissionTypeCodeEnum c : values()) {
      CONSTANTS.put(c.description, c);
    }
  }

  @JsonValue
  public String value() {
    return this.description;
  }

  /**
   * Returns the enum constant with the specified string value.
   *
   * @param value the string value representing the enum constant
   * @return the enum constant with the specified string value
   * @throws IllegalArgumentException if no enum constant with the specified string value exists
   */
  @JsonCreator
  public static SubmissionTypeCodeEnum fromValue(String value) {
    SubmissionTypeCodeEnum constant = CONSTANTS.get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }
}
