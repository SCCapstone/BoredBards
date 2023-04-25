package com.example.bored_bard.Combat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.player.Player;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.jar.Attributes;

/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class CombatAdapter extends RecyclerView.Adapter<CombatAdapter.CombatHolder>{
    Context context;
   ArrayList<Player> playerlist;


    /**
     *
      * @param context is context?
     * @param playerlist is the ArrayList of Players that will be used to set the CombatCard View
     *                   With the Data From the RealTime Database
     */
    public CombatAdapter(Context context, ArrayList<Player> playerlist) {
        this.context = context;
        this.playerlist = playerlist;
    }

    /**
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return view is the CombatCard View
     */
    @NonNull
    @Override
    public CombatHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.combat_card, parent, false);
        return new CombatHolder(view);
    }

    /**
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *        item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull CombatHolder holder, int position) {FirebaseUser user;


            //Sets the CombatCard with Values from the ArrayList
            holder.Name.setText(playerlist.get(position).getName());
            holder.HP.setText(playerlist.get(position).getHp());
            holder.AC.setText(playerlist.get(position).getAc());



    }

    /**
     *
     * @return the size of the playerList
     */
    @Override
    public int getItemCount() {
        return playerlist.size();
    }


    /**
     * Stores the Views that are needed for the CombatCard
     */
    public static class CombatHolder extends RecyclerView.ViewHolder{
        TextView Name, AC;
        EditText HP, IntRoll;

        CardView CombatCard;
        public CombatHolder(@NonNull View itemView){
            super(itemView);

            Name = itemView.findViewById(R.id.CombatName);
            AC = itemView.findViewById(R.id.CombatAC);

            HP = itemView.findViewById(R.id.CombatHP);
            IntRoll = itemView.findViewById(R.id.IntRoll);

            CombatCard = itemView.findViewById(R.id.combatCard);




        }
    }
}

