package com.ecommerce; 

import java.util.Arrays;
import java.util.Comparator;

public class ProductSearcher {

   
    public static Product linearSearch(Product[] products, String targetProductId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId().equals(targetProductId)) {
                return products[i];
            }
        }
        return null;
    }

    
    public static Product binarySearch(Product[] products, String targetProductId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparisonResult = products[mid].getProductId().compareTo(targetProductId);

            if (comparisonResult == 0) {
                return products[mid];
            } else if (comparisonResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    
    public static void sortProductsById(Product[] products) {
       
        Arrays.sort(products, Comparator.comparing(Product::getProductId));
    }


    
    public static void main(String[] args) {
        
        Product p1 = new Product("A001", "Laptop", "Electronics", 1200.00);
        Product p2 = new Product("B005", "Mouse", "Electronics", 25.00);
        Product p3 = new Product("C010", "Keyboard", "Electronics", 75.00);
        Product p4 = new Product("D002", "Monitor", "Electronics", 300.00);
        Product p5 = new Product("E007", "Desk Chair", "Furniture", 150.00);
        Product p6 = new Product("F012", "Bookshelf", "Furniture", 90.00);
        Product p7 = new Product("G003", "Coffee Maker", "Appliances", 80.00);
        Product p8 = new Product("H011", "Blender", "Appliances", 50.00);
        Product p9 = new Product("I009", "Smartphone", "Electronics", 800.00);
        Product p10 = new Product("J004", "Headphones", "Electronics", 100.00);

        
        Product[] productsUnsorted = {p1, p9, p5, p3, p7, p2, p10, p4, p8, p6};
        System.out.println("--- Linear Search ---");
        String targetLinear = "C010";
        long startTime = System.nanoTime();
        Product foundLinear = linearSearch(productsUnsorted, targetLinear);
        long endTime = System.nanoTime();
        System.out.println("Searching for ID: " + targetLinear);
        System.out.println("Found: " + (foundLinear != null ? foundLinear : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        targetLinear = "Z999"; 
        startTime = System.nanoTime();
        foundLinear = linearSearch(productsUnsorted, targetLinear);
        endTime = System.nanoTime();
        System.out.println("\nSearching for ID: " + targetLinear);
        System.out.println("Found: " + (foundLinear != null ? foundLinear : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");


        
        Product[] productsForBinarySearch = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10}; 
        System.out.println("\n--- Sorting Products for Binary Search ---");
        sortProductsById(productsForBinarySearch); 
        System.out.println("Products sorted by ID.");
        


        System.out.println("\n--- Binary Search ---");
        String targetBinary = "G003";
        startTime = System.nanoTime();
        Product foundBinary = binarySearch(productsForBinarySearch, targetBinary);
        endTime = System.nanoTime();
        System.out.println("Searching for ID: " + targetBinary);
        System.out.println("Found: " + (foundBinary != null ? foundBinary : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");

        targetBinary = "Z999"; 
        startTime = System.nanoTime();
        foundBinary = binarySearch(productsForBinarySearch, targetBinary);
        endTime = System.nanoTime();
        System.out.println("\nSearching for ID: " + targetBinary);
        System.out.println("Found: " + (foundBinary != null ? foundBinary : "Not Found"));
        System.out.println("Time taken: " + (endTime - startTime) + " ns");
    }
}