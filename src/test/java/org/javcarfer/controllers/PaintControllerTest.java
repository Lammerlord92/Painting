package org.javcarfer.controllers;

import org.javcarfer.domain.Paint;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import utils.DataFormatUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaintControllerTest {

    @Autowired
    private MockMvc mock; //Realiza peticiones

    @Test
    @Order(0)
    @WithMockUser(username="user1",roles={"USER"})
    public void findAllTest() throws Exception {
        mock.perform(get("/paints")).andDo(print());
    }

    @Test
    @Order(1)
    @WithMockUser(username="user1",roles={"USER"})
    public void createTest() throws Exception {
        Paint paint = new Paint("Tesla Blue", "Scale75", "SC-52");
        mock.perform(post("/paints")

                .contentType(MediaType.APPLICATION_JSON)
                .content(DataFormatUtils.objectToJSON(paint))
        ).andDo(print());
    }

    @Test
    @Order(2)
    @WithMockUser(username="user1",roles={"USER"})
    public void updateTest() throws Exception {
        Paint paint = new Paint( "Tesla Blue", "Scale75", "SC");
        paint.setId(1);
        mock.perform(put("/paints")
                .contentType(MediaType.APPLICATION_JSON)
                .content(DataFormatUtils.objectToJSON(paint))
        ).andDo(print());
    }

    @Test
    @Order(3)
    @WithMockUser(username="user1",roles={"USER"})
    public void deleteTest() throws Exception {
        mock.perform(delete("/paints?paint=21")).andDo(print());
    }


}
