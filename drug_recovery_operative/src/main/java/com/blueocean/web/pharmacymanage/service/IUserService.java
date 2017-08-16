package com.blueocean.web.pharmacymanage.service;

import com.blueocean.web.pharmacymanage.dto.LoginUser;
import com.blueocean.web.pharmacymanage.dto.UserDto;
import com.blueocean.web.pharmacymanage.dto.ValidateUser;

public interface IUserService {
	UserDto Loginwithaccountpwd(LoginUser loginuser);
	ValidateUser checkUser(String session);
	
	String selectCidByUid(Integer userid);
}
