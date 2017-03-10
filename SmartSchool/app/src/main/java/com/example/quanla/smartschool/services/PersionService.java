package com.example.quanla.smartschool.services;

import com.example.quanla.smartschool.database.models.request.UrlImage;
import com.example.quanla.smartschool.database.models.respon.PersionFaceId;
import com.example.quanla.smartschool.database.models.respon.PersionId;
import com.example.quanla.smartschool.studentdata.Student;
import com.example.quanla.smartschool.studentdata.StudentRespon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public interface PersionService {
    @POST("{personGroupId}/persons")
    Call<PersionId> createPersion(@Path("personGroupId") String personGroupId, Student student);

    @POST("{personGroupId}/persons/{personId}/persistedFaces")
    Call<PersionFaceId> addPersionFace(@Path("personGroupId") String personGroupId, @Path("personId") String personId, @Body UrlImage url);

    @GET("{personGroupId}/persons")
    Call<List<StudentRespon>> getAllPersonInGroup(@Path("personGroupId") String personGroupId);


}
