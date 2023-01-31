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

    public void insert(MemberDTO memberDTO) {
        String insertMemberSQL = "Insert Into table1 Values(?, ?, ?)";
        jdbcTemplate.update(insertMemberSQL, memberDTO.email, memberDTO.password, memberDTO.nickname);
    }

    public void update(String email, MemberDTO memberDTO) {
        String updateMemberSQL = "Update table1 Set password=?, nickname=? Where email = ?";
        jdbcTemplate.update(updateMemberSQL, memberDTO.password, memberDTO.nickname, email);
    }

    public void delete(String email) {
        String deleteMemberSQL = "Delete From table1 Where email = ?";
        jdbcTemplate.update(deleteMemberSQL, email);
    }

    public void select(int id) {
        String selectMemberSQL = "Select * from table1 Where id ";
        if (id == -1) {
            selectMemberSQL += "is not null";
        }
        else {
            selectMemberSQL += "= " + id;
        }
    }
}
