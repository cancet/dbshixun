package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    Admin login(String username,String password);
    void signUp(String username,String password);
    Admin getAdminByName(String username);
    void updateAdmin(Admin admin);
    void deleteAdmin(int id);
    List<Admin>admins();
    Admin getAdminById(int id);
}
