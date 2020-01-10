package br.com.danilomr.timesheet.usecases;

import br.com.danilomr.timesheet.gateways.InformationRepository;
import br.com.danilomr.timesheet.gateways.data.InformationData;
import br.com.danilomr.timesheet.usecases.entity.InformationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaveInformationUseCase {

    @Autowired
    private InformationRepository informationRepository;

    public void execute (final InformationEntity informationEntity) {

        Optional<InformationData> informationDataOptional = informationRepository.findAll().stream().findFirst();

        if(informationDataOptional.isPresent()) {
            InformationData informationData = informationDataOptional.get().toBuilder()
                    .name(informationEntity.getName())
                    .hourAmount(informationEntity.getHourAmount())
                    .build();

            informationRepository.save(informationData);
        } else {
            InformationData informationData = InformationData.builder()
                    .name(informationEntity.getName())
                    .hourAmount(informationEntity.getHourAmount())
                    .build();

            informationRepository.save(informationData);
        }
    }
}
