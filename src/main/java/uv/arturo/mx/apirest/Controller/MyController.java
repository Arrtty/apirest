package uv.arturo.mx.apirest.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import uv.arturo.mx.apirest.DTO.DataDTO;
import uv.arturo.mx.apirest.Domain.TheData;
import uv.arturo.mx.apirest.Service.MyService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
public class MyController {
    @Autowired
    private MyService service;

    @GetMapping("/archives")
    public ResponseEntity<List<TheData>> getAll( ) {
        return new ResponseEntity<List<TheData>>(service.getData(), HttpStatus.OK);
    }
    @GetMapping("/{title}")
    public ResponseEntity<Optional<TheData>> getByTitle( @PathVariable String title) {
        return new ResponseEntity<Optional<TheData>>(service.getByTitle(title), HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity insert( @RequestBody TheData data) {
        service.insert(data);
        return new ResponseEntity( HttpStatus.CREATED);
    }
    @PutMapping("/{title}")
    public ResponseEntity putMethodName(@PathVariable int id, @RequestBody TheData data) {
        service.update(id,data);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{title}")
    public ResponseEntity delete(@PathVariable int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
