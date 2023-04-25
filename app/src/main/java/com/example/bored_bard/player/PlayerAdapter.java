package com.example.bored_bard.player;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.campaign_menu_activity;
import com.example.bored_bard.notes.MyAdapter;
import com.example.bored_bard.notes.Notes;
import com.example.bored_bard.notes.noteList;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class PlayerAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

   private Context context;
    private ArrayList<Player> Plist;

    /**
     *
     * @param context is context
     * @param Plist is the Array of the Players
     */
    public PlayerAdapter(Context context, ArrayList<Player> Plist) {
        this.context = context;
        this.Plist = Plist;
    }


    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return
     */
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view_characters, parent, false);
        return new MyAdapter.MyViewHolder(view);

    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     *
     */
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

            //Sets the Views to the Values of the Player from the Player ArrayList
            holder.Name.setText(Plist.get(position).getName());
            holder.Race.setText(Plist.get(position).getRace());
            holder.CClass.setText(Plist.get(position).getCclass());
            holder.HP.setText(Plist.get(position).getHp());
            holder.AC.setText(Plist.get(position).getAc());


    }

    @Override
    public int getItemCount() {
        return Plist.size();
    }

}
