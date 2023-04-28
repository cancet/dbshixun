package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Admin;
import com.example.dbshixun.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @ClassName AdminController
 * @author cancet
 * @Date 2023/4/28
 * @Description 管理员表的控制层
 */
@RestController
@RequestMapping("/admin")
@Tag(name = "AdminController",description = "管理员表的控制层")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/admins")
    @Operation(summary = "管理员列表",description = "返回管理员表当中的所有信息")
    public List<Admin>admins(){
        return adminService.admins();
    }
    @GetMapping("/getAdminByName/{username}")
    @Operation(summary = "查询管理员",description = "根据用户名寻找管理员")
    public Admin getAdminByName(@PathVariable String username){
        return adminService.getAdminByName(username);
    }
    @PostMapping("/login/{username}/{password}")
    @Operation(summary = "登录",description = "登录还有什么好说的")
    public String login(@PathVariable String username,@PathVariable String password){
        if(adminService.login(username,password)!=null){
            return "200";
        }else {
            return "404";
        }
    }
    @PostMapping("/signUp/{username}/{password}")
    @Operation(summary = "注册",description = "管理员要注册吗？")
    public  String signUp(@PathVariable String username,@PathVariable String password){
        if (adminService.getAdminByName(username)!=null){
            System.out.println("用户已存在");
            return "400";//用户名重复
        }else {
            try {
                adminService.signUp(username,password);
                return "200";
            }catch (Exception e){
                System.out.println("注册用户时出现异常");
                e.printStackTrace();
                return "500";
            }
        }
    }
    @PutMapping("/updateAdmin")
    @Operation(summary = "修改管理员",description = "修改管理员用户名，密码")
    public String updateAdmin(@RequestBody Admin admin){
        if (adminService.getAdminByName(admin.getUsername())!=null){
            try{
                adminService.updateAdmin(admin);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("修改管理员时出现异常");
                return "500";
            }
        }else {
            System.out.println("用户不存在");
            return "404";
        }
    }
    @DeleteMapping("/deleteAdmin/{id}")
    @Operation(summary = "删除管理员",description = "没啥好说的")
    public String deleteAdmin(@PathVariable int id){
        if(adminService.getAdminById(id)!=null){
            try{
                adminService.deleteAdmin(id);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("删除管理员时出现异常");
                return "500";
            }
        }else{
            System.out.println("用户不存在");
            return "404";
        }
    }
    @GetMapping("/getAdminById/{id}")
    @Operation(summary = "根据id查询管理员",description = "真没什么好说的")
    public Admin getAdminById(@PathVariable int id){
        return adminService.getAdminById(id);
    }
}
