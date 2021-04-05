package com.example.guestbook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class GuestBookIT {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getAllGuestBookEntries() throws Exception{

        mockMvc.perform(get("/entries")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(0));
    }


//    @Test
//    public void addGuestBookEntries() throws Exception{
//
//        MovieDto movie1 = new MovieDto("The Avengers");
//        mockMvc.perform(post("/movies")
//                .content(objectMapper.writeValueAsString(movie1))
//                .contentType(MediaType.APPLICATION_JSON)
//        ).andExpect(status().isCreated());
//
//        mockMvc.perform(get("/movies")
//        ).andExpect(status().isOk())
//                .andExpect(jsonPath("length()").value(1))
//                .andExpect(jsonPath("[0].title").value("The Avengers"));
//
//
//    }
}
