package com.beoatch.spring_boot_rest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "people")
public class Human {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "sex")
    private String sex;

    @Column(name = "residence")
    private String residence;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "docs_id")
    private Doc doc;

    public Human() {
    }

    public Human(String surname, String name, String patronymic, Date dateOfBirth, String sex, String residence, Doc doc) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.residence = residence;
        this.doc = doc;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", residence='" + residence + '\'' +
                '}';
    }
}
