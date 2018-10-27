/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.bson.types.ObjectId;

/**
 *
 * @author camila.dos.s.fraga
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    private ObjectId _id;

    private String name;

    @JsonIgnore
    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
