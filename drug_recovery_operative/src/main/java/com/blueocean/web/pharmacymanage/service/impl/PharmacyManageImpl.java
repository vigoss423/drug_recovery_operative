package com.blueocean.web.pharmacymanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.blueocean.common.constant.PharmacyConstant;
import com.blueocean.common.util.DateUtil;
import com.blueocean.common.util.JsonSerializUtil;
import com.blueocean.common.util.RetInfoUtil;
import com.blueocean.common.util.StringUtil;
import com.blueocean.common.util.ValidUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.dao.DrugOrderDoMapper;
import com.blueocean.web.pharmacymanage.dao.DrugRecycleSiteDoMapper;
import com.blueocean.web.pharmacymanage.dto.DrugRecycleSiteDo;
import com.blueocean.web.pharmacymanage.entity.PharmacyRequestDTO;
import com.blueocean.web.pharmacymanage.entity.PharmacyResponseDTO;
import com.blueocean.web.pharmacymanage.entity.PositionDTO;
import com.blueocean.web.pharmacymanage.entity.SiteInRangeDTO;
import com.blueocean.web.pharmacymanage.service.PharmacyManageInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class PharmacyManageImpl implements PharmacyManageInfo {

	@Resource
	private DrugRecycleSiteDoMapper drugRecycleSiteDoMapper;
	@Resource
	private DrugOrderDoMapper drugOrderDoMapper;

	@Override
	public int addSite(DrugRecycleSiteDo record) {
		// 账户名排重
		boolean isExit = selectExistAccount(record.getAccount());
		if (isExit) {
			return 0;
		}
		PositionDTO pos = JsonSerializUtil.jsonToJava(record.getAutoPosition(), PositionDTO.class);
		record.setLat(pos.getLat());
		record.setLng(pos.getLng());
		drugRecycleSiteDoMapper.insertSelective(record);
		return 1;
	}

	@Override
	public int updateSite(DrugRecycleSiteDo record) {
		DrugRecycleSiteDo drs = drugRecycleSiteDoMapper.selectByPrimaryKey(Integer.valueOf(record.getId()));
		if (null == drs) {
			throw new RuntimeException("该药店不存在!");
		}
		PositionDTO pos = JsonSerializUtil.jsonToJava(record.getAutoPosition(), PositionDTO.class);
		record.setLat(pos.getLat());
		record.setLng(pos.getLng());
		return drugRecycleSiteDoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public RetInfo queryPharmacyService(PharmacyRequestDTO record) {
		Map<String, Object> params = checkParams(record);
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		PageHelper.startPage(record.getPage(), record.getPageSize());
		List<PharmacyResponseDTO> pharmacyLst = drugRecycleSiteDoMapper.listPharmacyByParams(params);
		//获取总数
		Page<PharmacyResponseDTO> listCountry = (Page<PharmacyResponseDTO>)pharmacyLst;
		Long count = listCountry.getTotal();
		ret.setTotal(count);
		if(!StringUtil.isNullOrEmpty(pharmacyLst)){
			ret.setData(pharmacyLst);
		}
		return ret;
	}

	@Override
	public List<SiteInRangeDTO> listPharmacyInRange(PharmacyRequestDTO record) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("lng", record.getLng());
		params.put("lat", record.getLat());
		List<SiteInRangeDTO> list = drugRecycleSiteDoMapper.listPharmacyInRange(params);
		return list;
	}

	@Override
	public int operatePharmacyService(PharmacyRequestDTO record) {
		DrugRecycleSiteDo drs = drugRecycleSiteDoMapper.selectByPrimaryKey(Integer.valueOf(record.getId()));
		if (null == drs) {
			throw new RuntimeException("该药店不存在!");
		}
		if(drs.getAccount().equals("admin")){
			throw new RuntimeException("权限不足!");
		}
		int status = record.getPharmacyStatus();
		int id = drs.getId();
		DrugRecycleSiteDo site = installPharmacyParams(status, id);
		
		int result = drugRecycleSiteDoMapper.updateByPrimaryKeySelective(site);
		return result;
	}

	private DrugRecycleSiteDo installPharmacyParams(int status, int id) {
		DrugRecycleSiteDo site = new DrugRecycleSiteDo();
		site.setId(id);
		if (status == 0) {
			site.setIsActive("0");
		} else {
			site.setIsActive("1");
		}
		site.setGmtModified(DateUtil.currentDate());
		return site;
	}

	private Map<String, Object> checkParams(PharmacyRequestDTO record) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if (!ValidUtil.isNullOrBlank(record.getId())) {
			paramsMap.put("id", record.getId());
		}
		if (!ValidUtil.isNullOrBlank(record.getSiteName())) {
			paramsMap.put("siteName", record.getSiteName());
		}
		if (null != record.getPharmacyStatus()) {
			paramsMap.put("PharmacyStatus", record.getPharmacyStatus().toString());
		}
		return paramsMap;

	}

	@Override
	public PharmacyResponseDTO getDrugRecycleInfo(Integer id) {
		DrugRecycleSiteDo drs = drugRecycleSiteDoMapper.selectByPrimaryKey(id);
		if (null == drs) {
			throw new RuntimeException("该药店不存在!");
		}
		DrugRecycleSiteDo sitedo = drugRecycleSiteDoMapper.selectByPrimaryKey(id);
		PharmacyResponseDTO sitedto = new PharmacyResponseDTO();
		BeanUtils.copyProperties(sitedo, sitedto);
		sitedto.setSiteType(String.valueOf(sitedo.getSiteType()));
		sitedto.setSiteTypeName(PharmacyConstant.SiteTypeName(sitedo.getSiteType()));
		return sitedto;
	}

	/**
	 * 账户是否存在校验
	 */
	@Override
	public boolean selectExistAccount(String account) {
		List<DrugRecycleSiteDo> list = drugRecycleSiteDoMapper.selectExistAccount(account);
		boolean res = list == null || list.size() == 0 ? false : true;
		return res;
	}

}
