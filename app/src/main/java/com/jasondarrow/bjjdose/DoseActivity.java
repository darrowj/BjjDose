package com.jasondarrow.bjjdose;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DoseActivity extends AppCompatActivity {

    public static final String DOSE_POSITION = "com.jasondarrow.bjjdose.DOSE_POSITION";
    public static final String ORIGINAL_CATEGORY = "com.jasondarrow.bjjdose.CATEGORY";
    public static final String ORIGINAL_ENGAGEMENT = "com.jasondarrow.bjjdose.ENGAGEMENT";
    public static final String ORIGINAL_STARTING_POSTURE = "com.jasondarrow.bjjdose.STARTING_POSTURE";
    public static final String ORIGINAL_OFFENSIVE_POSITION = "com.jasondarrow.bjjdose.OFFENSIVE_POSITION";
    public static final String ORIGINAL_GUARD = "com.jasondarrow.bjjdose.GUARD";
    public static final String ORIGINAL_SWEEP = "com.jasondarrow.bjjdose.SWEEP";
    public static final String ORIGINAL_SUBMISSION = "com.jasondarrow.bjjdose.SUBMISSION";
    public static final String ORIGINAL_DOSE_TITLE ="com.jasondarrow.bjjdose.DOSE_TITLE";
    public static final String ORIGINAL_DOSE_DESCRIPTION = "com.jasondarrow.bjjdose.DOSE_DESCRIPTION";
    public static final int POSITION_NOT_SET = -1;
    Map<String, Lookup> lookups = DataManager.getInstance().getLookups();
    private boolean mIsNewDose;
    boolean mIsCancelling = false;
    private Dose mDose;
    private int mDosePosition;
    private Spinner spinnerCategory ;
    private Spinner spinnerEngagement;
    private Spinner spinnerStartingPosture;
    private Spinner spinnerOffensivePosition;
    private Spinner spinnerGuard;
    private Spinner spinnerSweep;
    private Spinner spinnerSubmission;
    private EditText textDoseTitle;
    private EditText textDoseDescription;
    private String mOriginalCategory ;
    private String mOriginalEngagement;
    private String mOriginalStartingPosture;
    private String mOriginalOffensivePosition;
    private String mOriginalGuard;
    private String mOriginalSweep;
    private String mOriginalSubmission;
    private String mOriginalDoseTitle;
    private String mOriginalDoseDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerCategory = (Spinner) findViewById(R.id.spinner_dose_category);
        spinnerEngagement = (Spinner) findViewById(R.id.spinner_dose_engagement);
        spinnerStartingPosture = (Spinner) findViewById(R.id.spinner_dose_startPosture);
        spinnerOffensivePosition =
                (Spinner) findViewById(R.id.spinner_dose_offensivePosition);
        spinnerGuard = (Spinner) findViewById(R.id.spinner_dose_guard);
        spinnerSweep = (Spinner) findViewById(R.id.spinner_dose_sweep);
        spinnerSubmission = (Spinner) findViewById(R.id.spinner_dose_submission);



        setSpinnerValues(lookups.get("category").getNames(), spinnerCategory);
        setSpinnerValues(lookups.get("engagement").getNames(), spinnerEngagement);
        setSpinnerValues(lookups.get("startPosition").getNames(), spinnerStartingPosture);
        setSpinnerValues(lookups.get("offensivePosition").getNames(), spinnerOffensivePosition);
        setSpinnerValues(lookups.get("guard").getNames(), spinnerGuard);
        setSpinnerValues(lookups.get("sweep").getNames(), spinnerSweep);
        setSpinnerValues(lookups.get("submission").getNames(), spinnerSubmission);



        readDisplayStateValues();
        if(savedInstanceState == null) {
            saveOriginalNoteValues();
        } else {
            restoreOriginalNoteValues(savedInstanceState);
        }

        textDoseTitle = (EditText) findViewById(R.id.text_title);
        textDoseDescription = (EditText) findViewById(R.id.multitext_dose_description);

        if(!mIsNewDose)
            displayDose(textDoseTitle, textDoseDescription);


    }

    private void restoreOriginalNoteValues(Bundle savedInstanceState) {
        mDosePosition = savedInstanceState.getInt(DOSE_POSITION);
        mOriginalCategory = savedInstanceState.getString(ORIGINAL_CATEGORY);
        mOriginalEngagement = savedInstanceState.getString(ORIGINAL_ENGAGEMENT);
        mOriginalStartingPosture = savedInstanceState.getString(ORIGINAL_STARTING_POSTURE);
        mOriginalOffensivePosition = savedInstanceState.getString(ORIGINAL_OFFENSIVE_POSITION);
        mOriginalGuard = savedInstanceState.getString(ORIGINAL_GUARD);
        mOriginalSweep = savedInstanceState.getString(ORIGINAL_SWEEP);
        mOriginalSubmission = savedInstanceState.getString(ORIGINAL_SUBMISSION);
        mOriginalDoseTitle = savedInstanceState.getString(ORIGINAL_DOSE_TITLE);
        mOriginalDoseDescription = savedInstanceState.getString(ORIGINAL_DOSE_DESCRIPTION);
    }

    private void saveOriginalNoteValues() {
        if(mIsNewDose)
            return;
        mOriginalCategory = mDose.getCategory();
        mOriginalEngagement = mDose.getEngagement();
        mOriginalStartingPosture = mDose.getPosture();
        mOriginalOffensivePosition = mDose.getOffensivePosition();
        mOriginalGuard = mDose.getGuard();
        mOriginalSweep = mDose.getSweep();
        mOriginalSubmission = mDose.getSubmission();
        mOriginalDoseTitle = mDose.getTitle();
        mOriginalDoseDescription = mDose.getDescription();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mIsCancelling) {
            if (mIsNewDose) {
                DataManager.getInstance().removeDose(mDosePosition);
            }
        } else {
            saveDose();
        }
    }

    private void saveDose() {
        mDose.setCategory((String) spinnerCategory.getSelectedItem());
        mDose.setEngagement((String) spinnerEngagement.getSelectedItem());
        mDose.setPosture((String) spinnerStartingPosture.getSelectedItem());
        mDose.setOffensivePosition((String) spinnerOffensivePosition.getSelectedItem() );
        mDose.setGuard((String) spinnerGuard.getSelectedItem());
        mDose.setSweep((String) spinnerSweep.getSelectedItem());
        mDose.setSubmission((String) spinnerSubmission.getSelectedItem());
        mDose.setTitle(textDoseTitle.getText().toString());
        mDose.setDescription(textDoseDescription.getText().toString());
    }


    private void displayDose(EditText textDoseTitle, EditText textDoseText) {
        setSpinnerValue(spinnerCategory, lookups.get("category").getNames(), mDose.getCategory());
        setSpinnerValue(spinnerEngagement, lookups.get("engagement").getNames(), mDose.getEngagement());
        setSpinnerValue(spinnerStartingPosture, lookups.get("startPosition").getNames(), mDose.getPosture());
        setSpinnerValue(spinnerOffensivePosition, lookups.get("offensivePosition").getNames(), mDose.getOffensivePosition());
        setSpinnerValue(spinnerGuard, lookups.get("guard").getNames(), mDose.getGuard());
        setSpinnerValue(spinnerSweep, lookups.get("sweep").getNames(), mDose.getSweep());
        setSpinnerValue(spinnerSubmission, lookups.get("submission").getNames(), mDose.getSubmission());
        textDoseTitle.setText(mDose.getTitle());
        textDoseText.setText(mDose.getDescription());
    }

    private void readDisplayStateValues() {
        Intent intent = getIntent();

        mDosePosition = intent.getIntExtra(DOSE_POSITION, POSITION_NOT_SET);
        mIsNewDose = mDosePosition == POSITION_NOT_SET;
        if (mIsNewDose) {
            createNewDose();
        } else {
            mDose = DataManager.getInstance().getDoses().get(mDosePosition);
        }
    }

    private void createNewDose() {
        DataManager dm = DataManager.getInstance();
        mDosePosition = dm.createNewDose();
        mDose = dm.getDoses().get(mDosePosition);
    }

    private void setSpinnerValue(Spinner spinner, List<String> spinnerValues, String spinnerValue) {

        for( String value : spinnerValues ) {
            if(value.equals(spinnerValue))
                spinner.setSelection(spinnerValues.indexOf(value));
        }
    }

    private void setSpinnerValues(List names, Spinner spinner) {
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                        names);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dose, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cancel) {
            mIsCancelling = true;
            finish();
        } else if (id == R.id.action_next) {
            moveNext();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item = menu.findItem(R.id.action_next);
        int lastDoseIndex = DataManager.getInstance().getDoses().size() - 1;
        item.setEnabled(mDosePosition < lastDoseIndex);
        return super.onPrepareOptionsMenu(menu);
    }

    private void moveNext() {
        saveDose();

        ++mDosePosition;
        mDose = DataManager.getInstance().getDoses().get(mDosePosition);

        saveOriginalNoteValues();

        displayDose(textDoseTitle, textDoseDescription);

        invalidateOptionsMenu();
    }
}
