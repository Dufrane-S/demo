package com.example.demo.Control;

import com.example.demo.MemberDAO;
import com.example.demo.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="member")
public class MemberController {

    @Autowired
    private MemberDAO memberDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value="register")
    public int register(@RequestBody MemberDTO memberDTO) {
        if (memberDAO.select(memberDTO.getEmail()) != null) {
            return -1;
        }
        else {
            String rawPassword = memberDTO.getPassword();
            String encodedPassword = passwordEncoder.encode(rawPassword);
            memberDTO.setPassword(encodedPassword);
            memberDAO.insert(memberDTO);
            return 1;
        }
    }
    @PostMapping(value="login")
    public int login(@RequestBody Map<String, String> map) {
        MemberDTO member = memberDAO.select(map.get("email"));

        if (member != null) {
            if (passwordEncoder.matches(map.get("password"), member.getPassword())) {
                return 1;
            }
        }

        return -1;
    }
}
