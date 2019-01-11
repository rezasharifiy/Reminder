package com.rag.khavaranmessenger.reminder.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rag.khavaranmessenger.reminder.R;
import com.rag.khavaranmessenger.reminder.model.MedicModelApp;

import java.util.List;

public class MedicAdapter extends RecyclerView.Adapter<MedicAdapter.MedicViewHolder> {


    private final Context context;
    private final List<MedicModelApp> list;

    public MedicAdapter(Context context, List<MedicModelApp> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MedicViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.medic_list_item, viewGroup, false);
        return new MedicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicViewHolder holder, int position) {
        MedicModelApp model = list.get(position);
        holder.medicName.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    class MedicViewHolder extends RecyclerView.ViewHolder {
        TextView medicName;

        public MedicViewHolder(@NonNull View itemView) {
            super(itemView);
            medicName = itemView.findViewById(R.id.medic_name_tv);
        }
    }
}
