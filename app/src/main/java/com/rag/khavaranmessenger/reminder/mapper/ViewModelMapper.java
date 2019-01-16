package com.rag.khavaranmessenger.reminder.mapper;

import com.rag.khavaranmessenger.domian.model.MedicModelEntities;
import com.rag.khavaranmessenger.reminder.main.model.MedicModelApp;

import java.util.ArrayList;
import java.util.List;

public class ViewModelMapper {


    public MedicModelEntities transformToEntities(MedicModelApp medicModelApp) {
        if (medicModelApp == null) {
            throw new IllegalArgumentException("Cannot transformToApp a null value");
        }
        final MedicModelEntities medicModelEntities = new MedicModelEntities();
        medicModelEntities.setDate(medicModelApp.getDate());
        medicModelEntities.setDescription(medicModelApp.getDesccription());
        medicModelEntities.setMessage(medicModelApp.getMessage());
        medicModelEntities.setName(medicModelApp.getName());
        medicModelEntities.setStatus(medicModelApp.getStatus());
        medicModelEntities.setIsActive(medicModelApp.getIsActive());
        medicModelEntities.setPeriod(medicModelApp.getPeriod());
        medicModelEntities.setRowId(medicModelApp.getRowId());
        medicModelEntities.setTakeTime(medicModelApp.getTakeTime());
        medicModelEntities.setTime(medicModelApp.getTime());
        return medicModelEntities;

    }

    public List<MedicModelEntities> transformToEntities(List<MedicModelApp> medicModelApps) {
        List<MedicModelEntities> list = new ArrayList<>();
        for (MedicModelApp modelApp : medicModelApps) {
            list.add(transformToEntities(modelApp));
        }
        return list;
    }

    public MedicModelApp transformToApp(MedicModelEntities medicModelEntities) {
        if (medicModelEntities == null) {
            throw new IllegalArgumentException("Cannot transformToApp a null value");
        }
        final MedicModelApp medicModelApp = new MedicModelApp();
        medicModelApp.setDate(medicModelEntities.getDate());
        medicModelApp.setDesccription(medicModelEntities.getDescription());
        medicModelApp.setMessage(medicModelEntities.getMessage());
        medicModelApp.setName(medicModelEntities.getName());
        medicModelApp.setStatus(medicModelEntities.getStatus());
        medicModelApp.setIsActive(medicModelEntities.getIsActive());
        medicModelApp.setPeriod(medicModelEntities.getPeriod());
        medicModelApp.setRowId(medicModelEntities.getRowId());
        medicModelApp.setTakeTime(medicModelEntities.getTakeTime());
        medicModelApp.setTime(medicModelEntities.getTime());
        return medicModelApp;

    }

    public List<MedicModelApp> transformToApp(List<MedicModelEntities> medicModelEntities) {
        List<MedicModelApp> list = new ArrayList<>();
        for (MedicModelEntities entities : medicModelEntities) {
            list.add(transformToApp(entities));
        }
        return list;
    }

}
