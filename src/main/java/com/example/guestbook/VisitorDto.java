package com.example.guestbook;

import lombok.*;

@Data
@NoArgsConstructor
@Getter
@Setter

public class VisitorDto {

    private String name;
    private String comments;

    public VisitorDto(String name, String comments) {
        this.name = name;
        this.comments = comments;
    }

    public String getName() {
        return name;
    }

    public String getComments() {
        return comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
