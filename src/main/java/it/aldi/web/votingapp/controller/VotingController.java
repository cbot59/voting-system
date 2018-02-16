package it.aldi.web.votingapp.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.aldi.web.votingapp.entity.Candidate;
import it.aldi.web.votingapp.entity.Citizen;
import it.aldi.web.votingapp.repository.CandidateRepository;
import it.aldi.web.votingapp.repository.CitizenRepository;

@Controller
public class VotingController {

  @Autowired CitizenRepository citizenRepository;

  @Autowired CandidateRepository candidateRepository;

  @RequestMapping("/")
  public String goToVote() {
    return "vote";
  }

  @RequestMapping("/doLogin")
  public String doLogin(@RequestParam String name, Model model, HttpSession session) {

    Citizen citizen = citizenRepository.findByName(name);

    session.setAttribute("citizen", citizen);

    if (!citizen.isHasVoted()) {
      List<Candidate> candidates = candidateRepository.findAll();

      model.addAttribute("candidates", candidates);

      return "performVote";
    }
    return "alreadyVoted";
  }

  @RequestMapping("/voteFor")
  public String voteFor(@RequestParam Long id, HttpSession session) {

    Citizen citizen = (Citizen) session.getAttribute("citizen");

    if (!citizen.isHasVoted()) {
      citizen.setHasVoted(true);

      Candidate candidate = candidateRepository.findById((long) id);
      candidate.setNumOfVotes(candidate.getNumOfVotes() + 1);

      candidateRepository.save(candidate);
      citizenRepository.save(citizen);

      return "voted";
    }

    return "alreadyVoted";
  }
}
