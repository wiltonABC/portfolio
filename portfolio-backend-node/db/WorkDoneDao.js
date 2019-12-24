class WorkDoneDao {
    constructor(connection) {
        this._connection = connection;
    }

    findByProfileId(id, callback) {
        this._connection.query(`select * from work_done 
          where profile_idProfile = ?`,[id], callback);
    }
}

module.exports = () => {
    return WorkDoneDao;
}