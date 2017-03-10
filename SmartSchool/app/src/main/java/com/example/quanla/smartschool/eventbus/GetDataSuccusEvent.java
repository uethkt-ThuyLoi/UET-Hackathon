package com.example.quanla.smartschool.eventbus;

import com.example.quanla.smartschool.classlistdata.ClassStudent;

import java.util.List;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public class GetDataSuccusEvent {
    private List<ClassStudent> classStudents;

    public List<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public GetDataSuccusEvent(List<ClassStudent> classStudents) {
        this.classStudents = classStudents;

    }
}