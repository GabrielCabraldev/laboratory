package br.com.danilomr.timesheet.entrypoints;

import br.com.danilomr.timesheet.entrypoints.dto.request.SaveInformationRequestDTO;
import br.com.danilomr.timesheet.usecases.SaveInformationUseCase;
import br.com.danilomr.timesheet.usecases.converters.InformationEntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/info")
@Validated
public class InformationController {

    @Autowired
    private SaveInformationUseCase saveInformationUseCase;

    @PostMapping(path = "/save")
    public ResponseEntity<HttpStatus> saveInformation(@RequestBody @Valid SaveInformationRequestDTO request) {

        saveInformationUseCase.execute(InformationEntityConverter.toEntity(request));

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
