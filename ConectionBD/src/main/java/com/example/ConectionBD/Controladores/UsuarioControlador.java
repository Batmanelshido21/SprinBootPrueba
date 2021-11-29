package com.example.ConectionBD.Controladores;

import java.util.ArrayList;

import com.example.ConectionBD.Modelos.Usuario;
import com.example.ConectionBD.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @PostMapping("/registrarUsuario")
    public Usuario registrarUsuario(@RequestBody Usuario usuario){
        return usuarioServicio.registrarUsuario(usuario);
    }

    @GetMapping("/obtenerUsuarios")
    public ArrayList<Usuario> obteneUsuarios(){
        return usuarioServicio.obtenerUsuarios();
    }

    @DeleteMapping("/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable Long id){
        usuarioServicio.eliminarUsuario(id);
    }

    @PutMapping("/modificarUsuario") 
    public Usuario modifUsuario(@RequestBody Usuario usuario){
        return usuarioServicio.modifiCaUsuario(usuario);
    }
    
}
