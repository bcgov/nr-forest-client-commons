package ca.bc.gov.app.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Set;

/**
 * Data Transfer Object (DTO) representing business addresses in the BC Registry.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryBusinessAdressesDto(
    BcRegistryAddressDto mailingAddress,  // The mailing address of the business
    BcRegistryAddressDto deliveryAddress  // The delivery address of the business
) {

  /**
   * Validates the business addresses.
   *
   * @return true if either the mailing address or the delivery address is not null, false otherwise
   */
  public boolean isValid() {
    return mailingAddress != null || deliveryAddress != null;
  }

  /**
   * Retrieves a set of business addresses with their types.
   *
   * @return a set of business addresses with their types
   */
  public Set<BcRegistryAddressDto> addresses() {
    Set<BcRegistryAddressDto> addressDtoSet = new HashSet<>();
    if (mailingAddress != null) {
      addressDtoSet.add(mailingAddress.withAddressType("mailing"));
    }
    if (deliveryAddress != null) {
      addressDtoSet.add(deliveryAddress.withAddressType("delivery"));
    }
    return addressDtoSet;
  }
}