package org.example;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    static void main() throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();


        for (int i = 0 ; i < n; i++) {
            System.out.println("Product #" + (i+1) + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Customs fee: ");
                Double customs = sc.nextDouble();
                list.add(i ,new ImportedProduct(name, price, customs));
            } else if(ch == 'c') {
                list.add(i, new Product(name, price));
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.next();
                Date manufacture = sdf.parse(date);
                list.add(i, new UsedProduct(name, price, manufacture));
            }

        }

        System.out.println("\nPRICE TAGS: ");
        for (Product p : list) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
