package com.medeova.service;

import org.springframework.transaction.annotation.Transactional;

import com.medeova.model.DetalleActividad;

import java.util.List;

public interface DetalleActividadService 
{
    @Transactional
    public DetalleActividad guardar(DetalleActividad nuevo);

    @Transactional(readOnly = true)
    public List<DetalleActividad> getDetalleByEstudiante(String codigo);

    @Transactional(readOnly = true)
    public List<DetalleActividad> getAll();
}