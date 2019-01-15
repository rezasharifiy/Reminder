package com.rag.khavaranmessenger.reminder.addmedic.view.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.developerman.data.database.DataRepository;
import com.rag.khavaranmessenger.domian.intractor.saveintractor.SaveMedicUseCase;
import com.rag.khavaranmessenger.reminder.R;
import com.rag.khavaranmessenger.reminder.addmedic.view.SaveMedicListener;
import com.rag.khavaranmessenger.reminder.mapper.ViewModelMapper;
import com.rag.khavaranmessenger.reminder.main.model.MedicModelApp;
import com.rag.khavaranmessenger.reminder.addmedic.view.peresenter.SaveMedicPresenter;
import com.rag.khavaranmessenger.reminder.ui.MainActivity;
import com.rag.khavaranmessenger.reminder.main.view.MainFragment;

public class AddMedicFragment extends Fragment implements View.OnClickListener, SaveMedicListener {
    private View view;
    private EditText medic_et;
    public static AddMedicFragment newInstance() {
        Bundle args = new Bundle();
        AddMedicFragment fragment = new AddMedicFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            setupView(inflater, container);
        }
        return view;
    }

    private void setupView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        view = inflater.inflate(R.layout.add_medic_fragment, container, false);
        medic_et = view.findViewById(R.id.medic_et);
        Button save_bt = view.findViewById(R.id.save_bt);
        save_bt.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save_bt:
                if (checkFields())
                    saveMedic(generateMedic());
                break;
        }
    }

    private boolean checkFields() {
        if (medic_et.getText().equals("")) {
            showToast(getString(R.string.error_medic_name));
            return false;
        }
        return true;
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private MedicModelApp generateMedic() {
        MedicModelApp modelApp = new MedicModelApp();
        modelApp.setName(medic_et.getText().toString());
        return modelApp;
    }

    private void saveMedic(MedicModelApp modelApp) {
        DataRepository dataRepository =DataRepository.getInstance(getContext());
        SaveMedicPresenter saveMedicPresenter = new SaveMedicPresenter(new SaveMedicUseCase(dataRepository),
                new ViewModelMapper(), this);
        saveMedicPresenter.initialize(modelApp);
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(getContext(), R.string.saved, Toast.LENGTH_SHORT).show();
        backToMain();
    }

    @Override
    public void showErrorMessage() {
        Toast.makeText(getContext(), R.string.error_save, Toast.LENGTH_SHORT).show();
        backToMain();

    }

    private void backToMain() {
        if (getActivity() != null)
            ((MainActivity) getActivity()).switchFragment(MainFragment.newInstance());
    }
}
