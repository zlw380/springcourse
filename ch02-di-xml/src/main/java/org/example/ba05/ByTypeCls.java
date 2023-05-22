package org.example.ba05;

import org.example.dao.ByType;

public class ByTypeCls {

    private Integer age;
    private Integer year;
    private ByType byType;

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setByType(ByType byType) {
        System.out.println("setByType has been executed.");
        this.byType = byType;
    }

    @Override
    public String toString() {
        return "ByTypeCls{" +
                "age=" + age +
                ", year=" + year +
                ", byType=" + byType +
                '}';
    }
}
