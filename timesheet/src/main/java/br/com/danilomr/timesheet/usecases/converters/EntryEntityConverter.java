package br.com.danilomr.timesheet.usecases.converters;

import br.com.danilomr.timesheet.gateways.data.EntryData;
import br.com.danilomr.timesheet.usecases.entity.EntryEntity;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class EntryEntityConverter {

    public static EntryEntity toEntity(final EntryData entryData) {

        Assert.notNull(entryData, "EntryData cannot be null");

        return EntryEntity.builder()
                .id(entryData.getId())
                .entry(entryData.getEntry())
                .build();
    }

    public static List<EntryEntity> toEntityList(final List<EntryData> entryDataList) {

        Assert.notNull(entryDataList, "EntryData cannot be null");

        return entryDataList.stream()
                .map(entryData -> toEntity(entryData))
                .collect(Collectors.toList());
    }
}
