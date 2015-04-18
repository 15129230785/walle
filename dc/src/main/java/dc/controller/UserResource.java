package dc.controller;

import dc.exception.ExceptionCode;
import dc.exception.ServiceException;
import dc.model.param.UserParam;
import dc.service.UserService;
import dp.dubbo.pojo.User;
import dp.dubbo.redis.service.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alibaba.fastjson.JSON;

/**
 * Created by evan.wan on 2015/4/7.
 */
@Controller
@Path("/user")
public class UserResource {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RedisClient redisClient;


    //   	@Reference(version="1.0.0")
//	private TestDubbo testDubbo;

    @Path("/users/{username}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getUser(@PathParam("username") String username) {
        logger.info("UserResource getUser:" + username);
        System.out.print("----"+username);
        return username;
    }

//    @Path("save")
//    @POST
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public void saveUser(@FormParam("id") String id,
//                         @FormParam("username") String username, @Context HttpServletRequest request,
//                         @Context HttpServletResponse response) {
//        log.debug("id:{}, username:{}", id, username);
//        log.debug("request:{}, response:{}", request, response);
//    }

    @POST
    @Path("/allusers")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUser(@FormParam(value = "param") String param)  {
        logger.info("UserResource getAllUser:"+param);
        UserParam userParam = JSON.parseObject(param, UserParam.class);
        System.out.print("----"+userParam.getName());
        User u = new User();
        u.setId(1111L);
        u.setName("wwww");

        logger.info("UserResource getAllUser:"+param);
        return JSON.toJSON(u).toString();
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(@QueryParam("n") int n) {
//        if (n > 10) {
//            throw new ServiceException(ExceptionCode.MUST_BE_LESS_THAN_10);
//        }

        userService.getStr(n);
        //http://redhacker.iteye.com/blog/1924071
        return n+"";
    }

    @POST
    @Path("/update")
    @Produces("application/json")
    public String update(@FormParam(value = "a1") String a1, @FormParam(value = "a2") String a2) {

        System.out.println(a1);
        System.out.println(userService.getStr(1));
//        if (a1.equals("a1111")) {
//            throw new ServiceException(ExceptionCode.MUST_BE_LESS_THAN_10);
//        }
        //redisClient.set("2","2");
        logger.info("UserResource update:{}","ss");
        return "11";
    }

    @GET
    @Path("/requestTest")
    @Produces("application/json")
    public String update(@Context HttpServletRequest request) {

        System.out.println("request:" + request.getParameter("a11"));
        System.out.println("request:" + request.getParameter("a22"));
        System.out.println("request:" + request.getQueryString());

        return "22";
    }

}