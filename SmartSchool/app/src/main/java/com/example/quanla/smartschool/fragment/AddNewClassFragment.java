package com.example.quanla.smartschool.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.quanla.smartschool.R;
import com.example.quanla.smartschool.activities.ListClassActivity;
import com.example.quanla.smartschool.database.models.bodies.AddNewGroupBody;
import com.example.quanla.smartschool.eventbus.AddNewClassEvent;
import com.example.quanla.smartschool.networks.NetMicrosoftContext;
import com.example.quanla.smartschool.services.FaceGroupService;

import org.greenrobot.eventbus.EventBus;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddNewClassFragment extends Fragment{
    @BindView(R.id.et_class_name)
    EditText etClassName;

    @BindView(R.id.et_classroom)
    EditText etClassroom;

    private String title;
    private AddNewGroupBody addNewGroupBody = new AddNewGroupBody();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AddNewClassFragment() {
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add, menu);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_class, container, false);
        setupUI(view);
        return view;
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);
        if (getActivity() instanceof ListClassActivity) {
            ((ListClassActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.it_ok) {
            addNewClass();
            getActivity().onBackPressed();
        }
        return false;
    }

    public void addNewClass() {
        addNewGroupBody.setName(etClassName.getText().toString());
        addNewGroupBody.setUserdata(etClassroom.getText().toString());
        FaceGroupService faceGroupService = NetMicrosoftContext.instance.create(FaceGroupService.class);
        faceGroupService.addNewGroupFace(UUID.randomUUID().toString(), addNewGroupBody).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("Add New Class", "Succrsssss");
                EventBus.getDefault().postSticky(new AddNewClassEvent("được rồi xúc sinh"));
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                EventBus.getDefault().postSticky(new AddNewClassEvent("Đéo dc ok"));
            }
        });
    }
}
