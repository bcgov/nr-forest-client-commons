package ca.bc.gov.app.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Objects;
import lombok.With;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Data Transfer Object (DTO) representing an address in the BC Registry.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@With
public record BcRegistryAddressDto(
    String addressCity,
    String addressCountry,
    String addressRegion,
    String deliveryInstructions,
    String postalCode,
    String streetAddress,
    String streetAddressAdditional,
    String addressType
) {

  /**
   * Checks if this object is equal to another object.
   *
   * @param o the object to compare with
   * @return true if the objects are equal, false otherwise
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    BcRegistryAddressDto that = (BcRegistryAddressDto) o;

    return new EqualsBuilder()
        .append(addressCity, that.addressCity)
        .append(addressCountry, that.addressCountry)
        .append(addressRegion, that.addressRegion)
        .append(postalCode, that.postalCode)
        .append(streetAddress, that.streetAddress)
        .isEquals();
  }

  /**
   * Generates a hash code for this object.
   *
   * @return the hash code
   */
  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(addressCity)
        .append(addressCountry)
        .append(addressRegion)
        .append(postalCode)
        .append(streetAddress)
        .toHashCode();
  }

  /**
   * Validates the address.
   *
   * @return true if the street address and postal code are not null, false otherwise
   */
  public boolean isValid() {
    return !Objects.isNull(streetAddress) && !Objects.isNull(postalCode);
  }
}