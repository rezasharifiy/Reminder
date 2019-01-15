package com.rag.khavaranmessenger.domian.intractor;

public interface DeleteUseCase<I> {
    interface DeleteCallBack {
        boolean onSuccessDelete(boolean b);
        boolean onErrorDelete(Exception e);
    }

    void deleteExecutor(I id, DeleteCallBack deleteCallBack);
}
