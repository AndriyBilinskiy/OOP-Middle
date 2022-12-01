package com.midterm.demo.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table
public class CompanyInfo {
    @Id @GeneratedValue @JsonIgnore
    private int id;
    private String name;
    @Column(unique = true)
    private String twitter;
    private String facebook;
    private String logo;
    private String icon;
    private String employees;
    private String address;

}
