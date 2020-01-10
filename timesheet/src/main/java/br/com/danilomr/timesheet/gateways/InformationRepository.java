package br.com.danilomr.timesheet.gateways;

import br.com.danilomr.timesheet.gateways.data.InformationData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformationRepository extends CrudRepository<InformationData, Long> {

    List<InformationData> findAll();
}
