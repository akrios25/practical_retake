package nyc.c4q.practicalretake.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.practicalretake.Numbers;
import nyc.c4q.practicalretake.R;
import nyc.c4q.practicalretake.viewholder.Numbers_ViewHolder;

/**
 * Created by c4q on 1/16/18.
 */

public class Number_Adapter extends RecyclerView.Adapter<Numbers_ViewHolder> {
    private List<Numbers> numbersList;

    public Number_Adapter(List<Numbers> numbersList) {
        this.numbersList = numbersList;
    }

    @Override
    public Numbers_ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.numbers_display,parent,false);
        return new Numbers_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Numbers_ViewHolder holder, int position) {
        Numbers numbers = numbersList.get(position);
        holder.onBind(numbers);
    }

    @Override
    public int getItemCount() {
        return numbersList.size();
    }
}
