package com.javalearning.library.entity.courseEmbeddale;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Embeddable
public class Session {
    private String title;

    @ElementCollection
    @CollectionTable(name = "session_lessons", joinColumns = @JoinColumn(name = "session_id"))
    private List<Lession> lessons = new ArrayList<>();
}
