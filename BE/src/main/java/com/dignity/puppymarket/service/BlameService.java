package com.dignity.puppymarket.service;

import com.dignity.puppymarket.domain.Blame;
import com.dignity.puppymarket.dto.Blame.BlameRequestDto;
import com.dignity.puppymarket.repository.BlameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlameService {
    private final BlameRepository blameRepository;

    public BlameService(BlameRepository blameRepository){
        this.blameRepository = blameRepository;
    }

    public Blame saveBlame(BlameRequestDto form){
        Blame blame = form.toEntity();
        return blameRepository.save(blame);
    }

    public List<Blame> viewBlame(){
        return blameRepository.findAll();
    }

    public void deleteBlame(Long id){
        blameRepository.deleteById(id);
    }
}
