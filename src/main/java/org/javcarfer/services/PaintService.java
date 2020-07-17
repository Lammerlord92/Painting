package org.javcarfer.services;

import org.javcarfer.domain.Paint;
import org.javcarfer.repositories.PaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaintService {
    @Autowired
    PaintRepository repository;


    public List<Paint> findAll() {
        return repository.findAll();
    }

    protected Paint findById(int id) {
        return repository.findById(id).get();
    }

    public List<Paint> create(Paint object) {
        repository.save(object);
        return findAll();
    }

    //Update by name (no Id at this moment)
    public List<Paint> update(Paint object) {
        repository.save(object);
        return findAll();
    }

    //Deleting by object (no Id at this moment)
    public List<Paint> delete(int id) {
        repository.deleteById(id);
        return findAll();
    }

    public List<Paint> findAll(String filter) {
        return findAll()
                .stream()
                .filter(paint -> paint.getName().contains(filter) || paint.getBrand().contains(filter))
                .collect(Collectors.toList());
    }

}
