package com.xzm.medicineapp.service;

import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.dao.MedicineDao;
import com.xzm.medicineapp.util.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:18
 */

public interface MedicineService {

    Medicine getMedicineById(Integer id);
    List<Medicine> getMedicines(PageModel pageModel);
    Integer addMedicine(Medicine medicine);
    Integer delMedicine(Integer id);
    Integer updateMedicine(Medicine medicine);

}
