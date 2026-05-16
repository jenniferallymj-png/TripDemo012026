package com.sv.tripElSalvadorAppTest.service.db;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.sv.tripElSalvadorAppTest.model.Categoria;
import com.sv.tripElSalvadorAppTest.repository.ICategoriasRepository; 
import com.sv.tripElSalvadorAppTest.service.ICategoriaService;

@Service
@Primary
public class CategoriasServicesJpa implements ICategoriaService {

    @Autowired
    private ICategoriasRepository categoriaRepo; 
    
    @Override
    public List<Categoria> buscarTodos() {
        return categoriaRepo.findAll(); 
    }
    
    @Override
    public Categoria buscarPorId(Integer idCategoria) {
        Optional<Categoria> optional = categoriaRepo.findById(idCategoria);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null; 
    }
    
    @Override
    public void guardar(Categoria categoria) { 
    	categoriaRepo.save(categoria); 
    }
    
    @Override
    public void eliminar(Integer idCategoria) {
        categoriaRepo.deleteById(idCategoria);
    }

}
