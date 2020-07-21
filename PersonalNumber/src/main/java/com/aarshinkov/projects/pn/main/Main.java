package com.aarshinkov.projects.pn.main;

import com.aarshinkov.projects.pn.PersonalNumber;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Въведете ЕГН: ");
        String personalNumber = scanner.nextLine();

        try {
            PersonalNumber pn = new PersonalNumber(personalNumber);
            pn.printInformation();
        } catch (Exception e) {
            System.out.println("Грешка: " + e.getLocalizedMessage());
        }
    }
}
