package onwelo.project.repositories;

import onwelo.project.domain.Candidate;
import onwelo.project.domain.Voter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, String> {

    Candidate findCandidateByName(String candidatename);

}

