package com.medeova.service;

import com.medeova.model.*;
import java.util.List;

public interface EstudianteService 
{
    List<Usuario> listar();
    Usuario encontrar(String codigo);
    void eliminar(String codigo);
    Usuario guardar(Usuario nuevo);
    DetalleActividad completarActividad(DetalleActividad nuevo);
    //DetalleActividad getByEstudianteAndActividad(DetalleActividadID id);
    List<DetalleActividad> getActividadesDetalle(String codigo);
    List<DetalleActividad> getActividadesDetalleByUnidad(String codigo, Integer id);
    List<DetalleActividad> getActividadesDetalleByTema(String codigo, Integer id);
    Double getProgreso(String codigo);
    Double getProgresoByUnidad(String codigo, Integer id);
}