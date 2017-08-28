package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class AbstractEntity{
    @Id
    private Long id;
}
