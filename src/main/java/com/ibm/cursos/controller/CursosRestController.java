package com.ibm.cursos.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ibm.cursos.configs.Mapping;
import com.ibm.cursos.models.Curso;

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
  
}
