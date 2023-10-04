const mongoose = require("mongoose");
let url = "mongodb://127.0.0.1:27017/votingapp";
let dbName = 'votingapp';
require("./candidate-model")
require("./voter-model")

mongoose.connect(url, { useNewUrlParser: true, useUnifiedTopology: true });

mongoose.connection.on("connected", function () {
    console.log("Mongoose connected to " + dbName);
});
mongoose.connection.on("disconnected", function () {
    console.log("Mongoose disconnected");
});
