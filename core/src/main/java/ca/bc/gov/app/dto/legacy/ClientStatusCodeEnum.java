package ca.bc.gov.app.dto.legacy;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration representing different client status codes.
 * <p>
 * This enum defines various client status codes identified by unique codes (e.g., ACT, DAC, DEC,
 * REC, SPN). It includes a static block to initialize a map for reverse lookup, allowing retrieval
 * of enum instances by their name. This feature facilitates the conversion from string values to
 * their corresponding enum instances, especially useful in parsing data from external sources or
 * user input.
 * </p>
 */
@Getter
@AllArgsConstructor
public enum ClientStatusCodeEnum {
  ACT("Active"), DAC("Deactivated"), DEC("Deceased"), REC("Receivership"), SPN("Suspended");

  private final String description;
  private static final Map<String, ClientStatusCodeEnum> CONSTANTS = new HashMap<>();

  static {
    for (ClientStatusCodeEnum c : values()) {
      CONSTANTS.put(c.description, c);
    }
  }

  public String value() {
    return this.description;
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
   * @return The {@link ClientStatusCodeEnum} instance corresponding to the given string value, or
   * throws an {@link IllegalArgumentException} if no matching instance is found.
   */
  @JsonCreator
  public static ClientStatusCodeEnum fromValue(String value) {
    ClientStatusCodeEnum constant = CONSTANTS.get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }


}
