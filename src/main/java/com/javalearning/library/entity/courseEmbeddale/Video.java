package com.javalearning.library.entity.courseEmbeddale;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Video {
    private String url;
    private String description;
}