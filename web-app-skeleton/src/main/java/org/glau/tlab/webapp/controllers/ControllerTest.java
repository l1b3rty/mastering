package org.glau.tlab.webapp.controllers;

import org.glau.tlab.webapp.model.Item;
import org.glau.tlab.webapp.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ControllerTest {

    private static final Logger logger = Logger.getLogger(ControllerTest.class.getName());

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/item/{id}")
    @ResponseBody
    @PreAuthorize("hasAnyRole('ROLE_USER,ROLE_ADMIN')")
    public ResponseEntity getItem(@PathVariable("id") Long id) {
        Item item = itemsService.getById(id);

        if (Objects.isNull(item)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("item with id " + id + " doesn't exist");
        }

        return ResponseEntity.ok(item);
    }

    @ModelAttribute("test")
    public TestModelAttribute addAttribute(@RequestParam("id") Integer id) {
        logger.log(Level.INFO, "ID: " + id);
        return new TestModelAttribute();
    }

    @RequestMapping("/test")
    public String getTest() throws SQLException {

        throw new IllegalArgumentException("asdasd");

    }


    @ExceptionHandler({IllegalArgumentException.class})
    public String jsonConversionError() {
        return "error";
    }

    public static class TestModelAttribute {



    }
}
