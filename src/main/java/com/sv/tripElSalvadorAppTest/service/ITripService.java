package com.sv.tripElSalvadorAppTest.service;
import java.util.List;

import com.sv.tripElSalvadorAppTest.model.Trip;

public interface ITripService { 
	
    List<Trip> buscarTodos();
    Trip buscarPorId(Integer idTrip);
    
    void guardar (Trip trip);
    
    void eliminar(Integer idTrip);

}
