package org.example;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void readAllProducts(String connect) {
        List<Product> products= ProductDAO.getInstance(connect).readAll();
        for (Product product : products) {
            System.out.println(product.toString());
        }
        System.out.println();
    }

    public static void readAProductById(String connect) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id: ");
        int id = scanner.nextInt();
        Product product = ProductDAO.getInstance(connect).read(id);

        if (product != null) {
            System.out.println(product.toString());
        } else {
            System.out.println("San pham nay khong ton tai");
        }
        System.out.println();
    }

    public static void addANewProduct(String connect) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san pham: ");
        String name = scanner.nextLine();
        System.out.print("Nhap gia tien: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap mau sac cua san pham: ");
        String color = scanner.nextLine();

        ProductDAO.getInstance(connect).add(new Product(name, price, color));
        System.out.println("Them san pham thanh cong");
        System.out.println();
    }

    public static void updateAProduct(String connect) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id san pham can chinh sua: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap ten san pham: ");
        String name = scanner.nextLine();
        System.out.print("Nhap gia tien: ");
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhap mau sac: ");
        String color = scanner.nextLine();

        ProductDAO.getInstance(connect).update(new Product(id, name, price, color));
        System.out.println("Chinh sua thanh cong");
        System.out.println();
    }

    public static void deleteAProductById(String connect) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap id san pham muon xoa: ");
        int id = scanner.nextInt();

        ProductDAO.getInstance(connect).delete(id);
        System.out.println("Xoa san pham thanh cong!");
        System.out.println();
    }

    public static void menu(String connect) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. In danh sach san pham");
            System.out.println("2. In san pham theo id");
            System.out.println("3. Them san pham moi");
            System.out.println("4. Sua thong tin san pham");
            System.out.println("5. Xoa san pham theo id");
            System.out.println("6. Thoat\n");

            System.out.print("Lua chon cua ban: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    readAllProducts(connect);
                    break;
                case 2:
                    readAProductById(connect);
                    break;
                case 3:
                    addANewProduct(connect);
                    break;
                case 4:
                    updateAProduct(connect);
                    break;
                case 5:
                    deleteAProductById(connect);
                    break;
                case 6:
                    return;
            }
        }
    }

    public static void main(String[] args) {
        menu(args[0]);
    }
}

