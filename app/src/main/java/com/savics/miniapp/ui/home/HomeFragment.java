package com.savics.miniapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.savics.miniapp.FabButtonClick;
import com.savics.miniapp.MainActivity;
import com.savics.miniapp.R;
import com.savics.miniapp.model.pojo.Patient;
import com.savics.miniapp.ui.home.patient_recycleview.PatientItemDiffCallback;
import com.savics.miniapp.ui.home.patient_recycleview.PatientRVAdapter;

import java.util.List;

public class HomeFragment extends Fragment implements FabButtonClick {

    private HomeViewModel homeViewModel;
    private View root;
    private EditText fullNameEt, ageEt, emailEt;
    private RadioGroup genderRg;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        root = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).setListener(this);
    }

    private void initViews() {
        fullNameEt = root.findViewById(R.id.fullName_Et);
        ageEt = root.findViewById(R.id.age_Et);
        emailEt = root.findViewById(R.id.email_Et);
        genderRg = root.findViewById(R.id.gender_Rg);
        RecyclerView patientRv = root.findViewById(R.id.patient_Rv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        patientRv.setLayoutManager(linearLayoutManager);

        final PatientRVAdapter adapter = new PatientRVAdapter(new PatientItemDiffCallback());
        patientRv.setAdapter(adapter);

        homeViewModel.getPatientsLiveData().observe(getViewLifecycleOwner(), new Observer<List<Patient>>() {
            @Override
            public void onChanged(List<Patient> patients) {
                adapter.submitList(patients);
            }
        });
    }

    @Override
    public void onFabClicked() {
        addNewPatient();
    }

    public void addNewPatient() {
        // get selected radio button from radioGroup
        int selectedId = genderRg.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        RadioButton radioButton = root.findViewById(selectedId);
        String selectedGender = (String) radioButton.getText();

        homeViewModel.addNewPatient(fullNameEt.getText().toString(), emailEt.getText().toString(),
                Integer.parseInt(ageEt.getText().toString()), selectedGender.charAt(0));
    }
}