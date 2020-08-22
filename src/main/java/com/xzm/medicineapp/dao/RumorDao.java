package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.mapper.RumorMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class RumorDao {

    @Resource
    public RumorMapper rumorMapper;

    public Rumor getRumorById(Integer id){
        return rumorMapper.getRumorById(id);
    }
    public List<Rumor> getRumors(){
        return rumorMapper.getRumors();
    }
}
