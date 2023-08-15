package ca.bc.gov.app.dto.legacy;

import ca.bc.gov.app.dto.client.ClientStatusCodeEnum;
import ca.bc.gov.app.dto.client.ClientTypeCodeEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

@Schema(
    description = "Represents a client from the legacy forest database.",
    title = "ForestClient",
    example = """
        {
          "clientNumber": "00000002",
          "clientName": "BAXTER",
          "legalFirstName": "",
          "legalMiddleName": "",
          "clientStatusCode": "ACT",
          "clientTypeCode": "I",
          "clientIdTypeCode": "C",
          "clientIdentification": "00000002",
          "registryCompanyTypeCode": "BC",
          "corpRegnNmbr": "00000002",
          "clientAcronym": "",
          "wcbFirmNumber": "",
          "ocgSupplierNmbr": "",
          "clientComment": ""
        }"""
)
public record ForestClientDto(
    @Schema(
        description = "The client number.",
        example = "00000002"
    )
    String clientNumber,
    @Schema(description = """
        The client last name if it's an individual or
         the company name if it's a company""",
        example = "BAXTER"
    )
    String clientName,
    @Schema(description = """
        The first name of the individual,
         or null if it's a company""",
        example = "JAMES")
    String legalFirstName,
    @Schema(description = """
        The middle name of the individual,
         or null if it's a company""",
        example = "Canter")
    String legalMiddleName,
    @Schema(description = """
        The status of the client, can be any of the following:<br>
                
        ACT (Active)<br>
        DAC (Deactivated)<br>
        DEC (Deceased)<br>
        REC (Receivership)<br>
        SPN (Suspended)""",
        example = "ACT")
    String clientStatusCode,
    @Schema(description = """
        The type of client, can be any of the following:<br>
                
        A (Association)<br>
        B (First Nation Band)<br>
        C (Corporation)<br>
        F (Ministry of Forests and Range)<br>
        G (Government)<br>
        I (Individual)<br>
        L (Limited Partnership)<br>
        P (General Partnership)<br>
        R (First Nation Group)<br>
        S (Society)<br>
        T (First Nation Tribal Council)<br>
        U (Unregistered Company)""",
        example = "I")
    String clientTypeCode,

    @Schema(description = """
        The type of client, can be any of the following:<br>
                
        A (Association)<br>
        B (First Nation Band)<br>
        C (Corporation)<br>
        F (Ministry of Forests and Range)<br>
        G (Government)<br>
        I (Individual)<br>
        L (Limited Partnership)<br>
        P (General Partnership)<br>
        R (First Nation Group)<br>
        S (Society)<br>
        T (First Nation Tribal Council)<br>
        U (Unregistered Company)""",
        example = "C")
    String clientIdTypeCode,
    @Schema(description = "An ID to identify companies",example = "Wull.")
    String clientIdentification,
    @Schema(description = """
        The type of company, such as:<br>
                
        BC (BC Registered Business)<br>
        FM (Sole Proprietorship)""",
        example = "FM")
    String registryCompanyTypeCode,
    @Schema(description = "Company registration number",
        example = "00000002")
    String corpRegnNmbr,
    @Schema(description = "An acronyms for this client",
        example = "JAMES BAXTER")
    String clientAcronym,
    @Schema(description = "WCB firm number",
        example = "00000002")
    String wcbFirmNumber,
    @Schema(description = "OCG supplier number",
        example = "00000002")
    String ocgSupplierNmbr,
    @Schema(description = "A comment for this client",
        example = "This is a comment")
    String clientComment
) {

  /**
   * Returns the legal name of the client already formatted
   * @return A string with the legal name
   */
  public String legalName() {
    if (StringUtils.defaultString(clientTypeCode).equalsIgnoreCase("I")) {
      return
          Stream.of(
                  StringUtils.defaultString(legalFirstName),
                  StringUtils.defaultString(legalMiddleName),
                  StringUtils.defaultString(clientName)
              )
              .filter(StringUtils::isNotBlank)
              .collect(Collectors.joining(" "));
    }
    return StringUtils.defaultString(clientName);
  }

  /**
   * Returns a map with the client information
   * @return A map with the client information
   */
  public Map<String, Object> description() {
    return
        Map.of(
            "number", clientNumber,
            "name", legalName(),
            "status", ClientStatusCodeEnum.valueOf(clientStatusCode),
            "type", ClientTypeCodeEnum.valueOf(clientTypeCode),
            "identifier",
            StringUtils.defaultString(registryCompanyTypeCode) +
            StringUtils.defaultString(corpRegnNmbr)
        );
  }
}