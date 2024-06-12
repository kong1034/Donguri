package com.donguri.sign;

import java.security.SecureRandom;
import java.util.Base64;

public class KeyGenerator {
	
	 public static String generateSecretKey() {
	        byte[] key = new byte[32]; // 256 bits
	        SecureRandom random = new SecureRandom();
	        random.nextBytes(key);
	        return Base64.getEncoder().encodeToString(key);
	    }
	 
	  public static void main(String[] args) {
	        String secretKey = generateSecretKey();
	        System.out.println("Generated Secret Key: " + secretKey);
	        
	        // Note: In a real application, you should securely store this key in an environment variable or a secure vault.
	    }
	 
	}
