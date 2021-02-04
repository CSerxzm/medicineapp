package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.dao.MedicineDao;
import com.xzm.medicineapp.service.MedicineService;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */
@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    public Medicine getMedicineById(Integer id){
        Medicine result = medicineDao.getMedicineById(id);
        return result;
    }

    public List<Medicine> getMedicines(PageModel pageModel){
        Integer count = medicineDao.getCount(null);
        pageModel.setRecordCount(count);
        return medicineDao.getMedicines(pageModel);
    }

    @Override
    public List<Medicine> searchMedicines(PageModel pageModel, String name) {
        Integer count = medicineDao.getCount(name);
        pageModel.setRecordCount(count);
        return medicineDao.searchMedicines(pageModel,name);
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
