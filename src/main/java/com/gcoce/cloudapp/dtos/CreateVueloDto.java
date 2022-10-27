package com.gcoce.cloudapp.dtos;

import java.util.Date;

public class CreateVueloDto {
    private String numeroPasaporte;
    private String aeropuertoEntrada;
    private String aeropuertoSalida;
    private Date fechaHoraEntrada;
    private Date fechaHoraSalida;

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public void setNumeroPasaporte(String numeroPasaporte) {
        this.numeroPasaporte = numeroPasaporte;
    }

    public String getAeropuertoEntrada() {
        return aeropuertoEntrada;
    }

    public void setAeropuertoEntrada(String aeropuertoEntrada) {
        this.aeropuertoEntrada = aeropuertoEntrada;
    }

    public String getAeropuertoSalida() {
        return aeropuertoSalida;
    }

    public void setAeropuertoSalida(String aeropuertoSalida) {
        this.aeropuertoSalida = aeropuertoSalida;
    }

    public Date getFechaHoraEntrada() {
        return fechaHoraEntrada;
    }

    public void setFechaHoraEntrada(Date fechaHoraEntrada) {
        this.fechaHoraEntrada = fechaHoraEntrada;
    }

    public Date getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(Date fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    @Override
    public String toString() {
        return "CreateVueloDto{" +
                "numeroPasaporte='" + numeroPasaporte + '\'' +
                ", aeropuertoEntrada='" + aeropuertoEntrada + '\'' +
                ", aeropuertoSalida='" + aeropuertoSalida + '\'' +
                ", fechaHoraEntrada=" + fechaHoraEntrada +
                ", fechaHoraSalida=" + fechaHoraSalida +
                '}';
    }
}
