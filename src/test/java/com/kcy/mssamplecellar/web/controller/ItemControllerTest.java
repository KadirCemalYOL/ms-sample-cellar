package com.kcy.mssamplecellar.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kcy.mssamplecellar.web.model.ItemDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getItemById() throws Exception {
        mockMvc.perform(get("/api/v1/item/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }

    @Test
    void saveNewItem() throws Exception {
        ItemDto itemDTO = ItemDto.builder().build();
        String itemDtoJson = objectMapper.writeValueAsString(itemDTO);

        mockMvc.perform(post("/api/v1/item/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemDtoJson)
        ).andExpect(status().isCreated());
    }

    @Test
    void updateItem() throws Exception {
        ItemDto itemDto = ItemDto.builder().build();
        String itemDtoJson = objectMapper.writeValueAsString(itemDto);

        mockMvc.perform(put("/api/v1/item/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
                .content(itemDtoJson)
        ).andExpect(status().isNoContent());
    }
}