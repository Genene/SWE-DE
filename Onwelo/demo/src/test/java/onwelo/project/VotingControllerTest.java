package onwelo.project;

import onwelo.project.controller.VotingController;
import onwelo.project.domain.Candidate;
import onwelo.project.domain.Voter;
import onwelo.project.service.VotingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VotingControllerTest {
    @InjectMocks
    private VotingController votingController;

    @Mock
    private VotingService votingService;

    @Test
    public void testAddCandidate() {
        Candidate candidate = new Candidate();
        candidate.setName("CandidateName");

        when(votingService.getCandidateByName("CandidateName")).thenReturn(null);
        when(votingService.addCandidate(candidate)).thenReturn(candidate);

        ResponseEntity<?> response = votingController.addCandidate(candidate);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(candidate, response.getBody());
    }

    @Test
    public void testAddVoter() {
        Voter voter = new Voter();
        voter.setName("VoterName");

        when(votingService.getVoterByName("VoterName")).thenReturn(null);
        when(votingService.addVoter(voter)).thenReturn(voter);

        ResponseEntity<?> response = votingController.addVoter(voter);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(voter, response.getBody());
    }

    // Write similar tests for other methods...
}
