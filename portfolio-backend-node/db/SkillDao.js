class SkillDao {
    constructor(connection) {
        this._connection = connection;
    }

    findByProfileId(id, callback) {
        this._connection.query(`select s.idSkill, s.name as skillName, 
          s.dateCreated as skillDate, c.* from skill s 
          inner join skill_category c on s.skillCategory_idSkillCategory = c.idSkillCategory
          inner join profile_skill p on s.idSkill = p.skills_idSkill 
          where p.profile_idProfile = ?`,[id], callback);
    }

}

module.exports = () => {
    return SkillDao;
}