package com.pl;

import com.pl.service.ISchedulable;
import com.pl.service.User;
import com.pl.service.impl.Doctor;
import com.pl.service.impl.Patient;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        //Clase anónima
        User user = new User("Ana", "ana@mail.co") {
            // método abstracto, le doy el comportamiento que va a tener este objeto
            // Es temporal
            @Override
            public void showDataUser() {
                System.out.println("Doctor");
                System.out.println("Hospital: Cruz Azul");
                System.out.println("Departamento: Geriatría");
            }
        };

        user.showDataUser();

        // Clases anónimas
        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {

            }
        };


        Doctor myDoctor = new Doctor("Carlota", "carlo@mail.co");
        myDoctor.getName();

        Doctor myDoctor1 = new Doctor("Camilo", "cami@mail.co");
        myDoctor1.addAvailableAppointment(new Date(), "4pm");
        myDoctor1.addAvailableAppointment(new Date(), "10am");
        myDoctor1.addAvailableAppointment(new Date(), "1pm");
        System.out.println(myDoctor1.getAvailableAppointments());

        for (Doctor.AvailableAppointment availableAppointment : myDoctor1.getAvailableAppointments()) {
            System.out.println(availableAppointment);
        }
        

        // Método estático Doctor.suma(9, 8);
        // Variable estática Double pi = Doctor.PI;

        Doctor myDoctor2 = new Doctor("Mica", "mica@mail.co");

        Doctor myDoctor3 = new Doctor("Amauri", "amauri@mail.co");
        System.out.println(myDoctor3);

        Patient patient = new Patient("Mica", "mica@mail.co");
        patient.setWeight(33.0);
        System.out.println(patient.getWeight());
        System.out.println(patient);

    }
}
