package com.ibm.cursos.models;

public class Curso {

  public String nombre;
  public int duracion;
  public String turno;

  public Curso() {}

  public Curso(String nombre, int duracion, String turno) {
    this.nombre = nombre;
    this.duracion = duracion;
    this.turno = turno;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getDuracion() {
    return duracion;
  }

  public void setDuracion(int duracion) {
    this.duracion = duracion;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }



}
