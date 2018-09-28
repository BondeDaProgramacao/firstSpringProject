/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author camila.dos.s.fraga
 */
public interface UserRepository extends JpaRepository<User, Long>{
   List<User> findByName(String name);   
}
