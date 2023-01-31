package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class MemberDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public MemberDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void insert(int id, String name) {
        String insertMemberSQL = "Insert Into table1 Values(?, ?)";
        jdbcTemplate.update(insertMemberSQL, id, name);
    }

    public void update(int id, String newName) {
        String updateMemberSQL = "Update table1 Set name=? Where id = ?";
        jdbcTemplate.update(updateMemberSQL, newName, id);
    }

    public void select(int id) {
        String selectMemberSQL = "Select * from table1 Where id ";
        if (id == -1) {
            selectMemberSQL += "is not null";
        }
        else {
            selectMemberSQL += "= " + id;
        }

        jdbcTemplate.queryForObject();
    }
}
