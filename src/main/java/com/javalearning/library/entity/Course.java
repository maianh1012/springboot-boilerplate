package com.javalearning.library.entity;

import com.javalearning.library.entity.courseEmbeddale.Session;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Course {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_generator"
    )
    @SequenceGenerator(
            name = "course_generator",
            sequenceName = "course_sequence_name",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String status;
    private Long price;

    private Integer categoryId;
    private Long boughtNumber;
    private Long teacherId;
    private Double rank;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime lastUpdated;

    @ElementCollection
    @CollectionTable(name = "course_sessions", joinColumns = @JoinColumn(name = "course_id"))
    private List<Session> sessions = new ArrayList<>();


}
