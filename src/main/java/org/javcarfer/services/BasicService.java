package org.javcarfer.services;


import java.util.List;
import org.javcarfer.domain.DomainObject;
import java.util.stream.Collectors;

public abstract class BasicService<T extends DomainObject> {
    protected List<T> repository;

    public List<T> findAll(){
        return repository;
    }

    protected T findById(int id){
        return repository.stream().filter(p->id==p.getId()).findFirst().get();
    }

    public void create( T object){
        repository.add(object);
    }
    //Update by name (no Id at this moment)
    public void update(T object){
        repository.remove(findById(object.getId()));
        repository.add(object);
    }
    //Deleting by object (no Id at this moment)
    public void delete(int id){
        repository.remove(findById(id));
    }
}
