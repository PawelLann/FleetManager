package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
public class DriverEntity extends AbstractEntity {

    private String name;
    private String surname;
}
