package com.itheima.service.impl;

import com.itheima.dao.DoorDao;
import com.itheima.dao.HomeDao;
import com.itheima.dao.LampDao;
import com.itheima.dao.SensorDao;
import com.itheima.domain.Door;
import com.itheima.domain.Furniture;
import com.itheima.domain.Lamp;
import com.itheima.domain.Sensor;
import com.itheima.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;

    @Autowired
    private LampDao lampDao;

    @Autowired
    private DoorDao doorDao;

    @Autowired
    private  SensorDao sensorDao;

    @Override
    public boolean save(Furniture furniture,String kind) {
        boolean flag1 =  homeDao.insertone(furniture)>0;
        boolean flag2 = false;
        switch (kind) {
            case "Lamp"->{
                Lamp lamp = new Lamp(furniture.getName(),furniture.getPlace(),furniture.getUsername());
                 flag2 = lampDao.insertlamp(lamp)>0;
            }
            case "Sensor"->{
                Sensor sensor = new Sensor(furniture.getName(),furniture.getPlace(),furniture.getUsername());
                flag2 = sensorDao.insertsensor(sensor)>0;
            }
            case "Door"->{
                Door door = new Door(furniture.getName(),furniture.getPlace(),furniture.getUsername());
                flag2 = doorDao.insertdoor(door)>0;
            }

        }
        return flag1 && flag2;
    }

    @Override
    public boolean delete(String name, String kind,String username) {
        boolean flag1 = homeDao.deletebyname(name, username)>0;
        boolean flag2 = false;
        switch (kind) {
            case "Lamp"->{
                flag2 = lampDao.deletelamp(name,username)>0;
            }
            case "Sensor"->{
                flag2 = sensorDao.deletesensor(name,username)>0;
            }
            case "Door"->{
                flag2 = doorDao.deletedoor(name,username)>0;
            }
        }
        return flag1 && flag2;
    }

    @Override
    public List<Furniture> getbyplace(String place, String username) {
        return homeDao.selectbyplace(place,username);
    }

    @Override
    public List<Furniture> getall(String username) {
        return homeDao.selectall(username);
    }

    @Override
    public Lamp getLamp(String name, String username) {
         return lampDao.selectlamp(name,username);
    }

    @Override
    public Sensor getSensor(String name, String username) {
        return sensorDao.selectsensor(name,username);
    }

    @Override
    public Door getDoor(String name, String username) {
        return doorDao.selectdoor(name,username);
    }

    @Override
    public boolean update(Furniture furniture, String kind) {
        boolean flag1 = homeDao.update(furniture)>0;
        return flag1;
    }

    @Override
    public boolean updatelamp(Lamp lamp) {
        return lampDao.updatelamp(lamp)>0;
    }

}
