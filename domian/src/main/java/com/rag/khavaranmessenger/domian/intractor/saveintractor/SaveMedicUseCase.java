package com.rag.khavaranmessenger.domian.intractor.saveintractor;

import com.rag.khavaranmessenger.domian.model.MedicModelEntities;
import com.rag.khavaranmessenger.domian.repository.MedicRepository;

public class SaveMedicUseCase implements SaveUseCase<MedicModelEntities> {
    private MedicRepository medicRepository;


    public SaveMedicUseCase(MedicRepository saveRepository) {
        this.medicRepository = saveRepository;
    }

    @Override
    public void insertExecutorMedic(MedicModelEntities medic, InsertCallBack insertCallBack) {
        sendCallBack(medic, insertCallBack);
    }

    private void sendCallBack(MedicModelEntities medic, InsertCallBack callBack) {
        try {
            callBack.onSuccessInsert(medicRepository.insert(medic));
        } catch (Exception e) {
            callBack.onErrorInsert(e);
        }
    }
}
