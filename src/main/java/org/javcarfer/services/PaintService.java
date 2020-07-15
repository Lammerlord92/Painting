package org.javcarfer.services;

import org.javcarfer.domain.Paint;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaintService extends BasicService<Paint> {

    @PostConstruct //After constructor
    public void init() {
        repository = new ArrayList<>();
        repository.add(new Paint(0, "Iroko", "Scale75", "SC-27"));
        repository.add(new Paint(1, "Athonian camoshade", "Citadel", ""));
        repository.add(new Paint(2, "Gory red", "Vallejo", ""));
    }

    public List<Paint> findAll(String filter) {
        return findAll()
                .stream()
                .filter(paint -> paint.getName().contains(filter) || paint.getBranch().contains(filter))
                .collect(Collectors.toList());
    }

}
