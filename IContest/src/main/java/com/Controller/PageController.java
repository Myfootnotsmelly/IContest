package com.Controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(value = "页面跳转控制器")
public class PageController {

    @RequestMapping(value = {"/","/index"},method = RequestMethod.GET)
    @ApiOperation("跳转到主页")
    public String Index()    { return "index"; }

    @RequestMapping(value ="/Login",method = RequestMethod.GET)
    @ApiOperation("跳转到登录页")
    public String LoginPage()   {  return "Login";  }

    @RequestMapping(value = "/Regist",method = RequestMethod.GET)
    @ApiOperation("跳转到注册页")
    public String RegistPage() { return "Regist"; }

    @RequestMapping(value = "/newTeamPage",method = RequestMethod.GET)
    @ApiOperation("跳转到新建队伍页")
    public String addTeamPage() { return "newTeam";   }



}
