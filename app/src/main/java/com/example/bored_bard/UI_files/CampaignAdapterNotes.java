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
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class CampaignAdapterNotes extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<Campaign> campaignList;

    /**
     *
     * @param context is context
     * @param campaignList is an List that stores the Information of a Campaign from the Database
     *                     this List will be used to set all the data on the CardViews
     */
    public CampaignAdapterNotes(Context context, List<Campaign> campaignList) {
        this.context = context;
        this.campaignList = campaignList;
    }


    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return the view of the CampaignCard for the Notes Page
     */
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.campaign_item,parent,false);

        return new MyViewHolder(view);
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.CampaignTitle.setText(campaignList.get(position).getTitle());

        //Will take you to the NoteList page and send the Title Pointer to display
        holder.CampaignCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, noteList.class);
                intent.putExtra("Title", campaignList.get(holder.getAdapterPosition()).getTitle());
                context.startActivity(intent);
            }
        });
    }

    /**
     *
     * @return the size of the List
     */
    @Override
    public int getItemCount() {
       return campaignList.size();
    }
}



