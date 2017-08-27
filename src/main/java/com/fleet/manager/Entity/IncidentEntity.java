package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Getter
@Setter
@Entity
public class IncidentEntity extends AbstractEntity {

    private String name;
    @Lob
    private String description;
    private String date;
}
