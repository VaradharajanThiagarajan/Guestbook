package com.example.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
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
}
