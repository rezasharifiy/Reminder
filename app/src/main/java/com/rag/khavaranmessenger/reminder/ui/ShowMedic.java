package com.rag.khavaranmessenger.reminder.ui;

import com.rag.khavaranmessenger.reminder.main.model.MedicModelApp;

import java.util.List;

public interface ShowMedic {
    void getMedic(MedicModelApp medicModelApp);
    void getAllMedic(List<MedicModelApp> medicModelAppList);
    void showError();
}
