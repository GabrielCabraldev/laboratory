package br.com.danilomr.timesheet.entrypoints.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class SaveInformationRequestDTO {

    @NotBlank(message = "Name cannot be null or empty")
    private String name;

    @NotNull(message = "HourAmount cannot be null")
    private BigDecimal hourAmount;

}
