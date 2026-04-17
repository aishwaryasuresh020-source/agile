package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testSuccessfulReset() {
        App app = new App();
        String otp = app.generateOTP();

        assertTrue(app.resetPassword(otp, "secure123"));
    }

    @Test
    public void testInvalidOTP() {
        App app = new App();
        app.generateOTP();

        assertFalse(app.resetPassword("0000", "secure123"));
    }

    @Test
    public void testWeakPassword() {
        App app = new App();
        String otp = app.generateOTP();

        assertFalse(app.resetPassword(otp, "123"));
    }
}
