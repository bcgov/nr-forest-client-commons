package ca.bc.gov.app.dto.client;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Enumeration representing the source of validation.
 * <p>
 * This enum defines the sources of validation, such as external (EXTERNAL) and staff (STAFF). It
 * includes a static block to initialize a map for reverse lookup, allowing retrieval of enum
 * instances by their name.
 * </p>
 */
public enum ValidationSourceEnum {
  EXTERNAL, STAFF;

  private static final java.util.Map<String, ValidationSourceEnum> CONSTANTS = new java.util.HashMap<>();

  static {
    for (ValidationSourceEnum c : values()) {
      CONSTANTS.put(c.name(), c);
    }
  }

  /**
   * Retrieves the enum instance corresponding to the given string value.
   * <p>
   * This method allows for reverse lookup of enum instances by their name, facilitating the
   * conversion from strings to enum instances. It supports dynamic retrieval of enum instances in
   * scenarios where the enum type is determined at runtime.
   * </p>
   *
   * @param value The string representation of the enum constant to be retrieved.
   * @return The {@link ValidationSourceEnum} instance corresponding to the given string value, or
   * null if no matching instance is found.
   */
  @JsonCreator
  public static ValidationSourceEnum fromValue(String value) {
    return CONSTANTS.get(value);
  }
}
