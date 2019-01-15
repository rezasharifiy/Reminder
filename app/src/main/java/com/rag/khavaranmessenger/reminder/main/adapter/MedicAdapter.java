package com.rag.khavaranmessenger.reminder.main.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rag.khavaranmessenger.reminder.R;
import com.rag.khavaranmessenger.reminder.main.model.MedicModelApp;

import java.util.List;

public class MedicAdapter extends RecyclerView.Adapter<MedicAdapter.MedicViewHolder> {


    private final Context context;
    private final List<MedicModelApp> list;
    private AdapterClickListerner listerner;

    public MedicAdapter(Context context, List<MedicModelApp> list, AdapterClickListerner listerner) {
        this.listerner = listerner;
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

    class MedicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView medicName;

        public MedicViewHolder(@NonNull View itemView) {
            super(itemView);
            medicName = itemView.findViewById(R.id.medic_name_tv);
            itemView.setOnLongClickListener(this);
            itemView.setTag(this);

        }

        @Override
        public boolean onLongClick(View v) {
            MedicViewHolder medicViewHolder = (MedicViewHolder) v.getTag();
            int pos = medicViewHolder.getLayoutPosition();
            if (listerner != null) {
                listerner.onListItemLongClick(pos);
            }
            return false;
        }

        @Override
        public void onClick(View v) {
            MedicViewHolder medicViewHolder = (MedicViewHolder) v.getTag();
            int pos = medicViewHolder.getLayoutPosition();
            if (listerner != null) {
                listerner.onListItemClick(pos);
            }
        }
    }

    public interface AdapterClickListerner {
        void onListItemClick(int pos);

        void onListItemLongClick(int pos);
    }
}
