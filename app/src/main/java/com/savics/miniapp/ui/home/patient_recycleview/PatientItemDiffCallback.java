package com.savics.miniapp.ui.home.patient_recycleview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.savics.miniapp.model.pojo.Patient;

public class PatientItemDiffCallback extends DiffUtil.ItemCallback<Patient> {

    @Override
    public boolean areItemsTheSame(@NonNull Patient oldItem, @NonNull Patient newItem) {
        return oldItem == newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Patient oldItem, @NonNull Patient newItem) {
        return oldItem.getFullName().equals(newItem.getFullName());
    }
}
