package com.dm04.dm04.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.RequestParam;


@Entity
public class DiabatiesModel {


    @Id
    @GeneratedValue
    private int id;
    private int pregnancies, glucose,blood_pressure,skin_thickness,insulin,bmi,diabetes_pedigree,age,userid;
    private String result;

    public int getPregnancies() {
        return pregnancies;
    }

    public void setPregnancies(int pregnancies) {
        this.pregnancies = pregnancies;
    }

    public int getGlucose() {
        return glucose;
    }

    public void setGlucose(int glucose) {
        this.glucose = glucose;
    }

    public int getSkin_thickness() {
        return skin_thickness;
    }

    public void setSkin_thickness(int skin_thickness) {
        this.skin_thickness = skin_thickness;
    }

    public int getInsulin() {
        return insulin;
    }

    public void setInsulin(int insulin) {
        this.insulin = insulin;
    }

    public int getDiabetes_pedigree() {
        return diabetes_pedigree;
    }

    public void setDiabetes_pedigree(int diabetes_pedigree) {
        this.diabetes_pedigree = diabetes_pedigree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getBlood_pressure() {
        return blood_pressure;
    }

    public void setBlood_pressure(int blood_pressure) {
        this.blood_pressure = blood_pressure;
    }

    public int getBmi() {
        return bmi;
    }

    public void setBmi(int bmi) {
        this.bmi = bmi;
    }

    




    
}
