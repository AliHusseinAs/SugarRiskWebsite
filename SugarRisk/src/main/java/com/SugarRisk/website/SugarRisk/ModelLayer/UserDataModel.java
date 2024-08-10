package com.SugarRisk.website.SugarRisk.ModelLayer;

import jakarta.persistence.*;
import org.hibernate.annotations.CollectionId;

@Entity
@Table(name="userData")
public class UserDataModel {
    @Id
    @Column(name="ID")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "age")
    private int age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "waist")
    private float waist;
    @Column(name = "Body_Mass")
    private float bodyMass;
    @Column(name = "activity")
    private String activity;
    @Column(name = "AntiHyperTensive")
    private String antiHybertensive;
    @Column(name = "Blood_Glucose")
    private String bloodGlucose;
    @Column(name = "relativeDiabetes")
    private int relativeDiabetes;
    @Column(name = "EatingHealthy")
    private int eating;


    public UserDataModel() {}

    public UserDataModel(long id, String name, String surname, int age, String sex, float waist, float bodyMass, String activity, String antiHybertensive, String bloodGlucose, int relativeDiabetes, int eating) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.waist = waist;
        this.bodyMass = bodyMass;
        this.activity = activity;
        this.antiHybertensive = antiHybertensive;
        this.bloodGlucose = bloodGlucose;
        this.relativeDiabetes = relativeDiabetes;
        this.eating = eating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getBodyMass() {
        return bodyMass;
    }

    public void setBodyMass(float bodyMass) {
        this.bodyMass = bodyMass;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getAntiHybertensive() {
        return antiHybertensive;
    }

    public void setAntiHybertensive(String antiHybertensive) {
        this.antiHybertensive = antiHybertensive;
    }

    public String getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(String bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public int getRelativeDiabetes() {
        return relativeDiabetes;
    }

    public void setRelativeDiabetes(int relativeDiabetes) {
        this.relativeDiabetes = relativeDiabetes;
    }

    public int getEating() {
        return eating;
    }

    public void setEating(int eating) {
        this.eating = eating;
    }
}