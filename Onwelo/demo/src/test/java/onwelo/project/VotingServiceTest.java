package onwelo.project;

import onwelo.project.domain.Candidate;
import onwelo.project.domain.Voter;
import onwelo.project.repositories.CandidateRepository;
import onwelo.project.repositories.VoterRepository;
import onwelo.project.service.VotingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VotingServiceTest {
    @InjectMocks
    private VotingService votingService;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private VoterRepository voterRepository;

    @Test
    public void testAddCandidate() {
        Candidate candidate = new Candidate();
        candidate.setName("CandidateName");

        lenient().when(candidateRepository.findCandidateByName("CandidateName")).thenReturn(null);

        when(candidateRepository.save(candidate)).thenReturn(candidate);

        Candidate addedCandidate = votingService.addCandidate(candidate);

        assertEquals(candidate, addedCandidate);
    }

    @Test
    public void testAddVoter() {
        Voter voter = new Voter();
        voter.setName("VoterName");

        lenient().when(voterRepository.findVoterByName("VoterName")).thenReturn(null);
        //lenient().when(candidateRepository.findCandidateByName("CandidateName")).thenReturn(null);

        when(voterRepository.save(voter)).thenReturn(voter);

        Voter addedVoter = votingService.addVoter(voter);

        assertEquals(voter, addedVoter);
    }

    // Write similar tests for other methods...
}
