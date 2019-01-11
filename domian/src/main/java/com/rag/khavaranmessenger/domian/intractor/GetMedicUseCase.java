package com.rag.khavaranmessenger.domian.intractor;

import com.rag.khavaranmessenger.domian.model.MedicModelEntities;
import com.rag.khavaranmessenger.domian.repository.MedicRepository;

public class GetMedicUseCase implements GetUseCase<Integer, MedicModelEntities> {


    private MedicRepository repository;

    public GetMedicUseCase(MedicRepository repository) {
        this.repository = repository;
    }

    @Override
    public void medicExecutor(Integer id, CallBack<MedicModelEntities> callBack) {
    }

    @Override
    public void medicListExecutor(CallBack<MedicModelEntities> callBack) {
        sendCallBack(callBack);
    }


    private void sendCallBack(CallBack<MedicModelEntities> callBack) {
        try {
            callBack.onMedicListSuccess(repository.getAllMedic());
        } catch (Exception e) {
            callBack.onError(e);
        }
    }


}
