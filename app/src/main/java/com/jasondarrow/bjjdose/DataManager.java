package com.jasondarrow.bjjdose;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.jasondarrow.bjjdose.BjjDoseDOA.*;

/**
 * Created by darrowj on 12/30/17.
 */

public class DataManager {

    private static DataManager dmInstance = null;
    private static List<Dose> doses = new ArrayList<>();
    private static HashMap<String, Lookup> lookups = new HashMap<>();

    public static DataManager getInstance() {
        if(dmInstance == null) {
            dmInstance = new DataManager();
            //dmInstance.initLookups();
            //dmInstance.initDoses();
        }
        return dmInstance;
    }

    public static void loadFromDatabase(BjjDoseSQLiteHelper dbHelper) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        final String[] doseColumns = {
                DoseEntity.COLUMN_ID,
                DoseEntity.COLUMN_UID,
                DoseEntity.COLUMN_TITLE,
                DoseEntity.COLUMN_CATEGORY,
                DoseEntity.COLUMN_ENGAGEMENT,
                DoseEntity.COLUMN_POSTURE,
                DoseEntity.COLUMN_OFFENSIVEPOSITION,
                DoseEntity.COLUMN_SUBMISSION,
                DoseEntity.COLUMN_GUARD,
                DoseEntity.COLUMN_SWEEP,
                DoseEntity.COLUMN_DESCRIPTION,
                DoseEntity.COLUMN_PUBLISHED,
                DoseEntity.COLUMN_CREATED};

        final Cursor doseCursor = db.query(DoseEntity.TABLE_NAME, doseColumns,
                null, null, null, null, DoseEntity.COLUMN_CREATED + " DESC");
        loadDosesFromDatabase(doseCursor);

