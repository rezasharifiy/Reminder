package com.rag.khavaranmessenger.reminder.presenters;

import com.rag.khavaranmessenger.domian.intractor.SaveMedicUseCase;
import com.rag.khavaranmessenger.domian.intractor.SaveUseCase;
import com.rag.khavaranmessenger.reminder.mapper.ViewModelMapper;
import com.rag.khavaranmessenger.reminder.model.MedicModelApp;
import com.rag.khavaranmessenger.reminder.ui.SaveMedicListener;

public class SaveMedicPresenter implements SaveUseCase.InsertCallBack {
    private SaveMedicUseCase saveMedicUseCase;
    private ViewModelMapper viewModelMapper;
    private SaveMedicListener saveMedicListener;

    public SaveMedicPresenter(SaveMedicUseCase saveMedicUseCase, ViewModelMapper viewModelMapper, SaveMedicListener saveMedicListener) {
        this.saveMedicUseCase = saveMedicUseCase;
        this.viewModelMapper = viewModelMapper;
        this.saveMedicListener = saveMedicListener;
    }

    public void initialize(MedicModelApp model) {
        run(model);
    }

    private void run(MedicModelApp modelApp) {
        saveMedicUseCase.insertExecutorMedic(viewModelMapper.transformToEntities(modelApp), this);
    }

    @Override
    public void onSuccessInsert(Boolean isSaved) {
        saveMedicListener.showSuccessMessage();
    }

    @Override
    public void onErrorInsert(Exception e) {
        saveMedicListener.showErrorMessage();
    }


}
