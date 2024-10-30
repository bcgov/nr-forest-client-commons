package ca.bc.gov.app.dto.legacy;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeration representing different types of clients.
 * <p>
 * This enum defines various types of clients identified by single or multiple characters (e.g., C,
 * S, A, I, P, L, RSP, USP). It includes a static block to initialize a map for reverse lookup,
 * allowing retrieval of enum instances by their name.
 * </p>
 */
@Getter
@AllArgsConstructor
public enum ClientTypeCodeEnum {
  A("Association"), B("First Nation Band"), C("Corporation"), F("Ministry of Forests and Range"), G(
      "Government"), I("Individual"), L("Limited Partnership"), P("General Partnership"), R(
      "First Nation Group"), S("Society"), T("First Nation Tribal Council"), U(
      "Unregistered Company");

  private final String description;
  private static final Map<String, ClientTypeCodeEnum> CONSTANTS = new HashMap<>();

  static {
    for (ClientTypeCodeEnum c : values()) {
      CONSTANTS.put(c.description, c);
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
   * @return The {@link ClientTypeCodeEnum} instance corresponding to the given string value, or
   * throws an {@link IllegalArgumentException} if no matching instance is found.
   */
  public static ClientTypeCodeEnum fromValue(String value) {
    ClientTypeCodeEnum constant = CONSTANTS.get(value);
    if (constant == null) {
      throw new IllegalArgumentException(value);
    } else {
      return constant;
    }
  }

}