        final String[] lookupColumns = {
                LookupEntity.COLUMN_ID,
                LookupEntity.COLUMN_TITLE,
                LookupEntity.COLUMN_NAMES
        };
        final Cursor lookupCursor = db.query(LookupEntity.TABLE_NAME, lookupColumns,
                null, null, null, null, LookupEntity.COLUMN_ID);
        loadLookupsFromDatabase(lookupCursor);

    }

    private static void loadDosesFromDatabase(Cursor cursor) {
        DataManager dm = getInstance();
        dm.resetDoses();
        while(cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_ID));
            String uid = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_UID));
            String title = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_TITLE));
            String category = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_CATEGORY));
            String engagement = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_ENGAGEMENT));
            String posture = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_POSTURE));
            String offensivePosition = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_OFFENSIVEPOSITION));
            String submission = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_SUBMISSION));
            String guard = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_GUARD));
            String sweep = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_SWEEP));
            String description = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_DESCRIPTION));
            String published = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_PUBLISHED));
            String created = cursor.getString(cursor.getColumnIndex(DoseEntity.COLUMN_CREATED));

            doses.add(new Dose(id, uid, title, category, engagement, posture, offensivePosition,
                    submission, guard, sweep, description,published, created));
        }
        cursor.close();
    }

    private static void loadLookupsFromDatabase(Cursor cursor) {
        DataManager dm = getInstance();
        dm.resetLookups();
        while(cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(LookupEntity.COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndex(LookupEntity.COLUMN_TITLE));
            String names = cursor.getString(cursor.getColumnIndex(LookupEntity.COLUMN_NAMES));

            Lookup lookup = new Lookup(id , title,
                    Arrays.asList(names.split("\\s*,\\s*")));
            lookups.put(title, lookup);

        }
        cursor.close();
    }

    public HashMap<String, Lookup> getLookups() {
        return lookups;
    }


    public List<Dose> getDoses() {
        return doses;
    }


    public int createNewDose() {
        Dose dose = new Dose(null, null, null, null);
        doses.add(dose);
        return doses.size() - 1;
    }

    public void removeDose(int index) {
        doses.remove(index);
    }

    public void initLookups() {
        Lookup category = new Lookup("1", "category",
                Arrays.asList(" ", "Transition","Sweep","Submission","Drill","Pass",
                        "Escape","Takedown"));
        Lookup engagement = new Lookup("2", "engagement",
                Arrays.asList(" ", "Attacking","Defending"));
        Lookup startPosture = new Lookup("3", "startPosture",
                Arrays.asList(" ", "Bottom","Scramble","Standing","Top"));
        Lookup offensivePosition = new Lookup("4", "offensivePosition",
                Arrays.asList(" ", "50-50","Back Control","Full Mount","Knee on Belly",
                        "North - South","Side Control","S-Mount","Turtle Top"));
        Lookup guard = new Lookup("5", "guard",
                Arrays.asList(" ", "50-50","Butterfly","Closed Guard","Deep Half Guard",
                        "De La Riva","Half Guard","Open Guard","Spider Guard","Inverted Guard",
                        "Quarter Guard","Reverse De La Riva","Turtle Guard","Tornado Guard",
                        "X-Guard"));
        Lookup sweep = new Lookup("6", "sweep",
                Arrays.asList(" ", "Butterfly","Elevator Hook","Flower","Half Guard",
                        "Hip Bump","LumberJack","Lasso","Sickle","Scissor","Waiter"));
        Lookup submission = new Lookup("7", "submission",
                Arrays.asList(" ", "Americana", "Ankle Lock", "Arm Triangle", "Armbar",
                        "Banana Split", "Bicep Cutter", "Bow & Arrow", "Brabo Choke",
                        "Bulldog Choke", "Calf Cutter", "Clock Choke", "Collar Choke",
                        "Cutter Choke", "Estima Lock", "Ezekiel Choke", "Gogoplata", "Guillotine",
                        "Headlock", "Heel Hook", "Kimura", "Kneebar", "Lapel Choke", "Loop Choke",
                        "North-South Choke", "Omoplata", "Pressure", "Rear Naked Choke",
                        "Shoulder Lock", "Smother", "Toe Hold", "Triangle", "Twister",
                        "Wrist Lock"));
        lookups.put("category", category);
        lookups.put("engagement", engagement);
        lookups.put("startPosition", startPosture);
        lookups.put("offensivePosition", offensivePosition);
        lookups.put("guard", guard);
        lookups.put("sweep", sweep);
        lookups.put("submission", submission);
    }

    public void initDoses() {
        //String id, String uid, String title, String category, String engagement,
        //String posture, String offensivePosition, String submission, String guard,
        //String sweep, String description, String published, String created

        doses.add(new Dose("1", "", "Butterfly guard grip offence on biceps.  ",
                "Drill", "Defending", "Top", "", "", "Butterfly", "",
                "Engage opponent square to you.  Once they grab your pant leg you defend.  Place both hands on the opponents biceps.  As they try and take an angle on you counter with a push pull strategy.  Push against the bicep of the direction they are going in.  Grip and pull on the tricep of the trailing arm.  This will cause the opponent to lose balance or posture.  If possible get a hook under a knee and sweep the opponent to the side they are turn into.    ",
                "Y", "12/10/2017 18:48"));

        doses.add(new Dose("2", "", "Waiter Like Sweep When Mounted",
                "Sweep", "Defending", "Bottom", "", "", "", "Waiter",
                "This is a mount escape scenario.  With Elbows at your side and touching the ground to avoid your opponent from moving up on your chest. Pick a side to push off of.  Use both hands and push a leg while hip escaping to the opposite side.  If the opponent is not placing all of their weight on that side you make space on the leg you pushed off of.  With this new space under his leg pull up your knee and get a foot hook under his leg.  Grab your opponents heel on the same side\\n\\nOn the opposite side underhook his other leg.  Your objective is to create a situation where you are under your opponent.  Like a deep half guard scenario.   \\n\\nWith your opponent's total weight on top of you kick out with your free leg.  Use that momentum like a pendulum.  Sweep your opponent to his back and do a tactical stand-up.        ",
                "Y", "12/11/2017 16:45"));

        doses.add(new Dose("3", "", "This is a test dose to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30"));

        doses.add(new Dose("4", "", "elit. Morbi st dose to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30"));
        doses.add(new Dose("5", "", "This is √ to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30"));
        doses.add(new Dose("6", "", "This is a test dose to see √lds are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30"));
        doses.add(new Dose("7", "", "√vcxbxvcb is a test dose to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30"));
    }

    public void resetLookups() {
        lookups.clear();
    }

    public void resetDoses() {
        doses.clear();
    }

}
