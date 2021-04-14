package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.mapper.RumorMapper;
import com.xzm.medicineapp.util.PageModel;
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

    public Rumor getRumorById(Integer id) {
        return rumorMapper.getRumorById(id);
    }

    public List<Rumor> getRumors(PageModel pageModel) {
        return rumorMapper.getRumors(pageModel);
    }

    public Integer addRumor(Rumor rumor) {
        return rumorMapper.addRumor(rumor);
    }

    public Integer delRumor(Integer id) {
        return rumorMapper.delRumor(id);
    }

    public Integer updateRumor(Rumor rumor) {
        return rumorMapper.updateRumor(rumor);
    }

    public Integer getCount() {
        return rumorMapper.getCount();
    }
}
