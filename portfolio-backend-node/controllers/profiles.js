module.exports = (router) => {
    router.get('/profiles/:id', (req,res) => {

        var connection = router.db.connection();
        var profileDao = new router.db.ProfileDao(connection);
        var id = parseInt(req.params.id);

        profileDao.findById(id, (error, result, fields) => {
            if (error) {
                console.log(error);
                res.status(500).send(error);
            } else if (result.length > 0) {
                res.status(200).send(result[0]);
            } else {
                res.status(404).send('Profile not found!');      
            }
        });

        connection.end();

    });

    router.get('/profiles/:id/skills', (req, res) => {
        var connection = router.db.connection();
        var skillDao = new router.db.SkillDao(connection);
        var id = parseInt(req.params.id);

        skillDao.findByProfileId(id, (error, result, fields) => {
            if (error) {
                console.log(error);
                res.status(500).send(error);
            } else if (result.length > 0) {
                var skillsList = [];

                Object.keys(result).forEach((key) => {
                    var row = result[key];

                    var skill = {};
                    skill.idSkill = row.idSkill;
                    skill.skillCategory = {};
                    skill.skillCategory.idSkillCategory = row.idSkillCategory;
                    skill.skillCategory.name = row.name;
                    skill.skillCategory.image = row.image;
                    skill.skillCategory.dateCreated = row.dateCreated;
                    skill.name = row.skillName;
                    skill.dateCreated = row.skillDate;

                    skillsList.push(skill);
                })

                res.status(200).send(skillsList);
            } else {
                res.status(404).send('Skills not found!');      
            }
        });

        connection.end();
    });

    router.get('/profiles/:id/work-done', (req, res) => {

        var connection = router.db.connection();
        var workDoneDao = new router.db.WorkDoneDao(connection);
        var id = parseInt(req.params.id);

        workDoneDao.findByProfileId(id, (error, result, fields) => {
            if (error) {
                console.log(error);
                res.status(500).send(error);
            } else if (result.length > 0) {
                res.status(200).send(result);
            } else {
                res.status(404).send('Work done not found!');      
            }
        });

        connection.end();
    });

    router.get('/profiles/:id/feedbacks', (req, res) => {

        var connection = router.db.connection();
        var feedbackDao = new router.db.FeedbackDao(connection);
        var id = parseInt(req.params.id);
        var page = parseInt(req.query.page);
        var pageCount = parseInt(req.query.pageCount);

        feedbackDao.findByProfileIdPaged(id, page, pageCount, (error, result, fields) => {
            if (error) {
                console.log(error);
                res.status(500).send(error);
            } else if (result.length > 0) {
                res.status(200).send(result);
            } else {
                res.status(404).send('Feedbacks not found!');      
            }
        });

        connection.end();
    });
}