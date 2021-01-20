package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Rumor;
import com.xzm.medicineapp.dao.RumorDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */

public interface RumorService {

    Rumor getRumorById(Integer id);
    List<Rumor> getRumors(PageModel pageModel);
    Integer addRumor(Rumor rumor);
    Integer delRumor(Integer id);
    Integer updateRumor(Rumor rumor);

}
