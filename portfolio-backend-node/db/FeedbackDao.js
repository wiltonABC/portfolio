class FeedbackDao {
    constructor(connection) {
        this._connection = connection;
    }

    findByProfileIdPaged(id, page, pageCount, callback) {
        this._connection.query(`select * from feedback 
          where profile_idProfile = ? order by dateCreated desc limit ?, ?`,
          [id, page * pageCount - pageCount, pageCount], callback);
    }

    insert(feedback, callback) {
        this._connection.query(` INSERT INTO feedback
        (author,
        company,
        dateCreated,
        text,
        profile_idProfile)
        VALUES (?, ?, CURRENT_TIMESTAMP, ?, ?)`, [feedback.author, 
            feedback.company, feedback.text, 
            feedback.profile.idProfile], callback);
    } 

}

module.exports = () => {
    return FeedbackDao;
}