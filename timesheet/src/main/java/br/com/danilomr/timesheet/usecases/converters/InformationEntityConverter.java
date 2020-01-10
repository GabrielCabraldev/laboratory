package br.com.danilomr.timesheet.usecases.converters;

import br.com.danilomr.timesheet.entrypoints.dto.request.SaveInformationRequestDTO;
import br.com.danilomr.timesheet.gateways.data.InformationData;
import br.com.danilomr.timesheet.usecases.entity.InformationEntity;
import org.springframework.util.Assert;

public class InformationEntityConverter {

    public static InformationEntity toEntity(final InformationData informationData) {

        Assert.notNull(informationData, "InformationData cannot be null");

        return InformationEntity.builder()
                .id(informationData.getId())
                .name(informationData.getName())
                .hourAmount(informationData.getHourAmount())
                .build();
    }

    public static InformationEntity toEntity(final SaveInformationRequestDTO requestDTO) {

        Assert.notNull(requestDTO, "SaveInformationRequestDTO cannot be null");

        return InformationEntity.builder()
                .name(requestDTO.getName())
                .hourAmount(requestDTO.getHourAmount())
                .build();
    }
}
