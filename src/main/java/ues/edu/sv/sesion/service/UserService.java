package ues.edu.sv.sesion.service;

import java.util.List;

import ues.edu.sv.sesion.entities.Usuario;

public interface UserService {
    
    public List<Usuario> getAllUser();

    public Usuario getById(Integer userId);

    public void saveUser(Usuario user);

    public void deleteUser(Integer id);
}
