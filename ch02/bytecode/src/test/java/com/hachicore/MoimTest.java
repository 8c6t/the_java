package com.hachicore;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class MoimTest {

    @Test
    public void isFull() {
        Moim moim = new Moim();
        moim.maxNumberOfAttendees = 100;
        moim.numberOfEnrollment = 10;

        assertFalse(moim.isEnrollmentFull());
    }

}