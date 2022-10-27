package com.gcoce.cloudapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gcoce.cloudapp.dtos.CreateVueloDto;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "vuelos")
@EntityListeners(AuditingEntityListener.class)
public class Vuelos {
    private UUID idVuelo;
    private String numeroPasaporte;
    private String aeropuertoEntrada;
    private String aeropuertoSalida;
    private Date fechaHoraEntrada;
    private Date fechaHoraSalida;

    public Vuelos() {
    }

    public Vuelos(UUID idVuelo, String numeroPasaporte, String aeropuertoEntrada, String aeropuertoSalida, Date fechaHoraEntrada, Date fechaHoraSalida) {
        this.idVuelo = idVuelo;
        this.numeroPasaporte = numeroPasaporte;
        this.aeropuertoEntrada = aeropuertoEntrada;
        this.aeropuertoSalida = aeropuertoSalida;
        this.fechaHoraEntrada = fechaHoraEntrada;
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Vuelos(CreateVueloDto vueloDto){
        this.numeroPasaporte = vueloDto.getNumeroPasaporte();
        this.aeropuertoEntrada = vueloDto.getAeropuertoEntrada();
        this.aeropuertoSalida = vueloDto.getAeropuertoSalida();
        this.fechaHoraEntrada = vueloDto.getFechaHoraEntrada();
        this.fechaHoraSalida = vueloDto.getFechaHoraSalida();
    }
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id_vuelo", updatable = false)
    public UUID getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(UUID idVuelo) {
        this.idVuelo = idVuelo;
    }

    @Column(name = "numero_pasaporte", nullable = false)
    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    @Column(name = "aeropuerto_entrada", nullable = false)
    public String getAeropuertoEntrada() {
        return aeropuertoEntrada;
    }

    public void setAeropuertoEntrada(String aeropuertoEntrada) {
        this.aeropuertoEntrada = aeropuertoEntrada;
    }

    @Column(name = "aeropuerto_salida", nullable = false)
    public String getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(String aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Guatemala")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_entrada", nullable = false)
    public Date getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(Date fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "America/Guatemala")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_hora_salida", nullable = false)
    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    @Override
    public String toString() {
        return "Vuelos{" +
                "idVuelo=" + idVuelo +
                ", numeroPasaporte='" + numeroPasaporte + '\'' +
                ", aeropuertoEntrada='" + aeropuertoEntrada + '\'' +
                ", aeropuertoSalida='" + aeropuertoSalida + '\'' +
                ", fechaHoraEntrada=" + fechaHoraEntrada +
                ", fechaHoraSalida=" + fechaHoraSalida +
                '}';
    }

}
