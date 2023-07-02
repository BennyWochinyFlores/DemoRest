package pe.company.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.company.model.Conyuge;
import pe.company.service.ConyugeService;




@RestController
@RequestMapping("/conyuge")
public class ConyugeRestController 
{
	@Autowired
	private ConyugeService conyugeService;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar() {
		Collection<Conyuge> itemsConyuge=conyugeService.findAll();
		return new ResponseEntity<>(itemsConyuge,HttpStatus.OK);
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Conyuge conyuge) {
		conyugeService.insert(conyuge);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}



