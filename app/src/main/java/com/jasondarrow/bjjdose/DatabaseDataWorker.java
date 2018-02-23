package com.jasondarrow.bjjdose;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;


public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertDoses() {
        insertDose("1", "123", "Butterfly guard grip offence on biceps.  ",
                "Drill", "Defending", "Top", "", "", "Butterfly", "",
                "Engage opponent square to you.  Once they grab your pant leg you defend.  Place both hands on the opponents biceps.  As they try and take an angle on you counter with a push pull strategy.  Push against the bicep of the direction they are going in.  Grip and pull on the tricep of the trailing arm.  This will cause the opponent to lose balance or posture.  If possible get a hook under a knee and sweep the opponent to the side they are turn into.    ",
                "Y", "12/10/2017 18:48");

        insertDose("2", "123", "Waiter Like Sweep When Mounted",
                "Sweep", "Defending", "Bottom", "", "", "", "Waiter",
                "This is a mount escape scenario.  With Elbows at your side and touching the ground to avoid your opponent from moving up on your chest. Pick a side to push off of.  Use both hands and push a leg while hip escaping to the opposite side.  If the opponent is not placing all of their weight on that side you make space on the leg you pushed off of.  With this new space under his leg pull up your knee and get a foot hook under his leg.  Grab your opponents heel on the same side\\n\\nOn the opposite side underhook his other leg.  Your objective is to create a situation where you are under your opponent.  Like a deep half guard scenario.   \\n\\nWith your opponent's total weight on top of you kick out with your free leg.  Use that momentum like a pendulum.  Sweep your opponent to his back and do a tactical stand-up.        ",
                "Y", "12/11/2017 16:45");

        insertDose("3", "123", "This is a test dose to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30");

        insertDose("4", "123", "elit. Morbi st dose to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30");
        insertDose("5", "123", "This is √ to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30");
        insertDose("6", "123", "This is a test dose to see √lds are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30");
        insertDose("7", "123", "√vcxbxvcb is a test dose to see if all fields are populated",
                "Sweep", "Defending", "Bottom", "Back Control", "Americana", "Reverse De La Riva", "Lasso",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi nec scelerisque leo. Sed tortor eros, lobortis vel viverra sit amet, feugiat at dui. Fusce id ipsum eu dolor aliquam malesuada. Nulla molestie orci vel metus sodales vehicula. Maecenas pulvinar nunc a gravida rutrum. Morbi sodales dui at ex ullamcorper, id fringilla ligula commodo. Nam posuere mauris in nunc molestie, eu tristique sem sodales. Donec feugiat nunc eget tortor consequat scelerisque. Aenean nisi nunc, porttitor in blandit et, aliquet quis odio.",
                "Y", "12/131/2017 15:30");
    }

    public void insertLookup() {
        insertLookup("1", "category","Transition,Sweep,Submission,Drill,Pass,Escape,Takedown");
        insertLookup("2", "engagement","Attacking,Defending");
        insertLookup("3", "startPosture","Bottom,Scramble,Standing,Top");
        insertLookup("4", "offensivePosition","50-50,Back Control,Full Mount,Knee on Belly,North - South,Side Control,S-Mount,Turtle Top");
        insertLookup("5", "guard","50-50,Butterfly,Closed Guard,Deep Half Guard,De La Riva,Half Guard,Open Guard,Spider Guard,Inverted Guard,Quarter Guard,Reverse De La Riva,Turtle Guard,Tornado Guard,X-Guard");
        insertLookup("6", "sweep","Butterfly,Elevator Hook,Flower,Half Guard,Hip Bump,LumberJack,Lasso,Sickle,Scissor,Waiter");
        insertLookup("7", "submission","Americana,Ankle Lock,Arm Triangle,Armbar" +
                        "Banana Split,Bicep Cutter,Bow & Arrow,Brabo Choke" +
                        "Bulldog Choke,Calf Cutter,Clock Choke,Collar Choke" +
                        "Cutter Choke,Estima Lock,Ezekiel Choke,Gogoplata,Guillotine" +
                        "Headlock,Heel Hook,Kimura,Kneebar,Lapel Choke,Loop Choke" +
                        "North-South Choke,Omoplata,Pressure,Rear Naked Choke" +
                        "Shoulder Lock,Smother,Toe Hold,Triangle,Twister" +
                        "Wrist Lock");
    }

    private void insertDose(String id, String uid, String title, String category, String engagement,
                            String posture, String offensivePosition, String submission,
                            String guard, String sweep, String description, String published,
                            String created) {
        ContentValues values = new ContentValues();
        values.put(BjjDoseDOA.DoseEntity.COLUMN_ID, id);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_UID, uid);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_TITLE, title);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_CATEGORY, category);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_ENGAGEMENT, engagement);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_POSTURE, posture);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_OFFENSIVEPOSITION, offensivePosition);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_SUBMISSION, submission);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_GUARD, guard);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_SWEEP, sweep);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_DESCRIPTION, description);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_PUBLISHED, published);
        values.put(BjjDoseDOA.DoseEntity.COLUMN_CREATED, created);


        long newRowId = mDb.insert(BjjDoseDOA.DoseEntity.TABLE_NAME, null, values);


    }

     private void insertLookup(String id, String title, String options) {
        ContentValues values = new ContentValues();
        values.put(BjjDoseDOA.LookupEntity.COLUMN_ID, id);
        values.put(BjjDoseDOA.LookupEntity.COLUMN_TITLE, title);
        values.put(BjjDoseDOA.LookupEntity.COLUMN_NAMES, options);

        long newRowId = mDb.insert(BjjDoseDOA.LookupEntity.TABLE_NAME, null, values);
    }

}
