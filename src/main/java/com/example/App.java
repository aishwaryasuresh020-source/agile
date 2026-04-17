package com.example;

import java.util.Random;

public class App {

    private String generatedOTP;

    // Generate OTP
    public String generateOTP() {
        Random rand = new Random();
        int otp = 1000 + rand.nextInt(9000); // 4-digit OTP
        generatedOTP = String.valueOf(otp);
        return generatedOTP;
    }

    // Validate OTP
    public boolean validateOTP(String inputOTP) {
        return generatedOTP != null && generatedOTP.equals(inputOTP);
    }

    // Reset password
    public boolean resetPassword(String inputOTP, String newPassword) {

        // Password rule: at least 6 characters
        if (newPassword == null || newPassword.length() < 6) {
            return false;
        }

        // OTP must be valid
        if (!validateOTP(inputOTP)) {
            return false;
        }

        return true; // reset success
    }

    public static void main(String[] args) {
        App app = new App();

        String otp = app.generateOTP();
        System.out.println("Generated OTP: " + otp);

        boolean result = app.resetPassword(otp, "newpass123");

        if (result) {
            System.out.println("Password Reset Successful");
        } else {
            System.out.println("Password Reset Failed");
        }
    }
}
