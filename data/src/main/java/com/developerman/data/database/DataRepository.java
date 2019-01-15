package com.developerman.data.database;

import android.content.Context;

import com.developerman.data.mapper.MedicDataMapper;
import com.rag.khavaranmessenger.domian.model.MedicModelEntities;
import com.rag.khavaranmessenger.domian.repository.MedicRepository;

import java.util.List;

public class DataRepository implements MedicRepository {
    private MedicDAO medicDAO;
    private MedicDataMapper medicDataMapper;
    private static DataRepository instance = null;

    private DataRepository(Context context) {
        RoomDatabase db = RoomDatabase.getInstance(context);
        medicDAO = db.dao();
        medicDataMapper = new MedicDataMapper();
    }

    public static DataRepository getInstance(Context context) {
        if (instance == null) {
            instance = new DataRepository(context);
        }
        return instance;
    }


        @Override
        public List<MedicModelEntities> getAllMedic () {
            return getAllMedicModelEntities();
        }

        @Override
        public MedicModelEntities getMedic ( int id){
            return getMedicModelEntities(id);
        }

        private MedicModelEntities getMedicModelEntities ( int id){
            return medicDataMapper.transformToEntities(medicDAO.getMedic(id));
        }

        private List<MedicModelEntities> getAllMedicModelEntities () {
            return medicDataMapper.transformToEntities(medicDAO.getAllMedic());
        }

        @Override
        public boolean insert (MedicModelEntities modelEntities){
            medicDAO.insert(medicDataMapper.transformToData(modelEntities));
            return false;
        }

        @Override
        public boolean delete ( int id){
            medicDAO.deleteMedic(id);
            return false;
        }
    }
