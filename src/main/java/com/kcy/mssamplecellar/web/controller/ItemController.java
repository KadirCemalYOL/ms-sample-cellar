package com.kcy.mssamplecellar.web.controller;

import com.kcy.mssamplecellar.web.model.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/item")
@RestController
public class ItemController {

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("itemId") UUID itemId) {
        return new ResponseEntity<>(ItemDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ItemDto> saveNewItem(@RequestBody ItemDto itemDTO) {
        //TODO Implement
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable UUID itemId, @RequestBody ItemDto itemDTO) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
