package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "INCIDENTS")
public class IncidentEntity extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 30)
  private String name;
  @Lob
  @Column(nullable = false, length = 10000)
  private String description;
  @Column(name = "INCIDENT_DATE_TIME", nullable = false)
  @DateTimeFormat
  private LocalDateTime date;
}