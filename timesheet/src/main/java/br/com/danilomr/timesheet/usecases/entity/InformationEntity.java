package br.com.danilomr.timesheet.usecases.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class InformationEntity {

    private Long id;
    private String name;
    private BigDecimal hourAmount;
    private LocalDate startDate;
    private LocalDate endDate;
}
