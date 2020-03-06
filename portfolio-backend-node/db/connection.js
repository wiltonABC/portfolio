var mysql = require('mysql');

module.exports = (router) => function createConnection() {

    return mysql.createConnection({
            host: router.properties.path().database.host,
            user: process.env.PORTFOLIO_USER,
            password: process.env.PORTFOLIO_PASSWORD,
            database: router.properties.path().database.database
        });
};