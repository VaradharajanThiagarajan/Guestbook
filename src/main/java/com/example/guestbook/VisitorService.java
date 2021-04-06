package com.example.guestbook;


import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
}
