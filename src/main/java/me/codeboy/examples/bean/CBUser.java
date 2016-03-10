package me.codeboy.examples.bean;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * user bean
 * Created by YD on 3/9/16.
 */
@Entity
@Table(name = "user")
public class CBUser implements Serializable {
    @Expose
    private long id;
    @Expose
    private String name;

    public CBUser() {
    }

    public CBUser(String name) {
        this.name = name;
    }

    public CBUser(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
