package org.javcarfer.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.javcarfer.domain.Paint;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaintControllerTest {

    @Autowired
    MockMvc mock; //Realiza peticiones
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @Order(0)
    void findAllTest() throws Exception {
        mock.perform(get("/paints")).andDo(print());
    }
    @Test
    @Order(1)
    void deleteTest() throws Exception {
        mock.perform(delete("/paint?paint=1")).andDo(print());
    }
    @Test
    @Order(2)
    void createTest() throws Exception {
        Paint paint=new Paint(3,"Tesla Blue","Scale75","SC-52");
        mock.perform(post("/paint")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(paint))
        ).andDo(print());
    }

}
