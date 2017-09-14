package com.fleet.manager.persistence.entity;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by pawel.langwerski@gmail.pl on 06.09.17.
 */
@Getter
@Setter
@Entity
@Table(name = "DRIVERS")
public class Driver extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 30)
  private String firstName;
  @NotEmpty
  @Column(nullable = false, length = 30)
  private String lastName;
  @NotEmpty
  @Email
  @Column(nullable = false, length = 30)
  private String email;

  @ManyToMany(mappedBy = "drivers")
  private Set<Vehicle> vehicles = Sets.newHashSet();
  @ManyToMany(mappedBy = "drivers")
  private Set<Incident> incidents = Sets.newHashSet();

  public void removeVehicle(Vehicle vehicle) {
    vehicles.remove(vehicle);
  }

  public void removeIncident(Incident incident) {
    incidents.remove(incident);
  }

  public void addVehicle(Vehicle vehicle) {
    vehicles.add(vehicle);
  }

}
