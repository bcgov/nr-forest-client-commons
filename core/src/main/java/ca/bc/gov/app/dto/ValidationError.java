package ca.bc.gov.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.With;
import org.apache.commons.lang3.StringUtils;

@Schema(
    description = "Represents a validation error during submission",
    title = "ValidationError",
    example = """
        {
          "fieldId": "person.name",
          "errorMsg": "Name is required"
        }"""
)
@With
public record ValidationError(
    @Schema(description = "The field id that failed validation", example = "person.name")
    String fieldId,
    @Schema(description = "The error message for that specific field", example = "Name is required")
    String errorMsg
) {

  @JsonIgnore
  public boolean isValid() {
    return !StringUtils.isAllBlank(fieldId, errorMsg);
  }
}
