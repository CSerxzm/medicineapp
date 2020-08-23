package com.xzm.medicineapp.dao;

import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.mapper.MedicineMapper;
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

    public List<Medicine> getMedicines(){
        return medicineMapper.getMedicines();
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
}
