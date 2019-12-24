module.exports = (router) => {

    router.post('/feedbacks', (req, res) => {

        var connection = router.db.connection();
        var feedbackDao = new router.db.FeedbackDao(connection);
        var feedback = req.body;

        feedbackDao.insert(feedback, (error, result) => {
            if (error) {
                console.log(error);
                res.status(500).send(error);
            } else {
                res.location('/feedbacks/' + result.insertId);
                res.status(201).send();      
            }
        });

        connection.end();

    });

};