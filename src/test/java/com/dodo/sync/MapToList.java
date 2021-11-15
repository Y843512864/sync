package com.dodo.sync;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Map<String,Person> ma = new HashMap<>();
        ma.put("a", new Person("dodo","1"));
        ma.put("b", new Person("asd","2"));
        ma.put("c", new Person("doddddo","3"));
        
        System.out.println(ma.entrySet().stream().map(e->(Person)e.getValue()).collect(Collectors.toList()));
    }

    public static class Person {
        private String name;
        private String sex;
        
        
        public Person(String name, String sex) {
            super();
            this.name = name;
            this.sex = sex;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSex() {
            return sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
        @Override
        public String toString() {
            return "Person [name=" + name + ", sex=" + sex + "]";
        }
        
        
        
    }

}
