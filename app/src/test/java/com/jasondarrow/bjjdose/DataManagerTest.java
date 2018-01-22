package com.jasondarrow.bjjdose;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by darrowj on 1/13/18.
 */
public class DataManagerTest {
    static DataManager dm;

    @BeforeClass
    public static void classSetUp() throws Exception {
        dm = DataManager.getInstance();
    }

    @Before
    public void setup() throws Exception {
        dm.resetLookups();
        dm.resetDoses();
        dm.initLookups();
        dm.initDoses();
    }

    @Test
    public void getLookups() throws Exception {
        int numberOfLookups = dm.getLookups().size();
        assertEquals(numberOfLookups, 7);
    }

    @Test
    public void getDoses() throws Exception {
        int numberOfDoses = dm.getDoses().size();
        assertEquals(numberOfDoses, 3);
    }


    @Test
    public void createNewDose() throws Exception {
        List<Dose> doses = dm.getDoses();
        long beginSize = doses.size() - 1;
        Dose dose = new Dose(null, null, null, null);
        doses.add(dose);
        long afterSize = doses.size() - 1;
        assertTrue(beginSize < afterSize);
    }

    @Test
    public void removeDose() throws Exception {
        List<Dose> doses = dm.getDoses();
        long beginSize = doses.size() - 1;
        dm.removeDose(0);
        long afterSize = doses.size() - 1;
        assertTrue(beginSize > afterSize);
    }

}