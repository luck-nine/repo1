package org.ccut.shop.util;

import java.util.Scanner;

public class ScannerUtil {
    public static Scanner scanner = new Scanner(System.in);
    public static int getScannerInt(){
        return scanner.nextInt();
    }
    public static double getScannerDouble(){
        return scanner.nextDouble();
    }
    public static String getScannerString(){
        return scanner.next();
    }
}
