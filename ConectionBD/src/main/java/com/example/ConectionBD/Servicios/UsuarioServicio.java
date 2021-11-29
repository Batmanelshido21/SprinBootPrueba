package com.example.ConectionBD.Servicios;

import java.util.ArrayList;

import com.example.ConectionBD.Modelos.Usuario;
import com.example.ConectionBD.Repositorios.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public ArrayList<Usuario> obtenerUsuarios(){
        return (ArrayList<Usuario>) usuarioRepositorio.findAll();
    }

    @Transactional
    public void eliminarUsuario(Long id){
        usuarioRepositorio.deleteById(id);
    }

    @Transactional
    public Usuario registrarUsuario(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    @Transactional
    public Usuario modifiCaUsuario(Usuario usuario){
        usuarioRepositorio.deleteById(usuario.getId());
        return usuarioRepositorio.save(usuario);
    }

    
}
