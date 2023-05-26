package com.veterinariaXYZ.back.veterinariaXYZ.controller;


import com.veterinariaXYZ.back.veterinariaXYZ.controller.errors.ApplicationCustomException;
import com.veterinariaXYZ.back.veterinariaXYZ.entities.Dueno;
import com.veterinariaXYZ.back.veterinariaXYZ.service.RafDatosDuenoService;
import com.veterinariaXYZ.back.veterinariaXYZ.util.MessagesConstants;
import com.veterinariaXYZ.back.veterinariaXYZ.util.ResponseMessage;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/DatosDueno")
public class RafDatosDuenoController {
    private Logger log = LoggerFactory.getLogger(RafDatosDuenoController.class);

    private static final String ENTITY_NAME = "Dueno";

    private final RafDatosDuenoService rafDatosDuenoService;

    public RafDatosDuenoController(RafDatosDuenoService rafDatosDuenoService) {
        this.rafDatosDuenoService = rafDatosDuenoService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<ResponseMessage<Dueno>> createRafDatosDueno(@Valid @RequestBody Dueno dueno) throws ApplicationCustomException {
        log.debug("REST request to save raf_datosdueno : {}", dueno);
        Dueno result = rafDatosDuenoService.save(dueno);
        return ResponseEntity.ok(new ResponseMessage<>(0, null, result));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ()
    public ResponseEntity<ResponseMessage<Dueno>> updateRafDatosDueno(@Valid @RequestBody Dueno dueno) throws ApplicationCustomException {
        log.debug("REST request to update raf_datosdueno : {} ",dueno);
        if(dueno.getNmidentificacion() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Dueno result = rafDatosDuenoService.update(dueno);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ()
    public ResponseEntity<ResponseMessage<List<Dueno>>> getAllRafDatosDueno(){
        log.debug("REST request to get all raf_datosdueno");
        return ResponseEntity.ok( new ResponseMessage<>(0,null, rafDatosDuenoService.findAll()));
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{nmidentificacion}")
    public ResponseEntity<ResponseMessage<Dueno>> getRafDatosDueno(@PathVariable long nmidentificacion) throws ApplicationCustomException {
        log.debug("REST request to get dueno : {}", nmidentificacion);
        Dueno dueno = rafDatosDuenoService.findOne(nmidentificacion);
        if (dueno == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null,dueno));
    }
}
