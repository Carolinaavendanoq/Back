package com.pl.service.impl;

import com.pl.service.User;

public class Nurse extends User {
    private String specialization;

    public Nurse(String name, String email) {
        super(name, email);
    }

    @Override
    public void showDataUser() {
        System.out.println("Empleado del Hospital: cruz Verde");
        System.out.println("Departamentos: nutriología, pediatría");
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
