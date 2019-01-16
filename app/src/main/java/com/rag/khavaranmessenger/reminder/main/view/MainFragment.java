package com.rag.khavaranmessenger.reminder.main.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

import com.developerman.data.database.DataRepository;
import com.rag.khavaranmessenger.domian.intractor.deleteintractor.DeleteMedicUseCase;
import com.rag.khavaranmessenger.domian.intractor.getintarctor.GetMedicUseCase;
import com.rag.khavaranmessenger.reminder.R;
import com.rag.khavaranmessenger.reminder.main.adapter.MedicAdapter;
import com.rag.khavaranmessenger.reminder.addmedic.view.AddMedicFragment;
import com.rag.khavaranmessenger.reminder.mapper.ViewModelMapper;
import com.rag.khavaranmessenger.reminder.main.model.MedicModelApp;
import com.rag.khavaranmessenger.reminder.main.presenter.DeleteMedicPresenter;
import com.rag.khavaranmessenger.reminder.main.presenter.GetMedicPresenter;
import com.rag.khavaranmessenger.reminder.ui.MainActivity;
import com.rag.khavaranmessenger.reminder.ui.ShowMedic;
import com.rag.khavaranmessenger.reminder.ui.ShowMessage;

import java.util.List;

public class MainFragment extends Fragment implements View.OnClickListener, ShowMedic, ShowMessage, MedicAdapter.AdapterClickListerner {
    private FloatingActionButton addButton;
    private RecyclerView recyclerView;
    private MedicAdapter medicAdapter;
    private View view;
    private List<MedicModelApp> medicModelAppList;


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
        DataRepository dataRepository =DataRepository.getInstance(getContext());
        GetMedicPresenter presenter = new GetMedicPresenter(new GetMedicUseCase(dataRepository), new ViewModelMapper(), this);
        presenter.initialize(0);
    }

    private void setupView() {
        recyclerView = view.findViewById(R.id.medic_rv);
        addButton = view.findViewById(R.id.add_fb);
        addButton.setOnClickListener(this);
    }

    private void setupRecyclerView(List<MedicModelApp> list) {
        medicAdapter = new MedicAdapter(getContext(), list, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(medicAdapter);
    }

    @Override
    public void getMedic(MedicModelApp medicModelApp) {

    }

    @Override
    public void getAllMedic(List<MedicModelApp> medicModelAppList) {
        this.medicModelAppList = medicModelAppList;
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

    @Override
    public void onListItemClick(int pos) {

    }

    @Override
    public void onListItemLongClick(int pos) {
        showDialog(pos, medicModelAppList.get(pos).getRowId());
    }

    private void showDialog(final int pos, final int id) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setMessage(R.string.remove_message_alert);
        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                removeItemFromDB(id);
                removeItemFromList(pos);
            }
        });
        alertDialog.show();
    }

    private void removeItemFromList(int pos) {
        medicModelAppList.remove(pos);
        medicAdapter.notifyItemRemoved(pos);
    }

    private void removeItemFromDB(int id) {
        DataRepository dataRepository = DataRepository.getInstance(getContext());
        DeleteMedicPresenter deleteMedicPresenter = new DeleteMedicPresenter(new DeleteMedicUseCase(dataRepository), this);
        deleteMedicPresenter.initialize(id);

    }

    @Override
    public void showMessage(String message) {
        showToast(message);
    }

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}
