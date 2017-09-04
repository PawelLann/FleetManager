package com.fleet.manager.Entity;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "VEHICLE_GROUPS")
public class VehicleGroup extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 30)
  private String name;

  @Lob
  @Column(length = 10000)
  private String description;

  @OneToMany
  @JoinColumn(name = "ID_PROJECT_GROUP")
  private Set<Vehicle> vehicleSet = Sets.newHashSet();
}