package com.rag.khavaranmessenger.reminder.main.presenter;

import com.rag.khavaranmessenger.domian.intractor.deleteintractor.DeleteMedicUseCase;
import com.rag.khavaranmessenger.domian.intractor.deleteintractor.DeleteUseCase;
import com.rag.khavaranmessenger.reminder.ui.ShowMessage;

public class DeleteMedicPresenter implements DeleteUseCase.DeleteCallBack {
    private DeleteMedicUseCase deleteMedicUseCase;
    private ShowMessage showMessage;

    public DeleteMedicPresenter(DeleteMedicUseCase deleteMedicUseCase, ShowMessage showMessage) {
        this.deleteMedicUseCase = deleteMedicUseCase;
        this.showMessage = showMessage;
    }

    public void initialize(int id) {
        run(id);
    }

    private void run(int id) {
        deleteMedicUseCase.deleteExecutor(id, this);
    }

    @Override
    public boolean onSuccessDelete(boolean b) {
        showMessage.showMessage("حذف شد!");
        return false;
    }

    @Override
    public boolean onErrorDelete(Exception e) {
        showMessage.showMessage(e.toString());
        return false;
    }
}
