package com.example.guestbook;


import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VisitorService {

    private final GuestBookRepository guestRepository;

    public VisitorService(GuestBookRepository guestRepository) {
        this.guestRepository = guestRepository;
    }
    public List<VisitorDto> fetchAll() {
        return guestRepository.findAll()
                .stream()
                .map(visitorEntity -> {
                    return new VisitorDto(visitorEntity.getName(),
                            visitorEntity.getComments());
                })
                .collect(Collectors.toList());
    }


    public void create(VisitorDto visitorDto) {
        guestRepository.save(
                new VisitorEntity(visitorDto.getName(),
                        visitorDto.getComments()
                ));
    }

}
