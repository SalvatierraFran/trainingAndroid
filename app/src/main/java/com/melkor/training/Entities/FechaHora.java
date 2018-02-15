package com.melkor.training.Entities;

import java.sql.Timestamp;

/**
 * Created by franco.salvatierra on 15/02/2018.
 */

public class FechaHora {

    private String fechaHora;

    public FechaHora(){}

    public FechaHora(String FechaHora, String Id)
    {
        this.fechaHora = FechaHora;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
}
