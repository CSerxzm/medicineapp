package com.xzm.medicineapp.service.Impl;

import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.dao.MedicineDao;
import com.xzm.medicineapp.service.MedicineService;
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
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    public Medicine getMedicineById(Integer id) {
        Medicine result = medicineDao.getMedicineById(id);
        return result;
    }

    public List<Medicine> getMedicines(PageModel pageModel) {
        Integer count = medicineDao.getCount(null);
        pageModel.setRecordCount(count);
        return medicineDao.getMedicines(pageModel);
    }

    @Override
    public List<Medicine> searchMedicines(PageModel pageModel, String name) {
        Integer count = medicineDao.getCount(name);
        pageModel.setRecordCount(count);
        return medicineDao.searchMedicines(pageModel, name);
    }

    @Transactional
    public Integer addMedicine(Medicine medicine) {
        return medicineDao.addMedicine(medicine);
    }

    @Transactional
    public Integer delMedicine(Integer id) {
        return medicineDao.delMedicine(id);
    }

    @Transactional
    public Integer updateMedicine(Medicine medicine) {
        return medicineDao.updateMedicine(medicine);
    }
}
