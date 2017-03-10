package com.example.quanla.smartschool.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quanla.smartschool.R;
import com.example.quanla.smartschool.adapter.viewholders.StudentListViewHolder;
import com.example.quanla.smartschool.database.DbStudentContext;
import com.example.quanla.smartschool.studentdata.Student;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public class StudentListAdapter extends RecyclerView.Adapter<StudentListViewHolder> {
    private final String TAG = StudentListAdapter.class.toString();
    private Context context;

    public StudentListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public StudentListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.student_item, parent, false);
        //2: create ViewHolder
        return new StudentListViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(StudentListViewHolder holder, int position) {
        Student student = DbStudentContext.instance.getStudents().get(position);
        Log.e(TAG, String.format("onBindViewHolder: %s", student) );
        holder.bind(student);
    }

    @Override
    public int getItemCount() {
        return DbStudentContext.instance.getStudents().size();
    }
}
