package ca.bc.gov.app.dto.bcregistry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import lombok.With;

/**
 * Data Transfer Object (DTO) representing an alternate name in the BC Registry.
 */
@With
@JsonIgnoreProperties(ignoreUnknown = true)
public record BcRegistryAlternateNameDto(
    String entityType,       // The type of entity
    String identifier,       // The identifier of the entity
    String name,             // The alternate name of the entity
    ZonedDateTime registeredDate, // The date when the name was registered
    LocalDate startDate      // The start date of the alternate name
) {

}