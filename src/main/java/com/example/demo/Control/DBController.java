package com.example.demo.Control;

import com.example.demo.MemberDAO;
import com.example.demo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="db")
public class DBController {
    @Autowired
    private MemberDAO memberDAO;

    @PostMapping(value="/insert")
    public void insert(@RequestBody MemberDTO memberDTO) {

        memberDAO.insert(memberDTO);
    }

    @PostMapping(value="/delete")
    public void delete(@RequestParam("email") String email) {
        memberDAO.delete(email);
    }

    @PostMapping(value="/update")
    public void update(@RequestParam("email") String email, @RequestBody MemberDTO memberDTO) {
        memberDAO.update(email, memberDTO);
    }

    @PostMapping(value="/select")
    public void select(@RequestParam("email") String email){
        memberDAO.select(email);
    }
}
