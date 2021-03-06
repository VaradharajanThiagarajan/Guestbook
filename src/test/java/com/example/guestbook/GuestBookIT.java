package com.example.guestbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class GuestBookIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DirtiesContext
    public void getAllGuestBookEntries() throws Exception{

        mockMvc.perform(get("/Guestentries/Entries")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0));
    }
    @Test
    @DirtiesContext
    public void addGuestBookEntries() throws Exception{

        VisitorDto visitor1 = new VisitorDto("Varadha","The Museum of fine arts is really good");
        mockMvc.perform(post("/Guestentries/Entries")
                .content(objectMapper.writeValueAsString(visitor1))
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated())
                .andDo(document("AddGuestEntries"));


        mockMvc.perform(get("/Guestentries/Entries")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("Varadha"))
                .andExpect(jsonPath("[0].comments").value("The Museum of fine arts is really good"))
                .andDo(document("GetEntries", responseFields(
                        fieldWithPath("[0].name").description("name of the Guest"),
                        fieldWithPath("[0].comments").description("Comments of guest")
                )));



    }
}
