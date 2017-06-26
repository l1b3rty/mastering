package org.glau.tlab.webapp.controllers;

import org.glau.tlab.webapp.model.Item;
import org.glau.tlab.webapp.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class Controller {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/item/{id}")
    @ResponseBody
    public ResponseEntity getItem(@PathVariable("id") Long id) {
        Item item = itemsService.getById(id);

        if (Objects.isNull(item)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item with id " + id + " doesn't exist");
        }

        return ResponseEntity.ok(item);
    }

}
