const express = require("express");
const router = express.Router();
const votingController = require("../controller/controller");

router.post("/addCandidate", votingController.addCandidate);
router.post("/addVoter", votingController.addVoter);
router.post("/castVote", votingController.castVote);

router.get("/candidates", votingController.getCandidates);
router.get("/voters", votingController.getVoters);
module.exports = router;
