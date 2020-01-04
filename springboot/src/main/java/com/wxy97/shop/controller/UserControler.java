package com.wxy97.shop.controller;
import com.wxy97.shop.pojo.User;
import com.wxy97.shop.result.Result;
import com.wxy97.shop.result.ResultFactory;
import com.wxy97.shop.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @Author: wxySmile
 * @Date 20-1-3 下午7:07
 */
@RestController
public class UserControler {

    @Resource
    UserService userServiceImpl;
    /**
     * 分页查询
     * @param pagenum 页码
     * @param pagesize 每页条数
     * @return
     */
    @RequestMapping("users")
    public Result  getUsers(Integer pagenum,Integer pagesize){
        return ResultFactory.buildSuccessResult(userServiceImpl.getUserListByPage(pagenum,pagesize),"分页查询用户");
    }

    /**
     * 用户id存在修改 不存在添加用户
     * @param user 用户对象
     * @return
     */
    @RequestMapping(value ={"/u/update","/u/save"},method = RequestMethod.POST)
    public Result update(@RequestBody User user){
        User u = userServiceImpl.updateOrSave(user);
        return ResultFactory.buildSuccessResult(u,"操作成功");
    }
}