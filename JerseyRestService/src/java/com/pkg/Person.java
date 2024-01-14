/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pkg;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@JsonDeserialize
public class Person {
    private String name;

    // Default constructor (required for JAXB)
    public Person() {
    }

    // Constructor
    public Person(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/* Sample data for test - 
<person>
<name>John</name>
</person>

{
  "person": {
    "name": "John Doe"
  }
}

*/