package com.example.bored_bard.encyclopedia;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bored_bard.R;
import com.example.bored_bard.UI_files.campaign_activity;
import com.example.bored_bard.UI_files.combat_activity;
import com.example.bored_bard.UI_files.settings_activity;
import com.example.bored_bard.dice_roller.DieRoller;
import com.example.bored_bard.notes.NotesMainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Encyclopedia extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    RecyclerView recyclerView;
    ArrayList<JSONObject> entryList;
    MyAdapter myAdapter;
    FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encylcopedia); //Tie java file to xml file

        recyclerView = findViewById(R.id.encyclopediaRecyclerView); //Initialize RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance(); //Get Instance of Firestore
        entryList = new ArrayList<JSONObject>();
        myAdapter = new MyAdapter(Encyclopedia.this,entryList); //Initialize Adapter
        recyclerView.setAdapter(myAdapter);
        Gson gson = new GsonBuilder().create();

        dbChange(gson);




        /*db.collection("Encyclopedia")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()) {
                            Object collectionNames;
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                                if (document.getId().equals("defaultCollectionNames")) {
                                    collectionNames = document.getData();
                                    Log.d(TAG,collectionNames.toString());
                                }
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });*/



        //Setup for Bottom Nav Menu
        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav);
        bottomNavView.setSelectedItemId(R.id.campaigns_page);
        // bottom navigation bar to move between activities
        bottomNavView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.campaigns_page) {
                startActivity(new Intent(getApplicationContext(), campaign_activity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.dice_page) {
                startActivity(new Intent(getApplicationContext(), DieRoller.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.notes_page) {
                startActivity(new Intent(getApplicationContext(), NotesMainActivity.class));
                overridePendingTransition(0, 0);
                return true;
            } else if (item.getItemId() == R.id.settings_page) {
                startActivity(new Intent(getApplicationContext(), Encyclopedia.class));
                overridePendingTransition(0, 0);
                return true;
            } else {
                return false;
            }
        });

    }

    private void dbChange(Gson gson) {
        ArrayList<String> collectionList = new ArrayList<>();
        db.collection("Encyclopedia").document("defaultCollectionNames")
                        .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                        if (task.isSuccessful()) {
                            String json = gson.toJson(task.getResult().getData().get("Names"));
                            String[] arr = gson.fromJson(json,String[].class);
                            for (String i : arr) {
                                collectionList.add(i);
                                Log.d(TAG,i);
                            }
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                })
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        for (int j = 0; j < 2; j++) {
                        //for(String i : collectionList) {
                            String i = collectionList.get(j);
                            Log.d(TAG,"\n" + i + "\n");
                            db.collection("Encyclopedia").document("Default").collection(i).orderBy("name", Query.Direction.ASCENDING)
                                    .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {

                                            if (error != null) {
                                                Log.e("Firestore Error",error.getMessage());
                                                return;
                                            }

                                            for (DocumentChange dc : value.getDocumentChanges()) {
                                                if (dc.getType() == DocumentChange.Type.ADDED) {
                                                    String temp = gson.toJson(dc.getDocument().getData());
                                                    Log.d(TAG, temp);
                                                    JSONObject tempObject;
                                                    try {
                                                        tempObject = new JSONObject(temp);
                                                        tempObject.put("type", i);
                                                    } catch (JSONException e) {
                                                        throw new RuntimeException(e);
                                                    }
                                                    entryList.add(tempObject);
                                                    Log.d(TAG, tempObject.toString());
                                                }

                                                myAdapter.notifyDataSetChanged();
                                            }
                                        }
                                    });
                        }
                    }
                });


    }


}