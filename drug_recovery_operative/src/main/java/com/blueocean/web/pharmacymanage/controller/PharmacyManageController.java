package com.blueocean.web.pharmacymanage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.common.constant.RetInfoConstant;
import com.blueocean.common.util.RetInfoUtil;
import com.blueocean.common.util.StringUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.dto.DrugRecycleSiteDo;
import com.blueocean.web.pharmacymanage.dto.LoginUser;
import com.blueocean.web.pharmacymanage.dto.UserDto;
import com.blueocean.web.pharmacymanage.dto.ValidateUser;
import com.blueocean.web.pharmacymanage.entity.PharmacyRequestDTO;
import com.blueocean.web.pharmacymanage.entity.PharmacyResponseDTO;
import com.blueocean.web.pharmacymanage.entity.SiteInRangeDTO;
import com.blueocean.web.pharmacymanage.service.IUserService;
import com.blueocean.web.pharmacymanage.service.PharmacyManageInfo;

/**
 * 
 * @className com.bluesea.drugmanage.controller.DrugManageController.java
 * @author wangxinyu
 * @time 2017年7月12日 下午4:49:42
 * @todo TODO
 */
@RequestMapping(value = "PharmacyManageAction")
@RestController
public class PharmacyManageController {
	@Resource
	private PharmacyManageInfo pharmacyManageInfo;
	
	@Resource
	private IUserService userService;

	/**
	 * @author zhangyalin 添加回收站点
	 * 
	 * @return
	 */
	@RequestMapping(value = "addSite")
	public RetInfo addSite(@RequestBody DrugRecycleSiteDo record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		int res=pharmacyManageInfo.addSite(record);
		if(res==0) {
			ret.setErrorCode(RetInfoConstant.RETCODE_COMMON_ERROR);
			ret.setErrorMsg("该账户名已存在，请重新输入！");
		}
		return ret;
	}

	/**
	 * @author zhangyalin 编辑回收点
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateSite")
	public RetInfo updateSite(@RequestBody DrugRecycleSiteDo record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		int res = pharmacyManageInfo.updateSite(record);
		if (res <= 0)
			ret = RetInfoUtil.initRetInfo4Err();
		return ret;

	}

	/**
	 * @author zhangyalin 获取回收点详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "getDrugRecycleInfo")
	public RetInfo getDrugRecycleInfo(@RequestBody DrugRecycleSiteDo record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		PharmacyResponseDTO data = pharmacyManageInfo.getDrugRecycleInfo(record.getId());
		ret.setData(data);
		return ret;
	}

	/**
	 * @author zhangyalin 检测账户名称是否已存在
	 * 
	 * @return
	 */
	@RequestMapping(value = "checkExistAccount")
	public RetInfo checkExistAccount(@RequestBody DrugRecycleSiteDo record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		boolean res = pharmacyManageInfo.selectExistAccount(record.getAccount());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isExist", res);
		ret.setData(map);
		return ret;
	}

	/**
	 * 
	 * @author zhangyalin
	 * @time 2017年7月25日 下午5:23:04
	 * @params PharmacyRequestDTO
	 * @todo 根据经纬度查询药店列表
	 */
	@RequestMapping(value = "listSiteInRange")
	public RetInfo listSiteInRange(@RequestBody PharmacyRequestDTO record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		List<SiteInRangeDTO> PharmacyLst = pharmacyManageInfo.listPharmacyInRange(record);
		ret.setData(PharmacyLst);
		return ret;

	}

	/**
	 * 
	 * @author wangxinyu
	 * @time 2017年7月12日 下午5:23:04
	 * @params queryPharmacyList
	 * @todo 查询药店列表
	 */
	@RequestMapping(value = "queryPharmacyList")
	public RetInfo queryPharmacyList(@RequestBody PharmacyRequestDTO record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		ret = pharmacyManageInfo.queryPharmacyService(record);
		return ret;

	}

	@RequestMapping(value = "operatePharmacy")
	public RetInfo operatePharmacy(@RequestBody PharmacyRequestDTO record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		int operateResult = pharmacyManageInfo.operatePharmacyService(record);
		ret.setData(operateResult);
		return ret;
	}
	
	@RequestMapping(value = "queryUserBySessionId")
	public RetInfo queryUserBySessionId(@RequestParam("sessionId") String sessionId) {
		RetInfo ret = RetInfoUtil.initRetInfo4SuccTime();
		if(StringUtil.isNull(sessionId)){
			throw new RuntimeException(RetInfoConstant.RETMSG_PARAMS_NOVALID);
		}
		ValidateUser user = userService.checkUser(sessionId);
		ret.setData(user);
		return ret;
	}
	
	/**
	 * 登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "login")
	public RetInfo login(@RequestBody(required = false) LoginUser loginuser) {
		RetInfo retInfo=RetInfoUtil.initRetInfo4SuccTime();
		if(StringUtil.empty(loginuser.getUserName()) || StringUtil.empty(loginuser.getPassWord())){
			retInfo.setErrorCode(RetInfoConstant.RETCODE_UNKOWN_ERROR);
			retInfo.setErrorMsg("用户名密码不能为空!");
		}else{
		UserDto loginwithaccountpwd = userService.Loginwithaccountpwd(loginuser);
		
		if(loginwithaccountpwd==null){
			retInfo.setErrorCode(RetInfoConstant.RETCODE_UNKOWN_ERROR);
			retInfo.setErrorMsg("用户名或密码不正确");

		}
		retInfo.setData(loginwithaccountpwd);
		}
		return retInfo;
	}

}
