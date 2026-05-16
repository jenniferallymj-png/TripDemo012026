package com.sv.tripElSalvadorAppTest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sv.tripElSalvadorAppTest.model.Trip;

public interface ITripRepository extends JpaRepository<Trip, Integer>{
	
	List<Trip> findByEstatus(String estatus);
	
	List<Trip> findByDestacadoAndEstatusOrderByIdDesc(int descatado, String estatus);
	
	List<Trip> findByCostoBetween(double costo1, double costo2);
	
	List<Trip> findByEstatusIn(String[] estatus);
}
