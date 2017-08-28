package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter

public class VehicleGroupEntity extends AbstractEntity {

    private String name;
    private VehicleType vehicleType;

    private Collection<VehicleGroupEntity> vehicleGroupEntities = new ArrayList<>();
}
