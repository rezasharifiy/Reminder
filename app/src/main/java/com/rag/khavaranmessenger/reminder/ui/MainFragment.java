package com.rag.khavaranmessenger.reminder.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developerman.data.database.DataRepository;
import com.rag.khavaranmessenger.domian.intractor.GetMedicUseCase;
import com.rag.khavaranmessenger.reminder.R;
import com.rag.khavaranmessenger.reminder.adapter.MedicAdapter;
import com.rag.khavaranmessenger.reminder.mapper.ViewModelMapper;
import com.rag.khavaranmessenger.reminder.model.MedicModelApp;
import com.rag.khavaranmessenger.reminder.presenters.GetMedicPresenter;

import java.util.List;

public class MainFragment extends Fragment implements View.OnClickListener, ShowMedic {
    private FloatingActionButton addButton;
    private RecyclerView recyclerView;
    private MedicAdapter medicAdapter;
    private View view;


    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.mian_fragment, container, false);
            setupView();
            getMedic();
        }
        return view;
    }

    private void getMedic() {
        DataRepository dataRepository = new DataRepository(getContext());
        GetMedicPresenter presenter = new GetMedicPresenter(new GetMedicUseCase(dataRepository), new ViewModelMapper(), this);
        presenter.initialize(0);
    }

    private void setupView() {
        recyclerView = view.findViewById(R.id.medic_rv);
        addButton = view.findViewById(R.id.add_fb);
        addButton.setOnClickListener(this);
    }

    private void setupRecyclerView(List<MedicModelApp> list) {
        medicAdapter = new MedicAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(medicAdapter);
    }

    @Override
    public void getMedic(MedicModelApp medicModelApp) {

    }

    @Override
    public void getAllMedic(List<MedicModelApp> medicModelAppList) {
        setupRecyclerView(medicModelAppList);
    }

    @Override
    public void showError() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_fb:
                if (getActivity() != null)
                    ((MainActivity) getActivity()).switchFragment(AddMedicFragment.newInstance());
                break;
        }
    }

}
