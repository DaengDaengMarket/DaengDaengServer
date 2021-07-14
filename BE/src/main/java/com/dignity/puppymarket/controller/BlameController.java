package com.dignity.puppymarket.controller;

import com.dignity.puppymarket.domain.Blame;
import com.dignity.puppymarket.dto.Blame.BlameRequestDto;
import com.dignity.puppymarket.service.BlameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blame")
public class BlameController {

    @Autowired
    private BlameService blameService;

    @GetMapping("")
    public List<Blame> viewBlame(){
        return blameService.viewBlame();
    }

    @PostMapping("/item/{itemId}")
    @ResponseStatus(HttpStatus.CREATED)
    public Blame createBlame(@PathVariable Long itemId, @RequestBody BlameRequestDto form){
        return blameService.saveBlame(itemId ,form);
    }

    @DeleteMapping("/{id}")
    public void deleteBlame(@PathVariable Long id){
        blameService.deleteBlame(id);
    }
}
