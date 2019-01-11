package com.rag.khavaranmessenger.domian.intractor;

public interface SaveUseCase<M> {

    interface InsertCallBack {
        void onSuccessInsert(Boolean isSaved);

        void onErrorInsert(Exception e);
    }



    void insertExecutorMedic(M medic, InsertCallBack insertCallBack);

}
