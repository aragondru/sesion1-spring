package ues.edu.sv.sesion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ues.edu.sv.sesion.entities.Usuario;
import ues.edu.sv.sesion.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Usuario> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Usuario getById(Integer userId) {
        return userRepository.findById(userId).get();
    }

    @Override
    public void saveUser(Usuario user) {
        userRepository.save(user); 
    }
    
}
