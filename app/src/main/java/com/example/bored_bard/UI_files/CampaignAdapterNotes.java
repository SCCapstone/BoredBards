package com.example.bored_bard.UI_files;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.notes.MyAdapter;
import com.example.bored_bard.notes.noteList;

import android.view.View;



import java.util.List;

public class CampaignAdapterNotes extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<Campaign> campaignList;

    public CampaignAdapterNotes(Context context, List<Campaign> campaignList) {
        this.context = context;
        this.campaignList = campaignList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.CampaignTitle.setText(campaignList.get(position).getTitle());

        holder.CampaignCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, noteList.class);
                intent.putExtra("Title", campaignList.get(holder.getAdapterPosition()).getTitle());






                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
       return campaignList.size();
    }
}



