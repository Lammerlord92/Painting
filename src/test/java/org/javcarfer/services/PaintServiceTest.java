package org.javcarfer.services;

import org.javcarfer.domain.Paint;
import org.junit.Assert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PaintServiceTest {
    @Autowired
    private PaintService service;

    @Test
    @Order(0)
    public void createTest() throws Exception {
        Paint paint = new Paint("Tesla Blue", "Scale75", "SC-52");
        service.create(paint);
        checkObjects();
        Assert.assertFalse(service.findAll().size()<0);
    }

    @Test
    @Order(1)
    public void updateTest() throws Exception {
        Paint orPaint=service.findAll().get(service.findAll().size()-1);
        Paint paint = new Paint( "Tesla Blue", "Scale75", "SC");
        paint.setId(orPaint.getId());
        service.update(paint);
        checkObjects();
        Paint newPaint=service.findById(orPaint.getId());
        Assert.assertNotEquals(orPaint,newPaint);
    }

    @Test
    @Order(2)
    public void findAllTest() throws Exception {
        checkObjects();
        Assert.assertNotNull(service.findAll());
    }

    @Test
    @Order(3)
    public void deleteTest() throws Exception {
        int orSize=service.findAll().size();
        checkObjects();
        System.out.println("Starting delete");
        service.delete(service.findAll().get(service.findAll().size()-1).getId());
        checkObjects();
        Assert.assertFalse(orSize<service.findAll().size());
    }

    private void checkObjects(){
        List<Paint> paints=service.findAll();
        paints.forEach(x->System.out.println(x.getId()+", "+x.getName()+", "+x.getBrand()+", "+x.getCode()));
    }
}
