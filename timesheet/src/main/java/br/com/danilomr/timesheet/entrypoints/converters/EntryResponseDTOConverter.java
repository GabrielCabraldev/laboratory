package br.com.danilomr.timesheet.entrypoints.converters;

import br.com.danilomr.timesheet.entrypoints.dto.response.EntryResponseDTO;
import br.com.danilomr.timesheet.usecases.entity.EntryEntity;
import br.com.danilomr.timesheet.utils.CustomDateUtils;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class EntryResponseDTOConverter {

    public static EntryResponseDTO toDTO(final EntryEntity entryEntity) {

        Assert.notNull(entryEntity, "EntryEntity cannot be null");

        return EntryResponseDTO.builder()
                .entry(CustomDateUtils.dateTimeToString(entryEntity.getEntry()))
                .build();
    }

    public static List<EntryResponseDTO> toDTOList(final List<EntryEntity> entryEntityList) {

        Assert.notNull(entryEntityList, "EntryEntityList cannot be null");

        return entryEntityList.stream().map(entryEntity -> toDTO(entryEntity)).collect(Collectors.toList());
    }
}
