package com.example.quanla.smartschool.adapter.viewholders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.quanla.smartschool.R;
import com.example.quanla.smartschool.classlistdata.ClassStudent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public class ClassListViewHolder extends RecyclerView.ViewHolder {
    private String TAG = ClassListViewHolder.class.toString();
    @BindView(R.id.tv_classname)
    TextView tvClassName;
    @BindView(R.id.tv_classsize)
    TextView tvClassSize;
    @BindView(R.id.tv_classroom)
    TextView tvClassRoom;

    public ClassListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final ClassStudent classStudent) {
        tvClassName.setText(classStudent.getName());
        tvClassRoom.setText(classStudent.getClassRoom());
        Log.e(TAG, String.format(" nhận bind: %s", classStudent.getStudents().size()));
        tvClassSize.setText(String.format("%s sv", classStudent.getStudents().size()));
    }
}
