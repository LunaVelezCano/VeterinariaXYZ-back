package com.veterinariaXYZ.back.veterinariaXYZ.controller;

import com.veterinariaXYZ.back.veterinariaXYZ.controller.errors.ApplicationCustomException;
import com.veterinariaXYZ.back.veterinariaXYZ.dto.RafDatosMascota;
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
@RequestMapping("/api")

public class RafDatosMascotaController
{

    private Logger log = LoggerFactory.getLogger(RafDatosMascotaController.class);

    private static final String ENITY_NAME = "RafDatosMascota";

    private final RafDatosMascotaService rafDatosMascotaService;

    public RafDatosMascotaController(RafDatosMascotaService rafDatosMascotaService){
        this.rafDatosMascotaService = rafDatosMascotaService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/DatosMascota")
    public ResponseEntity<ResponseMessage<RafDatosMascota>> createRafDatosMascota(@Valid @RequestBody RafDatosMascota rafDatosMascota) throws ApplicationCustomException {
        log.debug("REST request to save raf_datosmascota : {}", rafDatosMascota);
        RafDatosMascota rafDatosMascotaFind = rafDatosMascotaService.findOne(rafDatosMascota.getNmid());
        if(rafDatosMascotaFind != null){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_ALREADY_EXISTS, ENITY_NAME));
        }

        RafDatosMascota result = rafDatosMascotaService.save(rafDatosMascota);
        return ResponseEntity.ok( new ResponseMessage<>(0,null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/DatosMascota")
    public ResponseEntity<ResponseMessage<RafDatosMascota>> updateRafDatosMascota(@Valid @RequestBody RafDatosMascota rafDatosMascota) throws ApplicationCustomException {
        log.debug("REST request to update raf_datosmascota : {} ", rafDatosMascota);
        if(rafDatosMascota.getNmid() == 0){
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE,String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        RafDatosMascota result = rafDatosMascotaService.update(rafDatosMascota);
        return ResponseEntity.ok( new ResponseMessage<>(0, null, result));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/DatosMascota")
    public ResponseEntity<ResponseMessage<List<RafDatosMascota>>> getAllRafDatosMascota(){
        log.debug("REST request to get all raf_datosmascota");

        return ResponseEntity.ok( new ResponseMessage<>(0,null, rafDatosMascotaService.findAll()));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/DatosMascota/{nmid}")
    public ResponseEntity<ResponseMessage<RafDatosMascota>> getRafDatosMascota(@PathVariable int nmid) throws ApplicationCustomException {
        log.debug("REST request to get rafDatosMascota : {}", nmid);
        RafDatosMascota rafDatosMascota = rafDatosMascotaService.findOne(nmid);
        if (rafDatosMascota == null) {
            throw new ApplicationCustomException(MessagesConstants.ENTITY_ALREADY_EXISTS_CODE, String.format(MessagesConstants.ENTITY_NOT_EXISTS, ENITY_NAME));
        }
        return ResponseEntity.ok(new ResponseMessage<>(0, null, rafDatosMascota));
    }

}
