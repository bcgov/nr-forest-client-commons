package ca.bc.gov.app.dto.client;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.HashMap;
import java.util.Map;

/**
 * Enumeration representing different steps in the staff submission process.
 * <p>
 * This enum defines various steps in the staff submission process, including sub-variations for
 * step 1 (individual, registered, others, and First Nations). It includes a static block
 * initializing a map for reverse lookup, allowing retrieval of enum instances by their name.
 * </p>
 */
public enum StepMatchEnum {
  STEP1INDIVIDUAL, STEP1REGISTERED, STEP1OTHERS, STEP1FIRSTNATION, STEP2, STEP3;

  // A map for reverse lookup of enum constants by their name
  private static final Map<String, StepMatchEnum> CONSTANTS = new HashMap<>();

  static {
    // Populates the CONSTANTS map with enum names and their corresponding enum instances
    for (StepMatchEnum c : values()) {
      CONSTANTS.put(c.name(), c);
    }
  }

  /**
   * Returns the enum constant of this type with the specified name.
   *
   * @param value the name of the enum constant to be returned.
   * @return the enum constant with the specified name, or null if no constant with the specified
   * name exists.
   */
  @JsonCreator
  public static StepMatchEnum fromValue(String value) {
    return CONSTANTS.get(value);
  }
}
