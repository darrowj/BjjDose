package com.jasondarrow.bjjdose;

import android.provider.BaseColumns;

/**
 * Created by darrowj on 2/11/18.
 */

public final class BjjDoseDOA {
    private  BjjDoseDOA() {

    }

    public static final class DoseEntity implements BaseColumns {
        public static final String TABLE_NAME = "dose";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_CATEGORY = "Category";
        public static final String COLUMN_ENGAGEMENT = "engagement";
        public static final String COLUMN_POSTURE = "posture";
        public static final String COLUMN_OFFENSIVEPOSITION = "offensivePosition";
        public static final String COLUMN_SUBMISSION = "submission";
        public static final String COLUMN_GUARD = "guard";
        public static final String COLUMN_SWEEP = "sweep";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_PUBLISHED = "published";
        public static final String COLUMN_CREATED = "created";
        public static final String COLUMN_UPDATED = "updated";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_ID + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_UID + " TEXT NOT NULL, " +
                        COLUMN_TITLE + " TEXT NOT NULL, " +
                        COLUMN_CATEGORY + " TEXT, " +
                        COLUMN_ENGAGEMENT + " TEXT, " +
                        COLUMN_POSTURE + " TEXT, " +
                        COLUMN_OFFENSIVEPOSITION + " TEXT, " +
                        COLUMN_SUBMISSION + " TEXT, " +
                        COLUMN_GUARD + " TEXT, " +
                        COLUMN_SWEEP + " TEXT, " +
                        COLUMN_DESCRIPTION + " TEXT, " +
                        COLUMN_PUBLISHED + " TEXT, " +
                        COLUMN_CREATED + " TEXT, " +
                        COLUMN_UPDATED + " TEXT) ";

    }

    public static final class LookupEntity implements BaseColumns {
        public static final String TABLE_NAME = "lookup";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_NAMES = "names";

        public static final String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_ID + " TEXT UNIQUE NOT NULL, " +
                        COLUMN_TITLE + " TEXT NOT NULL, " +
                        COLUMN_NAMES + " TEXT) ";
    }


}
