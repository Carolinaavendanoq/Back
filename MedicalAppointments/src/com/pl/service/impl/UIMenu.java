package com.pl.service.impl;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;
    public static void showMenu(){
        System.out.println("Welcome to my appointments");
        System.out.println("Selecciona la opción deseada:");

        int response;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("3. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    // showPatientMenu();
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    private static void authUser(int userType){
        // UserType = 1 Doctor
        // UserType = 2 Patient
        ArrayList<Doctor> doctors =  new ArrayList<>();
        doctors.add(new Doctor( "Alejandro Martínez", "ale@mail.co"));
        doctors.add(new Doctor( "Alejandro Copers", "aleco@mail.co"));
        doctors.add(new Doctor( "Alejandro Balenciaga", "aleba@mail.co"));

        ArrayList<Patient> patients =  new ArrayList<>();
        patients.add(new Patient( "Ale Martínez", "alem@mail.co"));
        patients.add(new Patient( "Ale Copers", "alecop@mail.co"));
        patients.add(new Patient( "Aleja Balenciaga", "alebale@mail.co"));

        boolean emailCorrect = false;
        do {
            System.out.println("Insert your email: [aA@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();
            if (userType == 1){
                for (Doctor d : doctors){
                    if(d.getEmail().equals(email)){
                        emailCorrect = true;
                        // Obtener el usuario loggeado
                        doctorLogged = d;
                        // showDoctorMenu
                    }
                }
            }

            if (userType == 2){
                for (Patient p: patients){
                    if (p.getEmail().equals(email)){
                        emailCorrect= true;
                        patientLogged = p;
                    }
                }
            }
        }while (!emailCorrect);
    }
    private static void showPatientMenu() {
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println(":: Book an appointment");
                    for (int i = 0; i < 4; i++) {
                        System.out.println(i + ". " + MONTHS[i]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }
}
