package com.rag.khavaranmessenger.domian.intractor.deleteintractor;

import com.rag.khavaranmessenger.domian.repository.MedicRepository;

public class DeleteMedicUseCase implements DeleteUseCase<Integer> {

    private MedicRepository medicRepository;

    public DeleteMedicUseCase(MedicRepository medicRepository) {
        this.medicRepository = medicRepository;
    }

    @Override
    public void deleteExecutor(Integer id, DeleteCallBack deleteCallBack) {
        deleteCallback(id, deleteCallBack);
    }

    private void deleteCallback(int id, DeleteCallBack deleteCallBack) {
        try {
            deleteCallBack.onSuccessDelete(medicRepository.delete(id));
        } catch (Exception e) {
            e.printStackTrace();
            deleteCallBack.onErrorDelete(e);
        }
    }

}
