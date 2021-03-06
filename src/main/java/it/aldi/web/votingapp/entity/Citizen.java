package it.aldi.web.votingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "citizen")
@Entity
public class Citizen {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "citizen_name")
  private String name;

  @Column(name = "has_voted")
  private boolean hasVoted;

  public Citizen() {
    super();
  }

  public Citizen(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
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

  public boolean isHasVoted() {
    return hasVoted;
  }

  public void setHasVoted(boolean hasVoted) {
    this.hasVoted = hasVoted;
  }
}
