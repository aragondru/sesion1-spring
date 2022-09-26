package ues.edu.sv.sesion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ues.edu.sv.sesion.entities.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>{
    
}
