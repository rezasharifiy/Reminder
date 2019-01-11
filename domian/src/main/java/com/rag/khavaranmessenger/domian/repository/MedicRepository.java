package com.rag.khavaranmessenger.domian.repository;

import com.rag.khavaranmessenger.domian.model.MedicModelEntities;

import java.util.List;

public interface MedicRepository {

    List<MedicModelEntities> getAllMedic();

    MedicModelEntities getMedic(int id);


}
