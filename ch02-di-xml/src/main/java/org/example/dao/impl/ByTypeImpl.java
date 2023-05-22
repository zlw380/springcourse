package org.example.dao.impl;

import org.example.dao.ByType;

public class ByTypeImpl implements ByType {

    private String name;
    private String address;

    @Override
    public void print(){
        System.out.println(this.getName());
        System.out.println("testByType");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ByTypeImpl{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
