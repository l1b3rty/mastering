package org.glau.tlab.orm.controllers;

import org.glau.tlab.orm.dao.ArticlesDao;
import org.glau.tlab.orm.model.blog.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ControllerTest {

    private static final Logger logger = Logger.getLogger(ControllerTest.class.getName());

    @Autowired
    private ArticlesDao articlesDao;

    @RequestMapping("/article/{id}")
    @ResponseBody
    public ResponseEntity getArticle(@PathVariable("id") Long id) {
        Article article = articlesDao.find(id);
        return ResponseEntity.ok(article);
    }

    /*@ModelAttribute("test")
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



    }*/
}
