package com.example.guestbook;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GuestBookController {


    @GetMapping("/entries")
    public List<VisitorDto> getVisitorEntries(){
        return visitorService.fetchAll();

    }
}
