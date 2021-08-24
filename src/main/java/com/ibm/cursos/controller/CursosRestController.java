package com.ibm.cursos.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ibm.cursos.configs.Mapping;
import com.ibm.cursos.models.Curso;

@RestController
@RequestMapping(Mapping.CURSOS)
public class CursosRestController {
  
  private List<Curso> cursos;
  
  @PostConstruct //Indica la construccion de objetos a la hora de ejecucion de un metodo
  public void init(){
      cursos = new ArrayList<>();
      cursos.add(new Curso("Spring",25,"Vespertino"));
      cursos.add(new Curso("Universidad Java",100,"Vespertino"));
      cursos.add(new Curso("Python",30,"Matutino"));
      cursos.add(new Curso("Brenda Cardenas",30,"Matutino"));
  }
  
  @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Curso>> listarCursos() {
    return new ResponseEntity<>(cursos,HttpStatus.OK);
  }
  
  @GetMapping(value="/listar/{nombre}")
  public ResponseEntity<Curso> buscarCurso(@PathVariable("nombre") String nombre){   
    Curso curso = new Curso();
    for(Curso c : cursos) {
      if(c.getNombre().contains(nombre)) {
        curso = c;
      }
    }
    return new ResponseEntity<>(curso,HttpStatus.OK);
  }
  
  @PostMapping(value ="/crear", produces = MediaType.APPLICATION_JSON_VALUE)
  public String crearCurso(@RequestBody @Valid Curso curso) {
    return "";
  }
  
}
