package it.aldi.web.votingapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "candidate")
@Entity
public class Candidate {

  @Id
  @Column(name = "id")
  private Long id;

  @Column(name = "candidate_name")
  private String name;

  @Column(name = "num_of_votes")
  private Integer numOfVotes;

  public Candidate() {
    super();
  }

  public Candidate(Long id, String name) {
    super();
    this.id = id;
    this.name = name;
  }

  public long getId() {
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

  public Integer getNumOfVotes() {
    return numOfVotes;
  }

  public void setNumOfVotes(Integer numOfVotes) {
    this.numOfVotes = numOfVotes;
  }
}
