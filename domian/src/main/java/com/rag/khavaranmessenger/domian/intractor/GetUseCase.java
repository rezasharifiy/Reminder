package com.rag.khavaranmessenger.domian.intractor;


import java.util.List;

/**@Q means query
 * @M means Model**/
public interface GetUseCase<Q,M> {

    interface CallBack<M> {

        void onMedicSuccess(M model);
        void onMedicListSuccess(List<M> listModel);

        void onError(Exception e);
    }

    void medicExecutor(Q u, CallBack<M> callBack);
    void medicListExecutor( CallBack<M> callBack);

}
