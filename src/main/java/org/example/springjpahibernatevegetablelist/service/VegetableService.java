package org.example.springjpahibernatevegetablelist.service;

import org.example.springjpahibernatevegetablelist.model.Vegetable;
import org.example.springjpahibernatevegetablelist.repository.IVegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetableService implements IVegetableService {
    @Autowired
    private IVegetableRepository iVegetableRepository;
    @Override
    public List<Vegetable> findAll() {
        return iVegetableRepository.findAll();
    }

    @Override
    public void save(Vegetable vegetable) {
        iVegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable findById(Long id) {
        return iVegetableRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        iVegetableRepository.remove(id);
    }
}
