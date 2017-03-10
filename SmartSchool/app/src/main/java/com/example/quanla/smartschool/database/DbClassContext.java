package com.example.quanla.smartschool.database;

import android.util.Log;

import com.example.quanla.smartschool.classlistdata.ClassStudent;
import com.example.quanla.smartschool.eventbus.GetDataFaildedEvent;
import com.example.quanla.smartschool.eventbus.GetDataSuccusEvent;
import com.example.quanla.smartschool.networks.NetMicrosoftContext;
import com.example.quanla.smartschool.services.FaceGroupService;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Vector;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public class DbClassContext {
    private static final String TAG = DbClassContext.class.toString();
    private List<ClassStudent> classStudents;
    private final String urlGetList = "https://westus.api.cognitive.microsoft.com/face/v1.0/persongroups?start=0";
    public static final DbClassContext instance = new DbClassContext();


    private DbClassContext() {
        this.classStudents = new Vector<>();
    }

    public List<ClassStudent> getClassStudents() {
        return classStudents;
    }

    public void setClassStudents(List<ClassStudent> classStudents) {
        this.classStudents = classStudents;
    }

    int count = 0;


    public void getAllGroup() {
        FaceGroupService faceGroupService = NetMicrosoftContext.instance.create(FaceGroupService.class);
        faceGroupService.getAllGroup(urlGetList).enqueue(new Callback<List<ClassStudent>>() {
            @Override
            public void onResponse(Call<List<ClassStudent>> call, Response<List<ClassStudent>> response) {
                classStudents = response.body();

                Log.e(TAG, "onResponse: load hết group");
                EventBus.getDefault().post(new GetDataSuccusEvent(classStudents));
            }

            @Override
            public void onFailure(Call<List<ClassStudent>> call, Throwable t) {
                Log.e(TAG, String.format("onFailure: %s", t.toString()));

                EventBus.getDefault().post(new GetDataFaildedEvent());
            }
        });
    }
}
