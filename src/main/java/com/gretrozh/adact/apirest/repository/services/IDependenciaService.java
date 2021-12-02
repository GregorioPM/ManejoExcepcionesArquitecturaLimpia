package com.gretrozh.adact.apirest.repository.services;

import com.gretrozh.adact.apirest.entities.Dependencia;

import java.util.List;

public interface IDependenciaService {
    Dependencia save(Dependencia dependencia);
    void delete(int id);
    List<Dependencia> findAll();
    Dependencia findById(int id);
    Dependencia update(Dependencia dependencia, int id);
}
