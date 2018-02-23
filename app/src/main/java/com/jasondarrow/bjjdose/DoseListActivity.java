package com.jasondarrow.bjjdose;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.List;

public class DoseListActivity extends AppCompatActivity {

    //private ArrayAdapter<Dose> adapterDoses;
    DoseRecyclerAdapter doseRecyclerAdapter;
    BjjDoseSQLiteHelper mDbOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dose_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDbOpenHelper = new BjjDoseSQLiteHelper(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(DoseListActivity.this, DoseActivity.class));
            }
        });

        initializeDisplayContent();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //adapterDoses.notifyDataSetChanged();
        doseRecyclerAdapter.notifyDataSetChanged();
    }

    private void initializeDisplayContent() {

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_doses);
        final LinearLayoutManager dosesLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(dosesLayoutManager);

        //SQLiteDatabase db = mDbOpenHelper.getReadableDatabase();
        DataManager.loadFromDatabase(mDbOpenHelper);
        List<Dose> doses = DataManager.getInstance().getDoses();  //Dose Array gotten here *********
        doseRecyclerAdapter = new DoseRecyclerAdapter(this, doses);
        recyclerView.setAdapter(doseRecyclerAdapter);


    }

    @Override
    protected void onDestroy() {
        mDbOpenHelper.close();
        super.onDestroy();
    }
}
