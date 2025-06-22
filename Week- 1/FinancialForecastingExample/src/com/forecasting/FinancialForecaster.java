package com.forecasting; 

public class FinancialForecaster {

 
    public static double calculateFutureValueRecursive(double presentValue, double growthRate, int years) {
       
        if (years == 0) {
            return presentValue;
        }
      
        if (years < 0) {
            throw new IllegalArgumentException("Years cannot be negative for future value calculation.");
        }

        
        double previousYearFutureValue = calculateFutureValueRecursive(presentValue, growthRate, years - 1);
        return previousYearFutureValue * (1 + growthRate);
    }

    
    public static void main(String[] args) {
        double initialInvestment = 1000.0; 
        double annualGrowthRate = 0.05;    
        int forecastYears = 10;            

        System.out.println("--- Financial Forecasting using Recursion ---");
        System.out.println("Initial Investment: $" + String.format("%.2f", initialInvestment));
        System.out.println("Annual Growth Rate: " + (annualGrowthRate * 100) + "%");
        System.out.println("Forecast Years: " + forecastYears);

        long startTime = System.nanoTime();
        double futureValue = calculateFutureValueRecursive(initialInvestment, annualGrowthRate, forecastYears);
        long endTime = System.nanoTime();

        System.out.println("\nFuture Value after " + forecastYears + " years: $" + String.format("%.2f", futureValue));
        System.out.println("Time taken for recursive calculation: " + (endTime - startTime) + " ns");

        
        System.out.println("\nFuture Value after 0 years: $" + String.format("%.2f", calculateFutureValueRecursive(1000, 0.05, 0)));

        
        int largeYears = 50;
        System.out.println("\nFuture Value after " + largeYears + " years: $" + String.format("%.2f", calculateFutureValueRecursive(initialInvestment, annualGrowthRate, largeYears)));

        
        System.out.println("\n--- Financial Forecasting using Iteration (for comparison) ---");
        startTime = System.nanoTime();
        double iterativeFutureValue = initialInvestment;
        for (int i = 0; i < forecastYears; i++) {
            iterativeFutureValue *= (1 + annualGrowthRate);
        }
        endTime = System.nanoTime();
        System.out.println("Future Value after " + forecastYears + " years (Iterative): $" + String.format("%.2f", iterativeFutureValue));
        System.out.println("Time taken for iterative calculation: " + (endTime - startTime) + " ns");

        
        System.out.println("\n--- Financial Forecasting using Direct Formula (most optimal) ---");
        startTime = System.nanoTime();
        double directFutureValue = initialInvestment * Math.pow((1 + annualGrowthRate), forecastYears);
        endTime = System.nanoTime();
        System.out.println("Future Value after " + forecastYears + " years (Direct Formula): $" + String.format("%.2f", directFutureValue));
        System.out.println("Time taken for direct formula calculation: " + (endTime - startTime) + " ns");

        
        try {
            System.out.println("\nTrying with negative years:");
            calculateFutureValueRecursive(1000, 0.05, -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}