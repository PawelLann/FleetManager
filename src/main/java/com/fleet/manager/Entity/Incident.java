package com.fleet.manager.Entity;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "INCIDENTS")
public class Incident extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 30)
  private String name;
  @Lob
  @Column(nullable = false, length = 10000)
  private String description;
  @Column(name = "INCIDENT_DATE_TIME", nullable = false)
  @DateTimeFormat
  private LocalDateTime date;
  @OneToMany
  List<Driver> driverList = new ArrayList<>();

  @ManyToMany
  @JoinTable(name = "VEHICLE_INCIDENT",
          joinColumns = @JoinColumn(name = "ID_VEHICLE"),
          inverseJoinColumns = @JoinColumn(name = "ID_INCIDENT"))
  private Set<Incident> vehiclesSet = Sets.newHashSet();
}