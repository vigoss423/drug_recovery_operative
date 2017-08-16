package com.blueocean.web.pharmacymanage.service;

import java.util.List;

import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.dto.DrugRecycleSiteDo;
import com.blueocean.web.pharmacymanage.entity.PharmacyRequestDTO;
import com.blueocean.web.pharmacymanage.entity.PharmacyResponseDTO;
import com.blueocean.web.pharmacymanage.entity.SiteInRangeDTO;


public interface PharmacyManageInfo {

	/**
	 * 新建回收点
	 */
	int addSite(DrugRecycleSiteDo record);

	/**
	 * 编辑回收点
	 */
	int updateSite(DrugRecycleSiteDo record);;

	/**
	 * 根据id查订单详情
	 * 
	 * @param id
	 * @return
	 */
	PharmacyResponseDTO getDrugRecycleInfo(Integer id);

	/**
	 * 查询account是否存在
	 * 
	 * @param account
	 * @return
	 */
	boolean selectExistAccount(String account);

	/**
	 * 根据经纬度查询药店列表
	 * 
	 * @param record
	 * @return
	 */
	List<SiteInRangeDTO> listPharmacyInRange(PharmacyRequestDTO record);

	/**
	 * 
	 * @author wangxinyu
	 * @time 2017年7月12日 下午5:52:02
	 * @params queryPharmacyServicelistDrugOrderByParams
	 * @todo 查询列表
	 */
	RetInfo queryPharmacyService(PharmacyRequestDTO record);

	/**
	 * 
	 * @author wangxinyu
	 * @time 2017年7月12日 下午5:56:29
	 * @params operatePharmacyService
	 * @todo TODO
	 */
	int operatePharmacyService(PharmacyRequestDTO record);
}
