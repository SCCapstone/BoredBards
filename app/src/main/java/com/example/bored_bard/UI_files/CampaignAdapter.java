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
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class CampaignAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private List<Campaign> campaignList;

    /**
     *
     * @param context is context
     * @param campaignList is an ArrayList that stores the Information of a Campaign from the Database
     *                     this ArrayList will be used to set all the data on the CardViews
     */
    public CampaignAdapter(Context context, List<Campaign> campaignList) {
        this.context = context;
        this.campaignList = campaignList;
    }

    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return the CampaignCard View
     */
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_item,parent,false);

        return new MyAdapter.MyViewHolder(view);
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
          holder.CampaignTitle.setText(campaignList.get(position).getTitle());

          //will take the User to the Campaign Menu for the selected Campaign
          holder.CampaignCard.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(context, campaign_menu_activity.class);
                  intent.putExtra("Title", campaignList.get(holder.getAdapterPosition()).getTitle());






                  context.startActivity(intent);
              }
          });
    }

    /**
     *
     * @return the size of the list
     */
    @Override
    public int getItemCount() {
        return campaignList.size();
    }
}

/**
 *  will hold the views that are present in the CardView to be set by the ArrayList
 */
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
