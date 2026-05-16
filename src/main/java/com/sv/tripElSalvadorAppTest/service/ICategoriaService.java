package com.sv.tripElSalvadorAppTest.service;

import java.util.List;

import com.sv.tripElSalvadorAppTest.model.Categoria;

public interface ICategoriaService {

	List<Categoria> buscarTodos();
	
	Categoria buscarPorId(Integer idCategoria);
	
	void guardar(Categoria categoria);
	
	void eliminar(Integer idCategoria);
}
