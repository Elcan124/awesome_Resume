/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utility;

import java.util.Scanner;

public class Util {

    public static String requireText(String text){
        Scanner sc =  new Scanner(System.in);
        System.out.println(text+": ");
        String result =  sc.nextLine();

        return result;

    }
}
