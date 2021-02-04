package com.xzm.medicineapp.mapper;

import com.xzm.medicineapp.bean.Health;
import com.xzm.medicineapp.bean.Medicine;
import com.xzm.medicineapp.util.PageModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 3052
 * @create 2020-08-21 21:05
 */

public interface MedicineMapper {

    Medicine getMedicineById(Integer id);
    List<Medicine> getMedicines(PageModel pageModel);
    List<Medicine> searchMedicines(@Param("firstLimitParam") Integer firstLimitParam,
                                   @Param("pageSize") Integer pageSize,
                                   @Param("name") String name);
    Integer addMedicine(Medicine medicine);
    Integer delMedicine(Integer id);
    Integer updateMedicine(Medicine medicine);
    Integer getCount(String name);
}
