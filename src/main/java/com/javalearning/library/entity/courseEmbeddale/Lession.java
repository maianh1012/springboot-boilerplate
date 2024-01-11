package com.javalearning.library.entity.courseEmbeddale;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Lession {
    private String title;

    @Embedded
    private Video video;
}
