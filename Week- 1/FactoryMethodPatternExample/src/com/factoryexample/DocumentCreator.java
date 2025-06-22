package com.factoryexample;

public class DocumentCreator {
    public static void main(String[] args) {
        System.out.println("--- Creating Word Document ---");
        DocumentFactory wordFactory = new WordDocumentFactory();
        wordFactory.processDocument(); 

        System.out.println("--- Creating PDF Document ---");
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        pdfFactory.processDocument();

        System.out.println("--- Creating Excel Document ---");
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        excelFactory.processDocument();

        
        System.out.println("--- Creating another PDF (direct factory method call) ---");
        Document anotherPdf = pdfFactory.createDocument();
        anotherPdf.open();
        anotherPdf.close();
    }
}