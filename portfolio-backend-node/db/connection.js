var mysql = require('mysql');

function createConnection() {
    return mysql.createConnection({
        host: 'localhost',
        user: 'root',
        password: 'w14j0813',
        database: 'portfolio'
    });
}

module.exports = () => {
    return createConnection;
}