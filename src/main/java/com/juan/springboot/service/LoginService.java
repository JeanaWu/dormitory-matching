package com.juan.springboot.service;

import com.juan.springboot.bean.Student;
import com.juan.springboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    StudentMapper studentMapper;

    public Map login(Integer id, String password){

        Map<String,Object> map=new HashMap<>();

        if (000000==id && "123456".equals(password)) {
            //管理员登录成功返回0
            map.put("msg",0);
//            request.getSession().setAttribute("loginName","admin");
            return map;

        } else if (password.equals(studentMapper.findPasswordbyId(id))) {
            //用户成功登入返回1
            map.put("msg",1);

//            request.getSession().setAttribute("loginName","student");

            return map;
        } else if (studentMapper.findIdbyId(id)== null) {
            //用户不存在返回-1
            map.put("msg", -1);
            return map;
        } else {
            //用户密码错误返回-2
            map.put("msg", -2);
            return map;
        }
    }

}
