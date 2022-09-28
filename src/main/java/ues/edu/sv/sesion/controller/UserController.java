package ues.edu.sv.sesion.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ues.edu.sv.sesion.entities.Usuario;
import ues.edu.sv.sesion.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




//http://localhost:8080/user/all-user
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping(value="/all-user")
    public String getAllUsersView(Model model) {
        model.addAttribute("userList",userService.getAllUser());
        return "index.html";//devolviendo el template html
    }

    @GetMapping(value="/create")
    public String createUserForm(Model model) {
        Usuario usuario = new Usuario();
        model.addAttribute("user",usuario);
        return "create_user";
    }

    @PostMapping(value="/create")
    public String createUser(@ModelAttribute("user") Usuario nuevo) {
        try {
            System.out.println(nuevo.toString());
            userService.saveUser(nuevo);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en el metodo de crear usuario",e);
        }
        return "redirect:/user/all-user";
    }
    
    @GetMapping(value="/update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model) {
        Usuario user = null;
        try {
            user = userService.getById(id);   
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en el metodo de mostror formulario de actualizar usuario",e);
        }
        model.addAttribute("user", user);
        return "update_user";
    }

    @PostMapping(value="/update/{id}")
    public String updateUser(@PathVariable("id")Integer id,@ModelAttribute("user")Usuario usuario) {
        
        try {
            
            usuario.setId(id);
            userService.saveUser(usuario);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en el metodo de actualizar usuario",e);
        }
        return "redirect:/user/all-user";
    }


    @GetMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable("id")Integer id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error en el metodo de eliminar usuario",e);
        }
        return "redirect:/user/all-user";
    }
    
    
    
    
}
