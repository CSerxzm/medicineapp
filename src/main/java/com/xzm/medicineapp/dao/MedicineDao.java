package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.mapper.MedicineMapper;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Repository
public class MedicineDao {

    @Resource
    public MedicineMapper medicineMapper;

    public Medicine getMedicineById(Integer id){
        return medicineMapper.getMedicineById(id);
    }

    public List<Medicine> getMedicines(PageModel pageModel){
        return medicineMapper.getMedicines(pageModel);
    }

    public Integer addMedicine(Medicine medicine){
        return medicineMapper.addMedicine(medicine);
    }
    public Integer delMedicine(Integer id){
        return medicineMapper.delMedicine(id);
    }
    public Integer updateMedicine(Medicine medicine){
        return medicineMapper.updateMedicine(medicine);
    }
    public Integer getCount(){
        return medicineMapper.getCount();
    }
}
