package it.aldi.web.votingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.aldi.web.votingapp.entity.Citizen;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

  Citizen findByName(String name);
}
