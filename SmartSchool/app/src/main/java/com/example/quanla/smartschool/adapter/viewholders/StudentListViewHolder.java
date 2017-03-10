package com.example.quanla.smartschool.adapter.viewholders;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanla.smartschool.R;
import com.example.quanla.smartschool.studentdata.Student;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DUC THANG on 3/10/2017.
 */

public class StudentListViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_nameStudent)
    TextView tvNameStudent;
    @BindView(R.id.tv_idStudent)
    TextView tvIdStudent;
    @BindView(R.id.iv_student_img)
    ImageView ivStudent;

    public StudentListViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Student student) {
        DownloadImageTask downloadImageTask = new DownloadImageTask(ivStudent);
        downloadImageTask.execute(student.getUrl());
        tvIdStudent.setText(student.getIdStudent());
        tvNameStudent.setText(student.getName());
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            return null;
        }
    }
}
