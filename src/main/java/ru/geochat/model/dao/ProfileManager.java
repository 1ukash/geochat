package ru.geochat.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.geochat.model.dto.Person;

public class ProfileManager extends JdbcDaoSupport implements IPersonManager {
  
  private String getPersonById;
  private String createPersonQuery;

  @Required
  public void setGetPersonById(String getPersonById) {
    this.getPersonById = getPersonById;
  }
  
  @Required
  public void setCreatePersonQuery(String createPersonQuery) {
    this.createPersonQuery = createPersonQuery;
  }

  /* (non-Javadoc)
   * @see ru.geochat.model.dao.IPersonManager#getPersonById(java.lang.String)
   */
  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public Person getPersonById(Integer id) {
    return getJdbcTemplate().queryForObject(getPersonById, new RowMapper<Person>() {

      @Override
      public Person mapRow(ResultSet rs, int idx) throws SQLException {
        return new Person(rs.getInt("id"), rs.getString("name"), rs.getString("email"));
      }
      
    }, id);
  }

  @Override
  @Transactional(propagation=Propagation.REQUIRED)
  public void createNewPerson(Person p) {
    getJdbcTemplate().update(createPersonQuery, p.getName(), p.getEmail());
  }

}
