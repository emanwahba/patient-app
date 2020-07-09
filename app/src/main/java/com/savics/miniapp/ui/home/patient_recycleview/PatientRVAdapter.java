package com.savics.miniapp.ui.home.patient_recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.savics.miniapp.R;
import com.savics.miniapp.model.pojo.Patient;

public class PatientRVAdapter extends ListAdapter<Patient, PatientViewHolder> {

    public PatientRVAdapter(@NonNull DiffUtil.ItemCallback<Patient> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public PatientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PatientViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_rv_item_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PatientViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }
}

class PatientViewHolder extends RecyclerView.ViewHolder {

    //    private View itemView;

    public PatientViewHolder(@NonNull View itemView) {
        super(itemView);
//        this.itemView = itemView;
    }

    void bindTo(Patient patient) {
        TextView patientDetailsTv = itemView.findViewById(R.id.patient_details_Tv);
        patientDetailsTv.setText(patient.toString());
    }
}
