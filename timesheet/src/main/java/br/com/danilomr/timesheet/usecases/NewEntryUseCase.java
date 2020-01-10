package br.com.danilomr.timesheet.usecases;

import br.com.danilomr.timesheet.gateways.EntryRepository;
import br.com.danilomr.timesheet.gateways.converters.EntryDataConverter;
import br.com.danilomr.timesheet.usecases.entity.EntryEntity;
import br.com.danilomr.timesheet.utils.CustomDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewEntryUseCase {

    @Autowired
    private EntryRepository entryRepository;

    public void execute(final String stringDateTime) {
        entryRepository.save(EntryDataConverter.toData(buildEntryEntity(stringDateTime)));
    }

    private EntryEntity buildEntryEntity(final String stringDateTime) {

        return EntryEntity.builder()
                .entry(CustomDateUtils.stringToDateTime(stringDateTime))
                .build();
    }
}
