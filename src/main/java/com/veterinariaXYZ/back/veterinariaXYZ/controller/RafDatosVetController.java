package com.veterinariaXYZ.back.veterinariaXYZ.controller;


import com.veterinariaXYZ.back.veterinariaXYZ.controller.errors.ApplicationCustomException;
import com.veterinariaXYZ.back.veterinariaXYZ.entities.Veterinario;
import com.veterinariaXYZ.back.veterinariaXYZ.service.RafDatosVetService;
import com.veterinariaXYZ.back.veterinariaXYZ.util.MessagesConstants;
import com.veterinariaXYZ.back.veterinariaXYZ.util.ResponseMessage;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/DatosVet")
public class RafDatosVetController {

    private Logger log = LoggerFactory.getLogger(RafDatosVetController.class);

    private static final String ENTITY_NAME = "Veterinario";

    private final RafDatosVetService rafDatosVetService;

    public RafDatosVetController(RafDatosVetService rafDatosVetService) {
        this.rafDatosVetService = rafDatosVetService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<ResponseMessage<Veterinario>> createRafDatosVet(@Valid @RequestBody Veterinario veterinario) throws ApplicationCustomException {
        log.debug("REST request to save raf_datosveterinario : {}", veterinario);
        Veterinario result = rafDatosVetService.save(veterinario);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ()
    public ResponseEntity<ResponseMessage<Veterinario>> updateRafDatosVet(@Valid @RequestBody Veterinario veterinario) throws ApplicationCustomException {
        log.debug("REST request to update raf_datosveterinario : {} ",veterinario);
        if(veterinario.getNmidenti_vet() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Veterinario result = rafDatosVetService.update(veterinario);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ()
    public ResponseEntity<ResponseMessage<List<Veterinario>>> getAllRafDatosVet(){
        log.debug("REST request to get all raf_datosveterinario");
        return ResponseEntity.ok( new ResponseMessage<>(0,null, rafDatosVetService.findAll()));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{nmidentiVet}")
    public ResponseEntity<ResponseMessage<Veterinario>> getRafDatosVet(@PathVariable long nmidenti_vet) throws ApplicationCustomException {
        log.debug("REST request to get veterinario : {}", nmidenti_vet);
        Veterinario veterinario = rafDatosVetService.findOne(nmidenti_vet);
        if (veterinario == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null,veterinario));
    }
}
