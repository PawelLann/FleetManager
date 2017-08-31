package com.fleet.manager.Entity;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "VEHICLE_GROUPS")
public class VehicleGroup extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 30)
  private String name;
  private VehicleType vehicleType;

  private List<VehicleGroup> vehicleGroupEntities = new ArrayList<>();

  @OneToMany
  @JoinColumn(name = "ID_PROJECT_GROUP")
  private Set<Vehicle> vehicleSet = Sets.newHashSet();
}