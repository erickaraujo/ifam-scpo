/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author erick.araujo
 */
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

@Singleton
public class NameBean { 
    private String name;
    @PostConstruct
    private void init() {
        name="Robin Hood";
    }
    public String getName() {
        return name;    
    }    
    public void setName(String name) {
        this.name = name;    
    }}
