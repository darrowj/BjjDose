package com.jasondarrow.bjjdose;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dose_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

     //   final ListView listDoses = (ListView) findViewById(R.id.list_doses);

     //   List<Dose> doses = DataManager.getInstance().getDoses();
     //   adapterDoses = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, doses);

     //   listDoses.setAdapter(adapterDoses);

     //   listDoses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
     //       @Override
     //       public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     //           Intent intent = new Intent(DoseListActivity.this, DoseActivity.class);
     //           intent.putExtra(DoseActivity.DOSE_POSITION, position);
     //           startActivity(intent);
     //       }
     //   });

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list_doses);
        final LinearLayoutManager dosesLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(dosesLayoutManager);

        List<Dose> doses = DataManager.getInstance().getDoses();
        doseRecyclerAdapter = new DoseRecyclerAdapter(this, doses);
        recyclerView.setAdapter(doseRecyclerAdapter);


    }

}
