package com.play.physicswallahtask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherHolder> {

    Context context;
    List<Teacher> teachersList;

    public TeacherAdapter(Context context, List<Teacher> listing) {
        this.context = context;
        teachersList = listing;
    }

    @NonNull
    @Override
    public TeacherHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.teacher_details_layout, parent, false);
        return new TeacherHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherHolder holder, int position) {

        Teacher teacher = teachersList.get(position);
        holder.namingTeacher.setText(teacher.getName());
        holder.eduAndQualificationOfTheTeacher.setText(teacher.getQualification());
        Glide.with(context).load(teacher.getProfilePic()).into(holder.pictureOfTeacher);

    }

    @Override
    public int getItemCount() {
        return teachersList.size();
    }

    public class TeacherHolder extends RecyclerView.ViewHolder {

        ImageView pictureOfTeacher;
        TextView namingTeacher, eduAndQualificationOfTheTeacher;

        public TeacherHolder(@NonNull View itemView) {
            super(itemView);

            pictureOfTeacher = itemView.findViewById(R.id.picOfTeacher);
            namingTeacher = itemView.findViewById(R.id.nameOfTheTeacher);
            eduAndQualificationOfTheTeacher = itemView.findViewById(R.id.subjectOfTheTeacher);

        }
    }
}
