package br.com.danilomr.timesheet.entrypoints;

import br.com.danilomr.timesheet.entrypoints.converters.EntryResponseDTOConverter;
import br.com.danilomr.timesheet.entrypoints.dto.request.NewEntryRequestDTO;
import br.com.danilomr.timesheet.entrypoints.dto.response.EntryResponseDTO;
import br.com.danilomr.timesheet.usecases.GetEntryUseCase;
import br.com.danilomr.timesheet.usecases.NewEntryUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/entry")
@Validated
public class EntryController {

    @Autowired
    private NewEntryUseCase newEntryUseCase;

    @Autowired
    private GetEntryUseCase getEntryUseCase;

    @PostMapping(path = "/new")
    public ResponseEntity<HttpStatus> newEntry(@RequestBody @Valid final NewEntryRequestDTO request) {

        newEntryUseCase.execute(request.getEntry());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<EntryResponseDTO>> getActualEntry(@RequestParam("dateFrom") final String dateFrom,
                                                                 @RequestParam("dateTo") final String dateTo) {

        return ResponseEntity.ok(EntryResponseDTOConverter.toDTOList(getEntryUseCase.execute(dateFrom, dateTo)));
    }
}
