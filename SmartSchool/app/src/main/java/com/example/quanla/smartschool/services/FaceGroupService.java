package com.example.quanla.smartschool.services;

import com.example.quanla.smartschool.classlistdata.ClassStudent;
import com.example.quanla.smartschool.database.models.bodies.AddNewGroupBody;
import com.example.quanla.smartschool.database.models.JSON.GetPersionGroupResponJSON;
import com.example.quanla.smartschool.database.models.JSON.GetPersonGroupTrainingStatusJSON;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public interface FaceGroupService {
    @PUT("{personGroupId}")
    Call<String> addNewGroupFace(@Path("personGroupId") String personGroupId, @Body AddNewGroupBody addNewGroupBody);

    @DELETE("{personGroupId}")
    Call<String> deleteGroupFace(@Path("personGroupId") String personGroupId);

    @GET("{personGroupId}")
    Call<GetPersionGroupResponJSON> getGroupFace(@Path("personGroupId") String personGroupId);

    @GET("{personGroupId}/training")
    Call<GetPersonGroupTrainingStatusJSON> getPersonGroupTrainingStatus(@Path("personGroupId") String personGroupId);

    @POST("{personGroupId}/train")
    Call<Void> trainAI(@Path("personGroupId") String personGroupId);

    @GET
    Call<List<ClassStudent>> getAllGroup(@Url String URL);

}
