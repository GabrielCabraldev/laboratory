package br.com.danilomr.timesheet.usecases;

import br.com.danilomr.timesheet.gateways.EntryRepository;
import br.com.danilomr.timesheet.gateways.data.EntryData;
import br.com.danilomr.timesheet.usecases.converters.EntryEntityConverter;
import br.com.danilomr.timesheet.usecases.entity.EntryEntity;
import br.com.danilomr.timesheet.utils.CustomDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetEntryUseCase {

    @Autowired
    private EntryRepository entryRepository;

    public List<EntryEntity> execute(final String stringDateFrom, final String stringDateTo) {

        LocalDate dateFrom = CustomDateUtils.stringToDate(stringDateFrom);
        LocalDate dateTo = CustomDateUtils.stringToDate(stringDateTo);

        Optional<List<EntryData>> entryDataList = entryRepository.findByEntry(dateFrom.atStartOfDay(), dateTo.atTime(LocalTime.MAX));

        if(entryDataList.isPresent()) {
            return EntryEntityConverter.toEntityList(entryDataList.get());
        }

        return new ArrayList<>();
    }
}
