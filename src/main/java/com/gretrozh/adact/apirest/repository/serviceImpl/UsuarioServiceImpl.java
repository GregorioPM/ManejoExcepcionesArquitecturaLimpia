package com.gretrozh.adact.apirest.repository.serviceImpl;

import com.gretrozh.adact.apirest.entities.Usuario;
import com.gretrozh.adact.apirest.repository.dao.IUsuarioDao;
import com.gretrozh.adact.apirest.repository.services.IUsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public class UsuarioServiceImpl implements IUsuarioService {

    Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

    @Autowired
    private IUsuarioDao userDao;

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        // TODO Auto-generated method stub
        return userDao.save(usuario);
    }

    @Override
    public Usuario findByEmail(String email) {
        try {
            return userDao.findByEmail(email);
        } catch (Exception e) {
            logger.error("Busqueda usuario por email", e);
        }
        return null;
    }

    @Override
    public List<Usuario> findAll() {
        try {
            return (List<Usuario>) userDao.findAll();
        } catch (Exception e) {
            logger.error("Listar usuarios", e);
        }
        return new ArrayList<>();
    }
}
