package com.itheima.service;

import com.itheima.domain.Door;
import com.itheima.domain.Furniture;
import com.itheima.domain.Lamp;
import com.itheima.domain.Sensor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

//@Transactional(propagation = Propagation.REQUIRES_NEW)
@Transactional
public interface HomeService {

    public boolean save(Furniture furniture,String kind);
    public boolean delete(String name,String kind,String username);

    public List<Furniture>getbyplace(String place,String username);

    public List<Furniture>getall(String username);

    public Lamp getLamp(String name,String username);

    public Sensor getSensor(String name, String username);

    public Door getDoor(String name, String username);

    public boolean update(Furniture furniture,String kind);

    public boolean updatelamp(Lamp lamp);
}
