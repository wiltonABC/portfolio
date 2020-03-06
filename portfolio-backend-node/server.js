global.__basedir = __dirname;

var app = require('./config/custom-express');

var port = app.properties.path().app.port;

app.listen(port, () => {
    console.log('App listening on port ' + port);
});