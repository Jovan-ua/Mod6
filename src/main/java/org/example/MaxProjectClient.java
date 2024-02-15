package org.example;

import lombok.Data;
@Data

public class MaxProjectClient {
    private int id;
    private String name;
    private int projectCount;
    MaxProjectClient(String name, int projectCount){

    }
}
