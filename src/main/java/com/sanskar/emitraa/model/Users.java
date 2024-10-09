package com.sanskar.emitraa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "farmers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String phoneno;
    @Column(unique = true)
    private String username;
    private String adhaarno;
    private String name;
    private String address;
    private String state;
    private String district;
    private String pincode;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "farmers_roles",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),inverseJoinColumns =  @JoinColumn(name = "role_id",referencedColumnName = "id") )
    Set<Role> roles;
}
