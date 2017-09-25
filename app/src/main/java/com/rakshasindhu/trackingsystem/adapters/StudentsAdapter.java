package com.rakshasindhu.trackingsystem.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakshasindhu.trackingsystem.R;
import com.rakshasindhu.trackingsystem.model.StudentsInfo;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by Raksha Sindhu on 9/8/2017.
 */

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    public ArrayList<StudentsInfo> studentsInfos;
    private Context context;

    public StudentsAdapter(ArrayList<StudentsInfo> list, Context context) {
        this.studentsInfos = list;
        this.context = context;
    }


    @Override
    public StudentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_students, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final StudentsAdapter.ViewHolder holder, int position) {


        final StudentsInfo mInfo = studentsInfos.get(position);

        holder.studentID.setText("Student ID: " + mInfo.getStudentID());
        holder.studentName.setText(mInfo.getStudentName());
        Picasso.with(context).load(mInfo.getStudentPhoto()).into(holder.studentPhoto);

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.checkBox.setVisibility(View.INVISIBLE);
                Toast.makeText(context, mInfo.getStudentName() + " is unboarded!", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentsInfos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView studentID, studentName;
        private CircleImageView studentPhoto;
        private ImageView checkBox;

        public ViewHolder(View itemView) {
            super(itemView);

            studentName = (TextView) itemView.findViewById(R.id.studentName);
            studentID = (TextView) itemView.findViewById(R.id.studentID);
            studentPhoto = (CircleImageView) itemView.findViewById(R.id.studentPhoto);
            checkBox = (ImageView) itemView.findViewById(R.id.checkbox);
        }
    }

}
