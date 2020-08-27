package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Forum;
import com.xzm.medicineapp.bean.Prescr;
import com.xzm.medicineapp.mapper.ForumMapper;
import com.xzm.medicineapp.mapper.PrescrMapper;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class PrescrDao {

    @Resource
    public PrescrMapper prescrMapper;

    public Prescr getPrescrById(Integer id){
        return  prescrMapper.getPrescrById(id);
    }
    public List<Prescr> getPrescrs(PageModel pageModel){
        return  prescrMapper.getPrescrs(pageModel);
    }

    public Integer addPrescr(Prescr prescr){
        return prescrMapper.addPrescr(prescr);
    }
    public Integer delPrescr(Integer id){
        return prescrMapper.delPrescr(id);
    }
    public Integer updatePrescr(Prescr prescr){
        return prescrMapper.updatePrescr(prescr);
    }

    public Integer getCount(){
        return prescrMapper.getCount();
    }
}
