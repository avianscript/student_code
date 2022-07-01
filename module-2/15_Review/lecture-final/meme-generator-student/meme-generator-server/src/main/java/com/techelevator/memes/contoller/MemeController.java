package com.techelevator.memes.contoller;

import com.techelevator.memes.model.CreateMemeInfo;
import com.techelevator.memes.model.MemeListItem;
import com.techelevator.memes.service.MemeGeneratorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private MemeGeneratorService service;

    public MemeController(MemeGeneratorService memeGeneratorService) {
        this.service = memeGeneratorService;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<MemeListItem> getMemes() {
        return service.getMemeList();
    }

    @PostMapping("")
    public String createMeme(@RequestBody CreateMemeInfo info) {
        return service.createMeme(info);
    }


}
