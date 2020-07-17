package org.javcarfer.services;


import org.javcarfer.domain.DomainObject;
import org.javcarfer.domain.Paint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class BasicService<T extends DomainObject> {
    protected JpaRepository<T,Integer> repository;

    public List<T> findAll() {
        return repository.findAll();
    }

    protected T findById(int id) {
        return repository.findById(id).get();
    }

    public List<T> create(T object) {
        repository.save(object);
        return findAll();
    }

    //Update by name (no Id at this moment)
    public List<T> update(T object) {
        repository.save(object);
        return findAll();
    }

    //Deleting by object (no Id at this moment)
    public List<T> delete(int id) {
        repository.deleteById(id);
        return findAll();
    }
}
