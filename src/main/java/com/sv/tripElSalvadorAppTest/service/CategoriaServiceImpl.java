package com.sv.tripElSalvadorAppTest.service;


import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sv.tripElSalvadorAppTest.model.Categoria;


@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	List<Categoria> lista = null;
	
	public CategoriaServiceImpl() {
		
		lista = new LinkedList<Categoria>();
		
		Categoria categoria1 = new Categoria();
		categoria1.setId(1);
		categoria1.setNombre("En la Playa");
		categoria1.setDescripcion("Servicios de entretenimiento de playa");
		
		Categoria categoria2 = new Categoria();
		categoria2.setId(2);
		categoria2.setNombre("En la Ciudad");
		categoria2.setDescripcion("Clasificacion de trips en la ciudad");
		
		Categoria categoria3 = new Categoria();
		categoria3.setId(3);
		categoria3.setNombre("En la Montaña");
		categoria3.setDescripcion("Interesantes actividades en montañas");
		
		lista.add(categoria1);
		lista.add(categoria2);
		lista.add(categoria3);
	}
	
	@Override
	public List<Categoria> buscarTodos() {
		return lista;
	}
	@Override
	public Categoria buscarPorId(Integer idCategoria) {
		for(Categoria categoria : lista)
			if(categoria.getId()==idCategoria)
				return categoria;
		
		return null;
	}
	@Override
	public void guardar(Categoria categoria) {
		lista.add(categoria);
	}
	
	@Override
	public void eliminar(Integer idCategoria) {
	    lista.removeIf(c -> c.getId().equals(idCategoria));
	}
}
