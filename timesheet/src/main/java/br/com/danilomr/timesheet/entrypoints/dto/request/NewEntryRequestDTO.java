package br.com.danilomr.timesheet.entrypoints.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class NewEntryRequestDTO {

    @NotBlank(message = "Entry cannot be null or empty")
    private String entry;
}
