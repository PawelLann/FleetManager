package com.fleet.manager.persistence.entity;

import lombok.Getter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by pawel.langwerski@gmail.pl on 06.09.17.
 */
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