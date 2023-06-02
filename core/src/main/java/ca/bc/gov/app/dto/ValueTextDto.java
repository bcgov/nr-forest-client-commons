package ca.bc.gov.app.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    description = "A simple value and text object",
    title = "ValueText",
    example = """
        {
          "value": "00000002",
          "text": "BAXTER"
        }"""
)
public record ValueTextDto(
    @Schema(description = "The value for that specific object", example = "00000002")
    String value,

    @Schema(description = "The textual information for that specific object", example = "BAXTER")
    String text
) {
}
