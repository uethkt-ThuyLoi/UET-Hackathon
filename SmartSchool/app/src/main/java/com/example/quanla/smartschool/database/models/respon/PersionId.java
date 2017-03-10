package com.example.quanla.smartschool.database.models.respon;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DUC THANG on 3/10/2017.
 */
public class PersionId {

    @SerializedName("personId")
    public String personid;

    public String getPersonid() {
        return personid;
    }

    public PersionId(String personid) {

        this.personid = personid;
    }
}