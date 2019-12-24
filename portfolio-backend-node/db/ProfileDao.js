class ProfileDao {
    constructor(connection) {
        this._connection = connection;
    }

    findById(id, callback) {
        this._connection.query('select * from profile where idProfile = ?', [id], callback);
    }

}


module.exports = () => {
    return ProfileDao;
}