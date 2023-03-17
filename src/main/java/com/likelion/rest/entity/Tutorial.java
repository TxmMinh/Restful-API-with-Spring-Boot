package com.likelion.rest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tutorials")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="published")
    private boolean published;

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=[" + title + ", desc=" + description + ", published=" + published + "]";
    }

}
