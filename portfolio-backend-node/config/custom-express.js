var express = require('express');
var app = express();
var consign = require('consign');
var bodyParser = require('body-parser');
var router = express.Router();
var PropertiesReader = require('properties-reader');
var properties = PropertiesReader(__dirname + '/properties.ini');

router.properties = properties;
app.properties = properties;

app.use((req, res, next) => {
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type');
    next();
});

app.use(bodyParser.urlencoded({extended : true}));
app.use(bodyParser.json());

consign()
    .include('controllers')
    .then('db')
    .then('services')
    .into(router);

app.use('/webapi', router);

module.exports = app;