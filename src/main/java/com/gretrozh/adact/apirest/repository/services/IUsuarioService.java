package com.gretrozh.adact.apirest.repository.services;

import com.gretrozh.adact.apirest.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    Usuario save(Usuario usuario);
    Usuario findByEmail(String email);
    List<Usuario> findAll();
}
