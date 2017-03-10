package com.example.quanla.smartschool.fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.quanla.smartschool.R;
import com.example.quanla.smartschool.activities.ListClassActivity;
import com.example.quanla.smartschool.adapter.ClassListAdapter;
import com.example.quanla.smartschool.database.DbClassContext;
import com.example.quanla.smartschool.evenbus.AddNewClassEvent;
import com.example.quanla.smartschool.evenbus.GetDataFaildedEvent;
import com.example.quanla.smartschool.evenbus.GetDataSuccusEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ListClassFragment extends Fragment {
    private static final String TAG = ListClassActivity.class.toString();
    @BindView(R.id.rv_class_list)
    RecyclerView rvClassList;
    ClassListAdapter classListAdapter ;
    ProgressDialog progress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_class, container, false);
        setupUI(view);

        progress = ProgressDialog.show(this.getContext(), "Loading",
                "Please waiting...", true);
        if (DbClassContext.instance.getStudents()!=null){
            progress.dismiss();
            classListAdapter = new ClassListAdapter(this.getContext());
            rvClassList.setAdapter(classListAdapter);
            rvClassList.setLayoutManager(new LinearLayoutManager(this.getContext()));
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
            rvClassList.addItemDecoration(dividerItemDecoration);

        }else {
            progress.show();
        }

        return view;
    }

    private void setupUI(View view) {
        ButterKnife.bind(this, view);
    }

    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onAddNewTask(AddNewClassEvent event){
        Log.e(TAG, "onAddNewTask: ddmc" );
        Toast.makeText(getContext(), event.getMsg(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        EventBus.getDefault().register(this);
        // luc back no deo goi cai ham nay
    }
// m huy dang ky trong onDestroy view dcm ok d cm khi add xong phai load lai data nhi?add thanh cong thi add vao Db luon
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
        // sao nó đéo hiện task?

    @Subscribe(sticky = true ,threadMode = ThreadMode.MAIN)
    public void getDataSuccus(GetDataSuccusEvent event) {
        // luc ve lai no doi cai nay dcm
        progress.dismiss();
        classListAdapter = new ClassListAdapter(this.getContext());
        rvClassList.setAdapter(classListAdapter);
        rvClassList.setLayoutManager(new LinearLayoutManager(this.getContext()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this.getContext(), DividerItemDecoration.VERTICAL);
        rvClassList.addItemDecoration(dividerItemDecoration);

        Toast.makeText(this.getContext(), "Load completed", Toast.LENGTH_SHORT).show();
    }

    public void getDataFailed(GetDataFaildedEvent event) {
        progress.dismiss();

        Toast.makeText(this.getContext(), "Load failed", Toast.LENGTH_SHORT).show();
    }



}