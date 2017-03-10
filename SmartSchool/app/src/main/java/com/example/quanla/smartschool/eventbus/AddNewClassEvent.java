package com.example.quanla.smartschool.eventbus;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public class AddNewClassEvent {
    private String msg;

    public AddNewClassEvent(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}

