package com.faina.utils.sort.external;


/**
 * assume that all fields are known
 */
public class MyRecord {

    private String name;
    private String age;
    private String work;

    public MyRecord(String name, String age, String work)   {
        this.name = name;
        this.age = age;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getWork() {
        return work;
    }

}
