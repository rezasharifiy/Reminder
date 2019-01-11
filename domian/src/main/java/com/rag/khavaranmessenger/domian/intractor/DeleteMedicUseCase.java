package com.rag.khavaranmessenger.domian.intractor;

public interface DeleteMedicUseCase<I> {
    interface DeleteCallBack<I> {
        boolean delete(I id);
    }

    void deleteExecutor(I id, DeleteCallBack deleteCallBack);
}
