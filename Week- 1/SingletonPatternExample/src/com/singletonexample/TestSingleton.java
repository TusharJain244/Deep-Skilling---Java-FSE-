package com.singletonexample;

import com.singletonexample.Logger; 

public class TestSingleton {
    public static void main(String[] args) {
        
        System.out.println("Attempting to get logger1...");
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        
        System.out.println("\nAttempting to get logger2...");
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");

    
        System.out.println("\nAttempting to get logger3...");
        Logger logger3 = Logger.getInstance();
        logger3.log("This is the third log message.");

        
        System.out.println("\n--- Verifying Instances ---");
        System.out.println("logger1 == logger2: " + (logger1 == logger2));
        System.out.println("logger1 == logger3: " + (logger1 == logger3));
        System.out.println("logger2 == logger3: " + (logger2 == logger3));

        System.out.println("\nHash Code of logger1: " + logger1.hashCode());
        System.out.println("Hash Code of logger2: " + logger2.hashCode());
        System.out.println("Hash Code of logger3: " + logger3.hashCode());
    }
}
