package lt.ppm.crud.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lt.ppm.crud.exception.RecordNotFoundException;
import lt.ppm.crud.model.ClientEntity;
import lt.ppm.crud.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientService service;

	@RequestMapping("/clients")
	public ResponseEntity<List<ClientEntity>> getAll() {
		List<ClientEntity> list = service.getAll();

		return new ResponseEntity<List<ClientEntity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping("/clients/{id}")
	public ResponseEntity<ClientEntity> getById(@PathVariable("id") Long id) throws RecordNotFoundException {
		ClientEntity entity = service.getById(id);

		return new ResponseEntity<ClientEntity>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST, value="/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientEntity> createOrUpdate(@RequestBody ClientEntity reservation)
			throws RecordNotFoundException {
		ClientEntity updated = service.createOrUpdate(reservation);
		return new ResponseEntity<ClientEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	} 
	
	@RequestMapping(method=RequestMethod.PUT, value="/clients", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(@RequestBody ClientEntity project) throws RecordNotFoundException {
		service.createOrUpdate(project);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/clients/{id}")
	public HttpStatus deleteById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteById(id);
		return HttpStatus.FORBIDDEN;
	}

}