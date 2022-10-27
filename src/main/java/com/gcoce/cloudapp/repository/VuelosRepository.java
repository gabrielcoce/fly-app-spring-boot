package com.gcoce.cloudapp.repository;

import com.gcoce.cloudapp.model.Vuelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface VuelosRepository  extends JpaRepository<Vuelos, UUID> {
    Vuelos findByIdVuelo(@Param(value = "idVuelo") UUID idVuelo);
}
