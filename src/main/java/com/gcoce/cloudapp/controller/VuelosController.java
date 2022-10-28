package com.gcoce.cloudapp.controller;

import com.gcoce.cloudapp.dtos.CreateVueloDto;
import com.gcoce.cloudapp.dtos.UpdateVueloDto;
import com.gcoce.cloudapp.model.Vuelos;
import com.gcoce.cloudapp.service.VuelosService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
@Tag(name = "Vuelos API", description = "Operaciones de la API de Vuelos")
public class VuelosController {
    @Autowired
    private VuelosService vuelosService;

    public VuelosController(VuelosService vuelosService){
        this.vuelosService = vuelosService;
    }
    Logger logger = Logger.getLogger(VuelosController.class.getName());
    @GetMapping("/vuelos")
    @Operation(summary = "Retorna todos los vuelos")
    public List<Vuelos> allFlights(){
        //logger.info("Retornando todos los vuelos --> " + vuelosService.allFly());
        return vuelosService.allFly();
    }

    @GetMapping("/vuelos/{idVuelo}")
    @Operation(summary = "Retorna un vuelo por id")
    public Vuelos findByName(@Parameter(description= "Identificador del vuelo")
                                   @PathVariable("idVuelo") UUID idVuelo) {
        //logger.info("Buscando vuelo por id --> " + idVuelo);
        if(vuelosService.findByIdVuelo(idVuelo) == null){
            logger.info("No se encontro vuelo con id --> " + idVuelo);
            return null;
        }
        return vuelosService.findByIdVuelo(idVuelo);
    }

    @PostMapping("vuelos/crear-vuelo")
    @Operation(summary = "Crea un vuelo")
    public Vuelos createFly(@RequestBody CreateVueloDto vuelos){
        Vuelos newVuelo = new Vuelos(vuelos);
        return vuelosService.saveFly(newVuelo);
    }

    @PutMapping("vuelos/actualizar-vuelo")
    @Operation(summary = "Actualiza un vuelo")
    public Vuelos updateFly(@RequestBody UpdateVueloDto vueloDto){
        return vuelosService.updateFly(vueloDto);
    }

    @DeleteMapping("vuelos/eliminar-vuelo/{idVuelo}")
    @Operation(summary = "Elimina un vuelo por id")
    public boolean deleteFly(@Parameter(description= "Identificador del vuelo") @PathVariable("idVuelo") UUID idVuelo){
        return vuelosService.deleteByIdVuelo(idVuelo);
    }
}
