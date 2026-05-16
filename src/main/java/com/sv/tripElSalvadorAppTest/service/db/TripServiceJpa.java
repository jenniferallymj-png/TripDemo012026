package com.sv.tripElSalvadorAppTest.service.db;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sv.tripElSalvadorAppTest.model.Trip;
import com.sv.tripElSalvadorAppTest.repository.ITripRepository;
import com.sv.tripElSalvadorAppTest.service.ITripService;

@Primary
@Service
public class TripServiceJpa implements ITripService {
	
	@Autowired
	private ITripRepository tripRepository;
	
	@Override
	public List<Trip> buscarTodos() {
		
		return tripRepository.findAll();
	}
	
	@Override
	public Trip buscarPorId(Integer idTrip) {
		Optional<Trip>optional 
		= tripRepository.findById(idTrip);
		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	@Override
	public void guardar(Trip trip) {
		tripRepository.save(trip);
		
	}
	
	@Override
	public void eliminar(Integer idTrip) {
	    tripRepository.deleteById(idTrip);
	}

}
