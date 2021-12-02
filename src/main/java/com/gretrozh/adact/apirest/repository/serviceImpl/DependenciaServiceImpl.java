package com.gretrozh.adact.apirest.repository.serviceImpl;

import com.gretrozh.adact.apirest.entities.Dependencia;
import com.gretrozh.adact.apirest.exception.DependeciaNotFound;
import com.gretrozh.adact.apirest.repository.dao.IDependenciaDao;
import com.gretrozh.adact.apirest.repository.services.IDependenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DependenciaServiceImpl implements IDependenciaService {

    @Autowired
    private IDependenciaDao dependenciaDao;

    @Override
    public Dependencia save(Dependencia dependencia) {
        return dependenciaDao.save(dependencia);
    }

    @Override
    public void delete(int id) {
        dependenciaDao.deleteById(id);
    }

    @Override
    public List<Dependencia> findAll() {
        return dependenciaDao.findAll();
    }

    @Override
    public Dependencia findById(int id) {
        return dependenciaDao.findById(id).orElse(null);
    }

    @Override
    public Dependencia update(Dependencia dependencia, int id) {
        Dependencia dependenciaEncontrada= dependenciaDao.findById(id).orElse(null);
        if(dependenciaEncontrada==null){
            throw new DependeciaNotFound("Ese id no esta asignado a ninguna dependencia");
        }
        dependenciaEncontrada.setNombre(dependencia.getNombre());
        dependenciaDao.save(dependenciaEncontrada);
        return dependenciaEncontrada;
    }
}
