package com.Controller;

import com.domain.IUser.User;
import com.domain.Team;
import com.util.Result;
import com.util.StatusCode;
import io.swagger.annotations.ApiOperation;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.service.TeamService;
import com.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TeamController
{
    @Autowired
    private TeamService teamService;
    @Autowired
    private  UserService userService;

    @ApiOperation(value = "获取队伍列表")
    @RequestMapping(value = "/teams",method = RequestMethod.GET)
    public ModelAndView showTeams(HttpSession session)
    {
        Object u = session.getAttribute("user");
        ModelAndView mv = new ModelAndView();
        mv.setViewName("team");
        List<Team> teams = teamService.FindAll();

        mv.getModel().remove("Jteams");
        //判断用户是否登陆,如果未登陆，显示全部team;如果已登录，则将team分为已参加和未参加两部分
        if (u != null) {
            User user = (User) u;
            List<Team> Jteams = teamService.FindByUserId(user.getId());
            for(int i=0;i<Jteams.size();i++)
            {
                Team t = Jteams.get(i);
                teams.remove(t);
            }
            mv.addObject("Jteams", Jteams);
        }
        else{
            mv.addObject("Jteams",new ArrayList());
        }

        mv.getModel().remove("UJteams");
        mv.addObject("UJteams",teams);//UJ:UnJoined
        return mv;

    }

    @ApiOperation(value = "新建队伍")
    @RequestMapping(value = "/team",method = RequestMethod.POST)
    public String addteam(Team team)
    {
        teamService.saveTeam(team);
        return "redirect:/teams";
    }


    @ApiOperation("加入队伍")
    @RequestMapping(value = "/team/{tid}/user/{uid}",method = RequestMethod.POST)
    public String joinTeam(HttpServletRequest request, HttpServletResponse response, @PathVariable("tid")int tid, @PathVariable("uid") int uid) throws Exception {
        teamService.addMember(tid,uid);

        //TODO bug转发后不能及时更新页面，后期拟采用ajax完成
        return "redirect:/teams";
    }

    @ApiOperation("获取我创建的队伍")
    @RequestMapping(value = "/user/{id}/teams",method = RequestMethod.GET)
    public ModelAndView showMyTeam(@PathVariable("id")int id)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("myteam");

        //获取team并填充member
        List<Team> teams = teamService.FindByCaptainId(id);
        for(Team t : teams){
            t.setMembers(teamService.FindAllMembers(t.getTid()));
        }

        mv.addObject("myteams",teams);
        return mv;
    }

    @ApiOperation("返回队伍管理页面")
    @RequestMapping(value = "/team/{tid}",method = RequestMethod.GET)
    public ModelAndView manageMyTeam(@PathVariable("tid")int tid)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("teamManage");

        //获取team并填充member
        Team team = teamService.FindById(tid);
        team.setMembers(teamService.FindAllMembers(team.getTid()));

        mv.addObject("myteam",team);
        return mv;
    }

    @ApiOperation("踢出队员")
    @RequestMapping(value = "/team/{tid}/user/{uid}",method = RequestMethod.DELETE)
    @ResponseBody
    public Result kickMember(@PathVariable("uid")int uid, @PathVariable("tid")int tid)
    {
        try
        {
            teamService.deleteMember(tid,uid);
            return new Result(true, StatusCode.OK,"删除成功");
        }
        catch (Exception e){
            return new Result(false, StatusCode.ERROR,"删除失败");
        }

    }
}
