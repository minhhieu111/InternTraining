package org.example.equalAndHashcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("hieu",21,"hieu@gmail.com");
        Person person2 = new Person("hieu",21,"hieu@gmail.com");
        boolean check = person1.equals(person2);
        System.out.println(check);



        System.out.println("Hashcode person1: "+person1.hashCode());
        System.out.println("Hashcode person2: "+person2.hashCode());

        HashMap<String, String> quanpho = new HashMap<String, String>();
        quanpho.put("tai","25");
        quanpho.put("chin","30");
        quanpho.put("tai chin","35");
        quanpho.put("nam","40");

        for(String pho : quanpho.keySet()){
            System.out.println(pho + " = "+quanpho.get(pho));
        }

    }
}