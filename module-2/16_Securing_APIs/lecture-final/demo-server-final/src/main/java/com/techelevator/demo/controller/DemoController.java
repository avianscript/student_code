package com.techelevator.demo.controller;

import com.techelevator.demo.dao.CatCardDao;
import com.techelevator.demo.model.CatCard;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private CatCardDao catCardDao;

    public DemoController(CatCardDao catCardDao) {
        this.catCardDao = catCardDao;
    }

    @GetMapping("/sayhello")
    public String sayHello(@RequestParam String name) {
        return "Hello " + name + "!";
    }

    @GetMapping("/cards")
    public List<CatCard> getCard() {
        return catCardDao.list();
    }

}
