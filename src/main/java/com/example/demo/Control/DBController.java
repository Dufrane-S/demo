package com.example.demo.Control;

import com.example.demo.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="db")
public class DBController {
    @Autowired
    private MemberDAO memberDAO;
    @GetMapping(value="/select")
    public String select(@RequestParam("tableName") String tableName) {
        return tableName;
    }

    @GetMapping(value="/insert")
    public void insert(@RequestParam("id") int id, @RequestParam("name") String name) {

        memberDAO.insert(id, name);
    }

    @GetMapping(value="/delete")
    public void delete(@RequestParam("id") int id) {
        memberDAO.delete(id);
    }

    @GetMapping(value="/update")
    public void update(@RequestParam("id") int id, @RequestParam("newName") String newName) {
        memberDAO.update(id, newName);
    }

    @RequestMapping("/")
    public String helloWorld() {
        return "DB";
    }
}
