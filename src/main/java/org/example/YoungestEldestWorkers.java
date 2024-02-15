package org.example;

import lombok.Data;

import java.util.Date;

@Data
public class YoungestEldestWorkers {
    private String type;
    private String name;
    private Date birthday;

    public YoungestEldestWorkers(String type, String name, Date birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }
}
