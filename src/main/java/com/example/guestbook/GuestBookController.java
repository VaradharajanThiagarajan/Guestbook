package com.example.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Guestentries")
public class GuestBookController {
    @Autowired
    VisitorService visitorService;

    @GetMapping("/Entries")
    public List<VisitorDto> getVisitorEntries() throws Exception {
        return visitorService.fetchAll();
    }

    @PostMapping("/Entries")
    @ResponseStatus(HttpStatus.CREATED)
    public void addGuestEntry(@RequestBody VisitorDto vistorDto){
        this.visitorService.create(vistorDto);
    }
}
