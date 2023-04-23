package com.veterinariaXYZ.back.veterinariaXYZ.controller;

import com.veterinariaXYZ.back.veterinariaXYZ.controller.errors.ApplicationCustomException;
import com.veterinariaXYZ.back.veterinariaXYZ.entities.Mascota;
import com.veterinariaXYZ.back.veterinariaXYZ.service.RafDatosMascotaService;
import com.veterinariaXYZ.back.veterinariaXYZ.util.MessagesConstants;
import com.veterinariaXYZ.back.veterinariaXYZ.util.ResponseMessage;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mascota")

public class RafDatosMascotaController
{

    private Logger log = LoggerFactory.getLogger(RafDatosMascotaController.class);

    private static final String ENTITY_NAME = "Mascota";

    private final RafDatosMascotaService rafDatosMascotaService;

    public RafDatosMascotaController(RafDatosMascotaService rafDatosMascotaService){
        this.rafDatosMascotaService = rafDatosMascotaService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/DatosMascota")
    public ResponseEntity<ResponseMessage<Mascota>> createRafDatosMascota(@Valid @RequestBody Mascota mascota) throws ApplicationCustomException {
        log.debug("REST request to save raf_datosmascota : {}", mascota);
        Mascota mascotaFind = rafDatosMascotaService.findOne(mascota.getNmid());
        if(mascotaFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENTITY_NAME));
        }

        Mascota result = rafDatosMascotaService.save(mascota);
        return ResponseEntity.ok( new ResponseMessage<>(0,null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/DatosMascota")
    public ResponseEntity<ResponseMessage<Mascota>> updateRafDatosMascota(@Valid @RequestBody Mascota mascota) throws ApplicationCustomException {
        log.debug("REST request to update raf_datosmascota : {} ", mascota);
        if(mascota.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        Mascota result = rafDatosMascotaService.update(mascota);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/DatosMascota")
    public ResponseEntity<ResponseMessage<List<Mascota>>> getAllRafDatosMascota(){
        log.debug("REST request to get all raf_datosmascota");

        return ResponseEntity.ok( new ResponseMessage<>(0,null, rafDatosMascotaService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/DatosMascota/{nmid}")
    public ResponseEntity<ResponseMessage<Mascota>> getRafDatosMascota(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get mascota : {}", nmid);
        Mascota mascota = rafDatosMascotaService.findOne(nmid);
        if (mascota == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENTITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, mascota));
    }

}