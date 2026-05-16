package com.sv.tripElSalvadorAppTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sv.tripElSalvadorAppTest.model.Categoria;

public interface ICategoriasRepository extends JpaRepository<Categoria, Integer> {

}