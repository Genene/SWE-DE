package onwelo.project.controller;

import com.mongodb.MongoWriteException;
import onwelo.project.domain.Candidate;
import onwelo.project.domain.Voter;
import onwelo.project.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VotingController {
    private final VotingService votingService;

    @Autowired
    public VotingController(VotingService votingService) {
        this.votingService = votingService;
    }

    @PostMapping("/candidate")
    public ResponseEntity<?> addCandidate(@RequestBody Candidate candidate) {
        try {
            // Check if a candidate with the same name already exists in the database
            Candidate existingCandidate = votingService.getCandidateByName(candidate.getName());

            if (existingCandidate != null) {
                // If a candidate with the same name exists, return a bad request response
                return new ResponseEntity<>("Error: Duplicate name found.", HttpStatus.BAD_REQUEST);
            } else {
                // If no duplicate found, add the candidate to the database
                Candidate addedCandidate = votingService.addCandidate(candidate);
                return new ResponseEntity<>(addedCandidate, HttpStatus.CREATED);
            }
        } catch (MongoWriteException e) {
            // Handle other MongoDB write exceptions if needed
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/voter")
    public ResponseEntity<?> addVoter(@RequestBody Voter voter) {
        try {
            // Check if a voter with the same name already exists in the database
            Voter existingVoter = votingService.getVoterByName(voter.getName());

            if (existingVoter != null) {
                // If a voter with the same name exists, return a bad request response
                return new ResponseEntity<>("Error: Duplicate name found.", HttpStatus.BAD_REQUEST);
            } else {
                // If no duplicate found, add the voter to the database
                Voter addedVoter = votingService.addVoter(voter);
                return new ResponseEntity<>(addedVoter, HttpStatus.CREATED);
            }
        } catch (MongoWriteException e) {
            // Handle other MongoDB write exceptions if needed
            return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            // Handle other exceptions and return an appropriate response.
            return new ResponseEntity<>("Error message: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/castvoter")
    public ResponseEntity<?> castVote(@RequestParam String candidateId, @RequestParam String voterId) {
        try {
            votingService.castVote(candidateId, voterId);
            return ResponseEntity.ok("Vote cast successfully.");
        } catch (RuntimeException e) {
            // Handle any exceptions thrown by the service
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
        }
    }

    @GetMapping("/candidate")
    public ResponseEntity<?> getCandidates() {
        try {
            List<Candidate> candidates = votingService.getAllCandidates();
            return new ResponseEntity<>(candidates, HttpStatus.OK);
        } catch (Exception e) {
            // Handle the exception and return an appropriate response.
            return new ResponseEntity<>("Error message: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/voter")
    public ResponseEntity<?> getVoters() {
        try {
            List<Voter> voters = votingService.getAllVoters();
            return new ResponseEntity<>(voters, HttpStatus.OK);
        } catch (Exception e) {
            // Handle the exception and return an appropriate response.
            return new ResponseEntity<>("Error message: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Global Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return new ResponseEntity<>("Error message: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
