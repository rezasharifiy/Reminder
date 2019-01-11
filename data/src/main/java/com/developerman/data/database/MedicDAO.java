package com.developerman.data.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.developerman.data.model.MedicModelData;

import java.util.List;

@Dao
public interface MedicDAO {
    @Insert
    void insert(MedicModelData word);

    @Query("DELETE FROM medic_table")
    void deleteAll();

    @Query("DELETE FROM medic_table where `rowId`=:id")
    void deleteMedic(int id);

    @Query("SELECT * from medic_table where `rowId`=:rowId ")
    MedicModelData getMedic(int rowId);

    @Query("SELECT * from medic_table")
    List<MedicModelData> getAllMedic();
}
