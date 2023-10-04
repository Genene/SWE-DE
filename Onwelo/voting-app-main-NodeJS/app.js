// app.js

require("./api/data/db.js");
const express = require('express');
const app = express();
const port = 3000;
const routes = require('./api/route/route');
const path = require("path");

app.use(express.json())
app.use(express.urlencoded({ extended: true }))
app.use(express.static(path.join(__dirname, "public")));

app.use('/api', routes);

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});