package com.example.quanla.smartschool.database;

import android.util.Log;

import com.example.quanla.smartschool.eventbus.GetDataFaildedEvent;
import com.example.quanla.smartschool.networks.NetMicrosoftContext;
import com.example.quanla.smartschool.services.PersionService;
import com.example.quanla.smartschool.studentdata.Student;
import com.example.quanla.smartschool.studentdata.StudentRespon;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public class DbStudentContext {
    public static final DbStudentContext instance = new DbStudentContext();
    private final String TAG = DbStudentContext.class.toString();
    private List<Student> students;
    private List<StudentRespon> studentRespon;
    private String idGroup;

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

    private DbStudentContext() {
        this.students = new Vector<>();
        studentRespon=new Vector<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void getAllStudentInGroup() {
        students.clear();
        studentRespon.clear();
        PersionService persionService = NetMicrosoftContext.instance.create(PersionService.class);
        persionService.getAllPersonInGroup(idGroup).enqueue(new Callback<List<StudentRespon>>() {
            @Override
            public void onResponse(Call<List<StudentRespon>> call, Response<List<StudentRespon>> response) {
                studentRespon = response.body();
                for (int i = 0; i < studentRespon.size(); i++) {
                    students.add(new Student(studentRespon.get(i)));
                }
                EventBus.getDefault().postSticky(students);
                Log.e(TAG, "onResponse: Thành");

            }

            @Override
            public void onFailure(Call<List<StudentRespon>> call, Throwable t) {
                EventBus.getDefault().post(new GetDataFaildedEvent());
                ;
            }
        });
    }
}

