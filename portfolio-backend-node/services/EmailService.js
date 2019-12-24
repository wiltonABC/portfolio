var nodeMailer = require('nodemailer');

class EmailService {

    constructor (properties) {
        this._properties = properties;
        this._transporter = nodeMailer.createTransport({
            host: properties.path().mail.smtp.host,
            port: properties.path().mail.smtp.port,
            auth: {
              user: properties.path().mail.smtp.user.name,
              pass: properties.path().mail.smtp.user.password
            },
            tls: {
                ciphers: properties.path().mail.smtp.tls.ciphers
            }
        });
    }  
    
    sendMail(mailTo, mailSubject, mailMessage) {

        var mailOptions = {
            from: this._properties.path().mail.mailFrom,
            to: mailTo,
            subject: mailSubject,
            html: mailMessage
        };

        this._transporter.sendMail(mailOptions, (error, info) => {
            if (error) {
                console.log(error);
            } else {
                console.log('Email sent: ' + info.response);
            }
        });
    }

}

module.exports = () => {
    return EmailService;
}