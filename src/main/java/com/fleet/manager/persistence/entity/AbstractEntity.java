package com.fleet.manager.persistence.entity;

import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by pawel.langwerski@gmail.pl on 06.09.17.
 */
@Getter
@MappedSuperclass
public abstract class AbstractEntity {

  @Id
  @GeneratedValue
  private Long id;
}