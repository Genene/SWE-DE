package onwelo.project.service;

import onwelo.project.domain.Candidate;
import onwelo.project.domain.Voter;
import onwelo.project.repositories.CandidateRepository;
import onwelo.project.repositories.VoterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VotingService {
    private final CandidateRepository candidateRepository;
    private final VoterRepository voterRepository;

    @Autowired
    public VotingService(CandidateRepository candidateRepository, VoterRepository voterRepository) {
        this.candidateRepository = candidateRepository;
        this.voterRepository = voterRepository;
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate getCandidateByName(String candidatename) {
        return candidateRepository.findCandidateByName(candidatename);
    }

    public Voter addVoter(Voter voter) {
        return voterRepository.save(voter);
    }
    public Voter getVoterByName (String name){
        return voterRepository.findVoterByName(name);
    }

    @Transactional
    public void castVote(String candidateId, String voterId) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Voter voter = voterRepository.findById(voterId)
                .orElseThrow(() -> new RuntimeException("Voter not found"));

        if (voter.isHasVoted()) {
            throw new RuntimeException("Voter has already voted");
        }

        voter.setHasVoted(true);
        candidate.setVotes(candidate.getVotes() + 1);

        candidateRepository.save(candidate);
        voterRepository.save(voter);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }
}
