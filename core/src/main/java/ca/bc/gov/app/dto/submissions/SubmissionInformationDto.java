package ca.bc.gov.app.dto.submissions;

import java.time.LocalDate;
import lombok.With;

@With
public record SubmissionInformationDto(
    Integer submissionId,
    String corporationName,
    LocalDate dateOfBirth,
    String registrationNumber,
    String goodStanding,
    String clientType
) {
}
