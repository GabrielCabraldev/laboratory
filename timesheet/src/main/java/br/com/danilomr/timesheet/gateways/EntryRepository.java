package br.com.danilomr.timesheet.gateways;

import br.com.danilomr.timesheet.gateways.data.EntryData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EntryRepository extends CrudRepository<EntryData, Long> {

    @Query("select e from EntryData e where e.entry between :dateFrom and :dateTo order by e.entry")
    Optional<List<EntryData>> findByEntry(final LocalDateTime dateFrom, final LocalDateTime dateTo);
}
