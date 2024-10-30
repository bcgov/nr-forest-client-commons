package ca.bc.gov.app.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Comparator;
import java.util.List;
import lombok.With;

/**
 * Data Transfer Object (DTO) representing a business in the BC Registry.
 */
@With
@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryBusinessDto(
    List<BcRegistryAlternateNameDto> alternateNames, // List of alternate names for the business
    Boolean goodStanding,
    // Indicates if the business is in good standing
    Boolean hasCorrections,                          // Indicates if the business has corrections
    Boolean hasCourtOrders,                          // Indicates if the business has court orders
    Boolean hasRestrictions,                         // Indicates if the business has restrictions
    String identifier,                               // The identifier of the business
    String legalName,                                // The legal name of the business
    String legalType,                                // The legal type of the business
    String state                                     // The state of the business
) {

  /**
   * Resolves and returns the legal name of the business. If alternate names are available, it
   * returns the first registered alternate name. Otherwise, it returns the legal name.
   *
   * @return the resolved legal name of the business
   */
  public String getResolvedLegalName() {

    List<BcRegistryAlternateNameDto> names =
        (alternateNames == null || alternateNames.isEmpty())
            ? List.of()
            : alternateNames;

    return
        names
            .stream()
            .sorted(Comparator.comparing(BcRegistryAlternateNameDto::registeredDate))
            .map(BcRegistryAlternateNameDto::name)
            .findFirst()
            .orElse(legalName);
  }

}