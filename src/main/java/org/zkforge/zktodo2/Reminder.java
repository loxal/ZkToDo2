/*
 * Copyright 2012 Alexander Orlov <alexander.orlov@loxal.net>. All rights reserved.
 */

package org.zkforge.zktodo2;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The JPA entity which is rendered onto the screen.
 */
@Entity
@Table(name = "REMINDER")
public class Reminder {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "REMINDER_ID")
  private Long id;

  @Column(name = "NAME")
  private String name = "";

  @Column(name = "PRIORITY")
  private int priority = 0;

  @Column(name = "DATE1")
  private Date date = new Date(System.currentTimeMillis());

  public Reminder() {
//    System.out.println("java.lang.System.getenv(\"VCAP_SERVICES\") = " + System.getenv("VCAP_SERVICES"));
    Logger.getAnonymousLogger().log(Level.SEVERE, java.lang.System.getenv("VCAP_SERVICES"));
  }

  public Reminder(String name, int priority, Date date) {
    this.name = name;
    this.priority = priority;
    this.date = date;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    if (obj.getClass() != getClass()) {
      return false;
    }
    Reminder rhs = (Reminder) obj;
    return new EqualsBuilder()
        .appendSuper(super.equals(obj))
        .append(id, rhs.id)
        .append(name, rhs.name)
        .append(priority, rhs.priority)
        .append(date, rhs.date)
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().append(id).append(name).append(priority).append(date).toHashCode();
  }
}
