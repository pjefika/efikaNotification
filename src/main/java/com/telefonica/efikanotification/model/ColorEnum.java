/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telefonica.efikanotification.model;

/**
 *
 * @author A0077749
 */
public enum ColorEnum {
    
    Blue("Blue"),
    Red("Red"),
    DarkGreen("Dark 'n Green");
    
    private String cor;
    private ColorEnum(String color){
        cor = color;
    }
}
