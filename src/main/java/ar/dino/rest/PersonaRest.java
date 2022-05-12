package ar.dino.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.dino.dao.PersonaDAO;
import ar.dino.model.Persona;

@RestController
@RequestMapping("/persona")
public class PersonaRest {

	 @Autowired
     private PersonaDAO  personaDAO;
	 
	 //Metodos HTTP solicitados al servidor
	 
	 //GET --> Status 200 (significa que la peticion se realizo correctamente)
	 
	 
	 @PostMapping("/guardar")
	 public void guardar(@RequestBody Persona personaguardar){
		 
		 personaDAO.save(personaguardar);
		 
	 }	 
	 
	 @GetMapping("/mostrar")  //listado de un servicio, personas que lista
     public List<Persona> listar(){
         return personaDAO.findAll();
     }
	 
	 
	 @PutMapping("/modificar") //modificacion de datos, si encuentra un id ya con ese numero lo toma como actualizacion es una masa esto
     public void modificar(@RequestBody Persona per){
		 personaDAO.save(per);
     }
	 
	 
	 @DeleteMapping (value= "/eliminar/{id}") //eliminacion de datos que viene de la URL
     public void eliminar(@PathVariable("id") Integer id){
		 personaDAO.deleteById(id);
     }
	
	}

