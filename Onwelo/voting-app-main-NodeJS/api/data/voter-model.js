const mongoose = require('mongoose');

const voterSchema = new mongoose.Schema({
    name: {
        type: String,
        required: true
    },
    hasVoted: {
        type: Boolean,
        default: false
    }
});

mongoose.model('Voter', voterSchema, 'voter');
