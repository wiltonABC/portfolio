var express = require('express');
var app = express();
var consign = require('consign');
var bodyParser = require('body-parser');
var router = express.Router();
var PropertiesReader = require('properties-reader');
var properties = PropertiesReader(__dirname + '/properties.ini');

router.properties = properties;
app.properties = properties;

//Angular static route
app.use(express.static(__basedir + '/portfolio-front/'));

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

//Angular entry point index.html route
const allowedExt = [
    '.js',
    '.ico',
    '.css',
    '.png',
    '.jpg',
    '.woff2',
    '.woff',
    '.ttf',
    '.svg',
    '.gif',
  ];

app.get('/*', (req, res, next) => {
    if (allowedExt.filter(ext => req.url.indexOf(ext) > 0).length > 0) {
        res.sendFile(`${__basedir}/portfolio-front${req.url.slice(0,-1)}`);
    } else {
        res.sendFile('index.html', {root : __basedir + '/portfolio-front/'});
    }
}); 

module.exports = app;