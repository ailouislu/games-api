package com.nzlouis.platform.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Louis
 */
@Entity
@Data
public class Platform {
    @Id
    private int id;
    private String name;
    private String slug;

    public Platform() {
    }

    public Platform(int id, String name, String slug) {
        super();
        this.id = id;
        this.name = name;
        this.slug = slug;
    }
}
