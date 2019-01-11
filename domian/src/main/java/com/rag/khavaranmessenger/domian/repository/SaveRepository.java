package com.rag.khavaranmessenger.domian.repository;

import com.rag.khavaranmessenger.domian.model.MedicModelEntities;

public interface SaveRepository {
    boolean insert(MedicModelEntities modelEntities);

    boolean delete(int id);
}
