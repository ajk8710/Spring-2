package com.synex;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Run this program as java application, to create hashed password, to save manually in DB.
public class PasswordHash {
    
    public static void main(String []args) {
        testBCryptHash();
    }
    
    public static void testBCryptHash() {
        String password = "password";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
    }

}
