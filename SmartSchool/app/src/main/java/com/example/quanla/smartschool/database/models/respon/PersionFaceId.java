package com.example.quanla.smartschool.database.models.respon;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC THANG on 3/10/2017.
 */
public class PersionFaceId {

    public String getPersistedfaceid() {
        return persistedfaceid;
    }

    public PersionFaceId(String persistedfaceid) {

        this.persistedfaceid = persistedfaceid;
    }

    @SerializedName("persistedFaceId")
    public String persistedfaceid;
}
