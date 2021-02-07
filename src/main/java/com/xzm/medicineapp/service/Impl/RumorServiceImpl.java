package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.dao.RumorDao;
import com.xzm.medicineapp.service.RumorService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
@Transactional
public class RumorServiceImpl  implements RumorService {

    @Autowired
    private RumorDao rumorDao;

    public Rumor getRumorById(Integer id){
        return rumorDao.getRumorById(id);
    }
    public List<Rumor> getRumors(PageModel pageModel){
        Integer count = rumorDao.getCount();
        pageModel.setRecordCount(count);
        return rumorDao.getRumors(pageModel);
    }

    @Transactional
    public Integer addRumor(Rumor rumor){
        return rumorDao.addRumor(rumor);
    }

    @Transactional
    public Integer delRumor(Integer id){
        return rumorDao.delRumor(id);
    }

    @Transactional
    public Integer updateRumor(Rumor rumor){
        return rumorDao.updateRumor(rumor);
    }
}
