package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.util.PageModel;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface MedicineMapper {

    public Medicine getMedicineById(Integer id);
    public List<Medicine> getMedicines(PageModel pageModel);
    public Integer addMedicine(Medicine medicine);
    public Integer delMedicine(Integer id);
    public Integer updateMedicine(Medicine medicine);
    public Integer getCount();
}
