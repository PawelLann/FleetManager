package com.fleet.manager.entity;

import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@Getter
@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue
  private Long id;

  @NotEmpty
  @GeneratedValue
  @Column(nullable = false, length = 30)
  private Date createDate;

  @NotEmpty
  @Column(nullable = false, length = 30)
  private Date modifyDate;
}