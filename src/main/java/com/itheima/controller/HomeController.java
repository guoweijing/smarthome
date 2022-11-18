package com.itheima.controller;

import com.itheima.domain.*;
import com.itheima.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houses")

public class HomeController {

    @Autowired
    private HomeService homeService;

    @PostMapping
    public Result save(@RequestBody Furniture furniture){
        boolean flag;
        String kind  = furniture.getKind();
        System.out.println(kind);
        flag = homeService.save(furniture,kind);
        System.out.println(flag);
        return new Result(flag ? Code.SAVE_OK:Code.SAVE_ERR,flag);
    }

    @DeleteMapping("/{name}/{kind}/{username}")
    public Result delete(@PathVariable String name, @PathVariable String kind,@PathVariable String username){
        boolean flag = homeService.delete(name,kind,username);
        return new Result(flag ? Code.DELETE_OK:Code.DELETE_ERR,flag);
    }

    @GetMapping("/{name}/{kind}/{username}")
    public Result get(@PathVariable String name, @PathVariable String kind,@PathVariable String username){
        switch(kind){
            case "Lamp"->{
                //System.out.println(name +" " +username);
                Lamp lamp = homeService.getLamp(name,username);
                Integer code = lamp !=null ? Code.GET_OK :Code.GET_ERR;
                String msg = lamp != null ? "" : "数据查询失败，请重试！";
                return new Result(code,lamp,msg);
            }
            case "Sensor"->{
                Sensor sensor = homeService.getSensor(name,username);
                Integer code = sensor !=null ? Code.GET_OK :Code.GET_ERR;
                String msg = sensor != null ? "" : "数据查询失败，请重试！";
                return new Result(code,sensor,msg);
            }
            case "Door"->{
                Door door = homeService.getDoor(name,username);
                Integer code = door !=null ? Code.GET_OK :Code.GET_ERR;
                String msg = door != null ? "" : "数据查询失败，请重试！";
                return new Result(code,door,msg);
            }
        }
        return null;
    }

    @GetMapping("/{username}/{place}")
    public Result getbyplace(@PathVariable String place, @PathVariable String username){
        List<Furniture>furnitureList = homeService.getbyplace(place,username);
        Integer code = furnitureList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = furnitureList != null ? "" : "数据查询失败，请重试！";
        return new Result(code,furnitureList,msg);
    }
    @GetMapping("/{username}")
    public Result getAll(@PathVariable String username) {
       // System.out.println("get");
        List<Furniture> furnitureList = homeService.getall(username);
        Integer code = furnitureList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = furnitureList != null ? "" : "数据查询失败，请重试！";
        return new Result(code,furnitureList,msg);
    }
    @PutMapping
    public Result update(@RequestBody Furniture furniture) {
        boolean flag = homeService.update(furniture,furniture.getKind());
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @PutMapping
    @RequestMapping("/lamp")
    public Result update(@RequestBody Lamp lamp) {
        boolean flag = homeService.updatelamp(lamp);
        return new Result(flag ? Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }

}
