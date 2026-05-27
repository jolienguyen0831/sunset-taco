package com.pluralsight.data;

import com.pluralsight.models.Order;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {
    private final String fileName;

    public ReceiptWriter( String fileName) {
        this.fileName = generateFileName();
    }
    public String generateFileName() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return LocalDateTime.now().format(formatter)+ ".txt";
    }

    public String getFileName() {
        return fileName;
    }
    public void writeReceipt(Order order){
        File receiptFolder = new File("receipts");
        if (!receiptFolder.exists()){
            receiptFolder.mkdir();
        }
        File receiptFile = new File(receiptFolder,fileName);
        try {
            FileWriter fileWriter = new FileWriter(receiptFile);
            BufferedWriter writer = new BufferedWriter(fileWriter);

            writer.write("SUNSET TACO Receipt");
            writer.newLine();
            writer.newLine();
            writer.newLine();
            writer.write(order.getOrderSummary());
            writer.newLine();
            writer.write("Thank you for your order!");
            writer.close();

            System.out.println("Receipt saved successfully.");
            System.out.println("File name: " + fileName);

        } catch (IOException e) {
            System.out.println("Error saving receipt.");
        }

    }

}
