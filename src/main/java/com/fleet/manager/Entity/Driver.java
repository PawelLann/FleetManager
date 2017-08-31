package com.fleet.manager.Entity;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

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

  @ManyToMany
  @JoinTable(
      name = "DRIVER_VEHICLE",
      joinColumns = @JoinColumn(name = "ID_DRIVER"),
      inverseJoinColumns = @JoinColumn(name = "ID_VEHICLE"))
  private Set<Vehicle> vehicleSet = Sets.newHashSet();
}
