class MessageDao {
    constructor(connection) {
        this._connection = connection;
    }

    insert(message, callback) {
        this._connection.query(` INSERT INTO message
        (name,
        email,
        dateCreated,
        message,
        subject,
        profile_idProfile)
        VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?, ?)`, [message.name, 
            message.email, message.message, message.subject,
            message.profile.idProfile], callback);
    } 
}

module.exports = () => {
    return MessageDao;
}