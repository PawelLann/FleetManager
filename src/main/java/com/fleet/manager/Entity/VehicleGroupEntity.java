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
import java.util.Collection;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "VEHICLE_GROUPS")
public class VehicleGroupEntity extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 30)
  private String name;
  private VehicleType vehicleType;

  private Collection<VehicleGroupEntity> vehicleGroupEntities = new ArrayList<>();

  @OneToMany
  @JoinColumn(name = "ID_PROJECT_GROUP")
  private Set<VehicleEntity> vehicleEntitySet = Sets.newHashSet();
}