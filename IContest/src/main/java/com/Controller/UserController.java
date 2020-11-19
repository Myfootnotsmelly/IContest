package com.Controller;

import com.domain.IUser.User;
import com.util.Result;
import com.util.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.service.UserService;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.*;

/**
 * 控制器类
 */
@Controller
@Api(value = "用户控制器")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "更新用户个人信息")
    @RequestMapping(value = "/User",method = RequestMethod.PUT)
    public String UpdateUser(User user){
        userService.updateUser(user);
        return "redirect:/index";
    }

    @ApiOperation(value = "根据id查询用户")
    @RequestMapping(path="/User/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User GetUSerByid(@PathVariable("id") Integer id)
    {
//        try{
//            User user = userService.FindById(id);
//            return new Result<User>(true, StatusCode.OK,"查询成功",user);}
//        catch (Exception e){
//            return new Result(false, StatusCode.ERROR,e.getMessage());
//        }
        User user = userService.FindById(id);
        return user;
    }

    @ApiOperation(value = "根据id删除用户")
    @RequestMapping(path = "/User/{id}",method = RequestMethod.DELETE)
    public String DeleteUser(@PathVariable("id")int id,@ApiIgnore HttpSession session) throws Exception
    {
        userService.deleteUser(id);
        return "index";
    }

    @ApiOperation(value = "登陆")
    @ApiImplicitParams({@ApiImplicitParam(name = "username",value="用户名",required = true),
            @ApiImplicitParam(name = "password",value="密码",required = true)})
    @RequestMapping(path = "/UserLogin",method = RequestMethod.GET)
    public String UserLogin(String username,String password,@ApiIgnore HttpSession session)
    {
        User user = userService.UserLogin(username,password);
        if(user!=null)
        {
            session.setAttribute("user",user);
            return "redirect:/index";
        }else {
            return "redirect:/error";
        }
    }

    @ApiOperation(value = "注册")
    @RequestMapping(path = "/User" ,method = RequestMethod.POST)
    public String RegistUser(User user,@ApiIgnore HttpSession session) throws Exception
    {
        userService.UserRegist(user);
        session.setAttribute("user",user);
        return "redirect:index.html" ;
    }


    @ApiOperation(value = "注销")
    @RequestMapping(value = "/Logout",method = RequestMethod.GET)
    public String UserLogout(@ApiIgnore HttpSession session)
    {
        session.removeAttribute("user");
        return "index";
    }



}
