package com.example.bored_bard.UI_files;

import android.content.Context;
import android.content.Intent;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.campaign.Campaign;
import com.example.bored_bard.notes.MyAdapter;


import android.view.View;



import java.util.List;

public class CampaignAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {

    private Context context;
    private List<Campaign> campaignList;

    public CampaignAdapter(Context context, List<Campaign> campaignList) {
        this.context = context;
        this.campaignList = campaignList;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_item,parent,false);

        return new MyAdapter.MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHodler holder, int position) {
          holder.CampaignTitle.setText(campaignList.get(position).getTitle());

          holder.CampaignCard.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(context, campaign_menu_activity.class);
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

class MyViewHolder extends RecyclerView.ViewHolder{
    TextView CampaignTitle, TitleC;
    CardView CampaignCard;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);


        CampaignTitle = itemView.findViewById(R.id.recCampaignTitle);
        CampaignCard = itemView.findViewById(R.id.CampaignCard);
        TitleC = itemView.findViewById(R.id.header_title);
    }
}
