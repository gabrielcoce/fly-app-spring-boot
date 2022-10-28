package com.gcoce.cloudapp.service;

import com.gcoce.cloudapp.controller.VuelosController;
import com.gcoce.cloudapp.dtos.UpdateVueloDto;
import com.gcoce.cloudapp.model.Vuelos;
import com.gcoce.cloudapp.repository.VuelosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class VuelosService {
    Logger logger = Logger.getLogger(VuelosController.class.getName());
    @Autowired
    VuelosRepository vuelosRepository;

    public List<Vuelos> allFly(){
        return vuelosRepository.findAll();
    }

    public Vuelos findByIdVuelo(UUID idVuelo){
        return vuelosRepository.findByIdVuelo(idVuelo);
    }
    public Vuelos saveFly(Vuelos vuelos){
        return vuelosRepository.save(vuelos);
    }

    public Vuelos updateFly(UpdateVueloDto vueloDto){
        Optional<Vuelos> vuelo = vuelosRepository.findById(vueloDto.getIdVuelo());
        //logger.info("vuelo " + vuelo);
        if(vuelo.isEmpty()){
            logger.info("no se encontro el vuelo");
            return null;
        }
        Vuelos newVuelo = vuelo.get();
        newVuelo.setAeropuertoEntrada(vueloDto.getAeropuertoEntrada());
        newVuelo.setAeropuertoSalida(vueloDto.getAeropuertoSalida());
        newVuelo.setFechaHoraEntrada(vueloDto.getFechaHoraEntrada());
        newVuelo.setFechaHoraSalida(vueloDto.getFechaHoraSalida());
        //logger.info("new vuelo " + newVuelo);
        vuelosRepository.save(newVuelo);
        return vuelosRepository.save(newVuelo);
    }
    public boolean deleteByIdVuelo(UUID idVuelo){
        Optional<Vuelos> vuelo = vuelosRepository.findById(idVuelo);
        if(vuelo.isEmpty()){
            logger.info("no se pudo eliminar el vuelo");
            return false;
        }
        vuelosRepository.deleteById(idVuelo);
        return true;
    }
}
