package com.example.demo.entities;

import javax.persistence.*;


// Since every entity has same field Id of type Long
// We can use Inheritance
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
