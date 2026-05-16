package com.sv.tripElSalvadorAppTest.service;
import java.util.List;
import java.util.LinkedList; 
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Service;

import com.sv.tripElSalvadorAppTest.model.Trip;

import java.text.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;



@Service
public class TripServiceImpl implements ITripService {
	
	@Autowired
    private ICategoriaService serviceCategoria;
	
	private List<Trip> lista = new LinkedList<Trip>();	

		public TripServiceImpl() {
		}
		
		@PostConstruct
		public void init() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Trip>();
		try {
			Trip trip1 = new Trip();
	        trip1.setId(1);
	        trip1.setNombre("Rapel en Volcatenango");
	        trip1.setDescripcion("Hacer rapel en los circuitos de Volcatenango");
	        trip1.setFecha(sdf.parse("10-05-2022"));
	        trip1.setCosto(5.0);
	        trip1.setDestacado(1);
	        trip1.setImagen("trip1.png");
	        trip1.setEstatus("Creada");
	        trip1.setCategoria(serviceCategoria.buscarPorId(1));

	        Trip trip2 = new Trip();
	        trip2.setId(2);
	        trip2.setNombre("Deslizador en El picnic");
	        trip2.setDescripcion("Deslizarte en un divertido tobogan sobre la colina");
	        trip2.setFecha(sdf.parse("10-05-2022"));
	        trip2.setCosto(5.0);
	        trip2.setDestacado(1);
	        trip2.setImagen("trip2.png");
	        trip2.setEstatus("Creada");
	        trip2.setCategoria(serviceCategoria.buscarPorId(2));

	        Trip trip3 = new Trip();
	        trip3.setId(3);
	        trip3.setNombre("Comida y Flores");
	        trip3.setDescripcion("Disfrutar de un amplio jardín el cual podrás comprar");
	        trip3.setFecha(sdf.parse("10-05-2022"));
	        trip3.setCosto(1.0);
	        trip3.setDestacado(1);
	        trip3.setImagen("trip3.png");
	        trip3.setEstatus("Creada");
	        trip3.setCategoria(serviceCategoria.buscarPorId(3));

	        Trip trip4 = new Trip();
	        trip4.setId(4);
	        trip4.setNombre("Caminatas");
	        trip4.setDescripcion("Disfruta hacer senderismo por las montañas chalatecas");
	        trip4.setFecha(sdf.parse("01-02-2022"));
	        trip4.setCosto(1.0);
	        trip4.setDestacado(0);

	        lista.add(trip1);
	        lista.add(trip2);
	        lista.add(trip3);
	        lista.add(trip4);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Trip> buscarTodos() {
		return lista;
	}

	@Override
	public Trip buscarPorId(Integer idTrip) {
		for (Trip trip : lista)
			if (trip.getId().equals(idTrip))
				return trip;
	
		return null;
	}
	
	@Override
	public void guardar (Trip trip) {
		lista.add(trip);
	}
	
	@Override
	public void eliminar(Integer idTrip) {
	    lista.removeIf(t -> t.getId().equals(idTrip));
	}
	
}