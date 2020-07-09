package com.savics.miniapp.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.savics.miniapp.model.pojo.Patient;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private ArrayList<Patient> patientList;
    private MutableLiveData<List<Patient>> patientsLiveData;

    public HomeViewModel() {
        patientList = new ArrayList<>();
        patientsLiveData = new MutableLiveData<>();
    }

    public void addNewPatient(String name, String email, int age, char gender) {
        Patient patient = new Patient(name, email, age, gender);
        patientList.add(patient);
        patientsLiveData.setValue(patientList);
    }

    public MutableLiveData<List<Patient>> getPatientsLiveData() {
        return patientsLiveData;
    }
}