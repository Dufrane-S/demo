package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    class MemberMapper implements RowMapper<MemberDTO> {
        @Override
        public MemberDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new MemberDTO(rs.getString("email"), rs.getString("password"), rs.getString("nickname"));
        }
    }
    public MemberDTO select(String email) {
        String selectMemberSQL = "Select * From table1 Where email = ?";
        return jdbcTemplate.queryForObject(selectMemberSQL, new MemberMapper(), email);
    }

    public List<MemberDTO> selectAll() {
        String selectAllMemberSQL = "Select * From table1";
        return jdbcTemplate.query(selectAllMemberSQL, new MemberMapper());
    }
}
