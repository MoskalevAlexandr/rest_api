package com.beoatch.spring_boot_rest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "docs")
public class Doc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "number")
    private int number;

    @Column(name = "type")
    private String type;

    @Column(name = "name_of_issuing_authority")
    private String nameOfIssuingAuthority;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_issuing")
    private Date dateOfIssuing;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "date_of_expiry")
    private Date dateOfExpiry;

    public Doc() {
    }

    public Doc(int number, String type, String nameOfIssuingAuthority, Date dateOfIssuing, Date dateOfExpiry) {
        this.number = number;
        this.type = type;
        this.nameOfIssuingAuthority = nameOfIssuingAuthority;
        this.dateOfIssuing = dateOfIssuing;
        this.dateOfExpiry = dateOfExpiry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameOfIssuingAuthority() {
        return nameOfIssuingAuthority;
    }

    public void setNameOfIssuingAuthority(String nameOfIssuingAuthority) {
        this.nameOfIssuingAuthority = nameOfIssuingAuthority;
    }

    public Date getDateOfIssuing() {
        return dateOfIssuing;
    }

    public void setDateOfIssuing(Date dateOfIssuing) {
        this.dateOfIssuing = dateOfIssuing;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "id=" + id +
                ", number=" + number +
                ", type='" + type + '\'' +
                ", nameOfIssuingAuthority='" + nameOfIssuingAuthority + '\'' +
                ", dateOfIssuing=" + dateOfIssuing +
                ", dateOfExpiry=" + dateOfExpiry +
                '}';
    }
}