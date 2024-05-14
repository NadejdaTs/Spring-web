package com.plannerapp.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User extends BaseEntity{
    @Column(nullable = false, unique = true)
    @Length(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
//    @Length(min = 3, max = 20) don`t do this here!
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "assignee")
    private Set<Task> tasks;
}
