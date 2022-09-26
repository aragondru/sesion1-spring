package ues.edu.sv.sesion.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,length = 50)
    private Integer id;

    @Column(name = "nombre",nullable = false,length = 30)
    private String nombre;

    @Column(name = "apellido",nullable = false,length = 30)
    private String apellido;

    @Column(name = "email",nullable = false,length = 30)
    private String email;

}
