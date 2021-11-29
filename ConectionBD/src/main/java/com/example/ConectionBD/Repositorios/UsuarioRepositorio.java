package com.example.ConectionBD.Repositorios;

import com.example.ConectionBD.Modelos.Usuario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario,Long>{
    
}
