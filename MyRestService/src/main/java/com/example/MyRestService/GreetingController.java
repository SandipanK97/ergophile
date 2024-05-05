/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.MyRestService;
import com.example.MyRestService.model.Greeting;
import com.example.MyRestService.model.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Sandipan Kundu
 */
@RestController
public class GreetingController {

    @PostMapping("/greet")
    public Greeting greet(@RequestBody Person person) {
        String message = "Hello, " + person.getName() + "! You are " + person.getAge() + " years old.";
        
        return new Greeting(message);
    }
}
