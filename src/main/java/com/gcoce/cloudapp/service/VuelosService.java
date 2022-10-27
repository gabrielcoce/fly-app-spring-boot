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
    public boolean saveFly(Vuelos vuelos){
        vuelosRepository.save(vuelos);
        return true;
    }

    public boolean updateFly(UpdateVueloDto vueloDto){
        Optional<Vuelos> vuelo = vuelosRepository.findById(vueloDto.getIdVuelo());
        if(vuelo == null){
            logger.info("no se encontro el vuelo");
            return false;
        }
        Vuelos newVuelo = vuelo.get();
        newVuelo.setAeropuertoEntrada(vueloDto.getAeropuertoEntrada());
        newVuelo.setAeropuertoSalida(vueloDto.getAeropuertoSalida());
        newVuelo.setFechaHoraEntrada(vueloDto.getFechaHoraEntrada());
        newVuelo.setFechaHoraSalida(vueloDto.getFechaHoraSalida());
        logger.info("new vuelo " + newVuelo);
        vuelosRepository.save(newVuelo);
        return true;
    }
    public boolean deleteByIdVuelo(UUID idVuelo){
        vuelosRepository.deleteById(idVuelo);
        return true;
    }
}
