package com.sv.tripElSalvadorAppTest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sv.tripElSalvadorAppTest.model.Categoria;
import com.sv.tripElSalvadorAppTest.service.ICategoriaService;

@Controller
@RequestMapping(value="/categorias")
public class CategoriaTripController {
	
	@Autowired
	private ICategoriaService serviceCategoria;

    //@RequestMapping(value = "/index", method = RequestMethod.GET)
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
	    List<Categoria> lista = serviceCategoria.buscarTodos();
	    model.addAttribute("categorias", lista); 
	    return "categoriasTrip/listCategoria";
	}

	//@RequestMapping(value = "/create", method = RequestMethod.GET)
	@GetMapping("/create")
	public String crear(Model model) {
	    model.addAttribute("categoria", new Categoria());
	    return "categoriasTrip/formCategoria";
	}

  //@RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attibutes) {
        if (result.hasErrors()) {
        	for(ObjectError error: result.getAllErrors()) {
        		System.out.println(error.getDefaultMessage());
        	}
        	return "categoriasTrip/formCategoria";
        }
        
    
    System.out.println("Objeto Categoria: " + categoria);
    serviceCategoria.guardar(categoria);
    attibutes.addFlashAttribute("msg", "Registro Guardado");
    
    return "redirect:/categorias/index";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable("id") int idCategoria, RedirectAttributes attributes) {
        serviceCategoria.eliminar(idCategoria);
        attributes.addFlashAttribute("msg", "Categoría eliminada con éxito");
        return "redirect:/categorias/index";
    }
    
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable("id") int idCategoria, Model model) {
        Categoria categoria = serviceCategoria.buscarPorId(idCategoria);
        model.addAttribute("categoria", categoria);
        return "categoriasTrip/formCategoria";
    }
}
