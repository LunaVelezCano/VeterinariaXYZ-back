package com.veterinariaXYZ.back.veterinariaXYZ.controller;


import com.veterinariaXYZ.back.veterinariaXYZ.controller.errors.ApplicationCustomException;
import com.veterinariaXYZ.back.veterinariaXYZ.entities.Cita;
import com.veterinariaXYZ.back.veterinariaXYZ.service.RafDatosCitaService;
import com.veterinariaXYZ.back.veterinariaXYZ.util.MessagesConstants;
import com.veterinariaXYZ.back.veterinariaXYZ.util.ResponseMessage;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/DatosCita")
public class RafDatosCitaController {

    private Logger log = LoggerFactory.getLogger(RafDatosCitaController.class);

    private static final String ENTITY_NAME = "Cita";

    private final RafDatosCitaService rafDatosCitaService;

    public RafDatosCitaController(RafDatosCitaService rafDatosCitaService){
        this.rafDatosCitaService = rafDatosCitaService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public ResponseEntity<ResponseMessage<Cita>> createRafDatosCita(@Valid @RequestBody Cita cita) throws ApplicationCustomException {
        log.debug("REST request to save raf_datoscita : {}", cita);
        Cita result = rafDatosCitaService.save(cita);
        return ResponseEntity.ok( new ResponseMessage<>(0,null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping ()
    public ResponseEntity<ResponseMessage<Cita>> updateRafDatosCita(@Valid @RequestBody Cita cita) throws ApplicationCustomException {
        log.debug("REST request to update raf_datoscita : {} ", cita);
        Cita result = rafDatosCitaService.update(cita);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping ()
    public ResponseEntity<ResponseMessage<List<Cita>>> getAllRafDatosCita(){
        log.debug("REST request to get all raf_datoscita");

        return ResponseEntity.ok( new ResponseMessage<>(0,null, rafDatosCitaService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/por-dueno-identificacion/{nmidentificacion_dueno}")
    public ResponseEntity<ResponseMessage<List<Cita>>> getMascotasPorDueno(@PathVariable long nmidentificacion_dueno) throws ApplicationCustomException {
        log.debug("REST request to get cita : {}", nmidentificacion_dueno);
        List<Cita> cita = rafDatosCitaService.findByNmidentificacionDueno(nmidentificacion_dueno);
        if (cita == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage(0, null, cita));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("{nmid}")
    public ResponseEntity<ResponseMessage<Cita>> getRafDatosCita(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get cita : {}", nmid);
        Cita cita = rafDatosCitaService.findOne(nmid);
        if (cita == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, cita));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("delete/{nmid}")
    public ResponseEntity<Cita> deleteRegistro(@PathVariable int nmid) {
        log.debug("Rest request to delete cita : {}", nmid);
        Cita cita = rafDatosCitaService.findOne(nmid);
        if (cita != null) {
            rafDatosCitaService.delete(cita);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}



