package org.example.ba05;

public class SchoolSon extends School{
    private String name;
    private String address;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SchoolSon{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
