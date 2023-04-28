package com.example.dbshixun.service;

import com.example.dbshixun.mapper.AdminMapper;
import com.example.dbshixun.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
    public Admin login(String username,String password){
        return adminMapper.login(username, password);
    }
    public void signUp(String username,String password){
        adminMapper.signUp(username, password);
    }
    public Admin getAdminByName(String username){
        return adminMapper.getAdminByName(username);
    }
    public void updateAdmin(Admin admin){
        adminMapper.updateAdmin(admin);
    }
    public void deleteAdmin(int id){
        adminMapper.deleteAdmin(id);
    }
    public List<Admin>admins(){
        return adminMapper.admins();
    }
    public Admin getAdminById(int id){
        return adminMapper.getAdminById(id);
    }
}
