package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.dao.MedicineDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    public Medicine getMedicineById(Integer id){
        Medicine result = medicineDao.getMedicineById(id);
        return result;
    }

    public List<Medicine> getMedicines(){
        return medicineDao.getMedicines();
    }

    public Integer addMedicine(Medicine medicine){
        return medicineDao.addMedicine(medicine);
    }
    public Integer delMedicine(Integer id){
        return medicineDao.delMedicine(id);
    }
    public Integer updateMedicine(Medicine medicine){
        return medicineDao.updateMedicine(medicine);
    }
}
