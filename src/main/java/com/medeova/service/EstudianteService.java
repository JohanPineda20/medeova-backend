package com.medeova.service;

import com.medeova.model.*;
import java.util.List;

public interface EstudianteService 
{
	public List<Usuario> listar();
    public Usuario guardar(Usuario nuevo);
    public Usuario encontrar(String codigo);
    public void eliminar(String codigo);
    public Usuario loginEstudiante(String email, String clave);
    public List<DetalleActividad> getActividadesDetalle(String codigo);
    public List<DetalleActividad> getActividadesDetalleByUnidad(String codigo, Integer id);
    public List<DetalleActividad> getActividadesDetalleByTema(String codigo, Integer id);
    public Double getProgreso(String codigo);
    public Double getProgresoByUnidad(String codigo, Integer id);
}