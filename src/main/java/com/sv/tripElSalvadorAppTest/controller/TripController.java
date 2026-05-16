package com.sv.tripElSalvadorAppTest.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sv.tripElSalvadorAppTest.model.Trip;
import com.sv.tripElSalvadorAppTest.service.ICategoriaService;
import com.sv.tripElSalvadorAppTest.service.db.TripServiceJpa;

@Controller
@RequestMapping("/trips")
public class TripController {
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		
	}
	
	@Autowired
	private TripServiceJpa servicesTrip;
	
	@Autowired
    private ICategoriaService serviceCategoria;
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idTrip, RedirectAttributes attributes) {
	    servicesTrip.eliminar(idTrip);
	    attributes.addFlashAttribute("msg", "El trip fue eliminado correctamente.");
	    return "redirect:/trips/index";
		
	}

	@GetMapping("/view/{id}")
	public String verDetalle(@PathVariable("id") int idTrip, Model model) { 
	    Trip trip = servicesTrip.buscarPorId(idTrip);
	    model.addAttribute("trip", trip);
	    return "detalle";
	}
	
	@GetMapping("/create")
	public String crear(Trip trip, Model model) { 
	    model.addAttribute("categorias", serviceCategoria.buscarTodos());
	    return "trips/formTrip"; 	
	}
	
	@PostMapping("/save")
	public String guardar(Trip trip, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "trips/formTrip";
		}
		System.out.println("Objeto Trip: " + trip);
		servicesTrip.guardar(trip);
		attributes.addFlashAttribute("msg", "Registro Guardado");
	    return "redirect:/trips/index";
	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Trip> lista = servicesTrip.buscarTodos(); 
		model.addAttribute("trips", lista);
	    return "trips/listTrips";
	}

}
