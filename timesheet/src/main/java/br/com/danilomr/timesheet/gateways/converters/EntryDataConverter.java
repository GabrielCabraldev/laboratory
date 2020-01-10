package br.com.danilomr.timesheet.gateways.converters;

import br.com.danilomr.timesheet.gateways.data.EntryData;
import br.com.danilomr.timesheet.usecases.entity.EntryEntity;
import org.springframework.util.Assert;

public class EntryDataConverter {

    public static EntryData toData(final EntryEntity entryEntity) {

        Assert.notNull(entryEntity, "EntryEntity cannot be null");

        return EntryData.builder()
                .id(entryEntity.getId())
                .entry(entryEntity.getEntry())
                .build();
    }
}
