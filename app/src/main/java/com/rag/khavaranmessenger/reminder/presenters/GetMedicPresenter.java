package com.rag.khavaranmessenger.reminder.presenters;

import com.rag.khavaranmessenger.domian.intractor.GetMedicUseCase;
import com.rag.khavaranmessenger.domian.intractor.GetUseCase;
import com.rag.khavaranmessenger.domian.model.MedicModelEntities;
import com.rag.khavaranmessenger.reminder.mapper.ViewModelMapper;
import com.rag.khavaranmessenger.reminder.ui.ShowMedic;

import java.util.List;

public class GetMedicPresenter implements GetUseCase.CallBack<MedicModelEntities> {
    private GetMedicUseCase getMedicUseCase;
    private ViewModelMapper viewModelMapper;
    private ShowMedic showMedic;

    public GetMedicPresenter(GetMedicUseCase getMedicUseCase, ViewModelMapper viewModelMapper, ShowMedic showMedic) {
        this.getMedicUseCase = getMedicUseCase;
        this.viewModelMapper = viewModelMapper;
        this.showMedic = showMedic;
    }

    public void initialize(int id) {
        run(id);
    }

    private void run(int id) {
        getMedicUseCase.medicListExecutor(this);
    }

    @Override
    public void onMedicSuccess(MedicModelEntities model) {
        showMedic.getMedic(viewModelMapper.transformToApp(model));
    }

    @Override
    public void onMedicListSuccess(List<MedicModelEntities> listModel) {
        showMedic.getAllMedic(viewModelMapper.transformToApp(listModel));
    }

    @Override
    public void onError(Exception e) {
        showMedic.showError();
    }

}
