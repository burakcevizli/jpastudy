package com.burakexample.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.*;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@AllArgsConstructor
@SuperBuilder
@NamedQuery(name = "Author.findByNamedQuery", query = "select a from Author a where a.age >= :age")
public class Author extends BaseEntity{

    private String firstName;

    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private Integer age;

    @ManyToMany(mappedBy = "authors")
    private List<Course> courses;

}
