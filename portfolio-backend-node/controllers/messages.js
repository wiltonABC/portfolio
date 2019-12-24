var MailFormatter = require('../util/MailFormatter');

module.exports = (router) => {

    router.post('/messages', (req, res) => {

        var connection = router.db.connection();
        var messageDao = new router.db.MessageDao(connection);
        var profileDao = new router.db.ProfileDao(connection);
        var message = req.body;

        messageDao.insert(message, (error, result) => {
            if (error) {
                console.log(error);
                res.status(500).send(error);
            } else {
                //Send mail
                profileDao.findById(message.profile.idProfile, (error, result) => {

                    if (error) {
                        console.log(error);
                    }
                    else {
                        var profile = result[0];
                        
                        const emailService = new router.services.EmailService(router.properties);

                        //Sending email to portfolio's admin
                        emailService.sendMail(
                            router.properties.path().mail.mailTo,
                            profile.shortName +  "'s Portfolio - " + message.subject,
                            MailFormatter.getHtmlFormattedContactEmail(message.name, 
                                message.email, message.message)
                        );
        
                        //Confirmation email to the sender
                        emailService.sendMail(message.email, profile.shortName 
                            + "'s Portfolio - Message receiving confirmation", 
                            MailFormatter.getHtmlFormattedConfirmationEmail(
                                message.name, profile, router.properties.path().site.url
                            ));
                    }

                });

                connection.end();

                res.location('/messages/' + result.insertId);
                res.status(201).send();      
            }
        });

    });

};