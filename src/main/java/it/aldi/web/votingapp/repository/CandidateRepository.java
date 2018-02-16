package it.aldi.web.votingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.aldi.web.votingapp.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

  Candidate findById(long id);
}
