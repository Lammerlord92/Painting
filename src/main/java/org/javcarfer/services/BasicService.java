package org.javcarfer.services;


import org.javcarfer.domain.DomainObject;

import java.util.List;

public abstract class BasicService<T extends DomainObject> {
    protected List<T> repository;

    public List<T> findAll() {
        return repository;
    }

    protected T findById(int id) {
        return repository.stream().filter(p -> id == p.getId()).findFirst().get();
    }

    public List<T> create(T object) {
        repository.add(object);
        return repository;
    }

    //Update by name (no Id at this moment)
    public List<T> update(T object) {
        repository.remove(findById(object.getId()));
        repository.add(object);
        return repository;
    }

    //Deleting by object (no Id at this moment)
    public List<T> delete(int id) {
        repository.remove(findById(id));
        return repository;
    }
}
