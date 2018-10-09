/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author camila.dos.s.fraga
 */
public interface UserRepository extends MongoRepository<User, ObjectId>{
   List<User> findByName(String name);   
}
