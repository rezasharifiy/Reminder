package com.rag.khavaranmessenger.domian.intractor;

import com.rag.khavaranmessenger.domian.model.MedicModelEntities;
import com.rag.khavaranmessenger.domian.repository.SaveRepository;

public class SaveMedicUseCase implements SaveUseCase<MedicModelEntities> {
    private SaveRepository saveRepository;


    public SaveMedicUseCase(SaveRepository saveRepository) {
        this.saveRepository = saveRepository;
    }

    @Override
    public void insertExecutorMedic(MedicModelEntities medic, InsertCallBack insertCallBack) {
        sendCallBack(medic, insertCallBack);
    }

    private void sendCallBack(MedicModelEntities medic, InsertCallBack callBack) {
        try {
            callBack.onSuccessInsert(saveRepository.insert(medic));
        } catch (Exception e) {
            callBack.onErrorInsert(e);
        }
    }
}
