package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.util.CodecUtil;

@Component
public class CustomerValidator {

	@Autowired
	private CodecUtil codecUtil;

	private boolean isValidPwdandToken(String reqPwd, String reqToken,
			Customer cust) {
		boolean flag = false;

		String ePwd = cust.getCustPwd();
		String eToken = cust.getCustToken();

		String dbPwd = codecUtil.doDecode(ePwd);
		String dbToken = codecUtil.doDecode(eToken);

		if (dbPwd.equals(reqPwd) && dbToken.equals(reqToken)) {
			flag = true;
		}
		return flag;
	}

	public boolean isValidCustforItemProcess(String reqPwd, String reqToken,
			Customer cust) {
		boolean status = false;
		boolean flag = isValidPwdandToken(reqPwd, reqToken, cust);
		if (flag && cust.getCustType().equals("SELLER")) {
			status = true;
		}
		return status;
	}

	public boolean isValidCustforViewItem(String reqPwd, String reqToken,
			Customer cust) {
		boolean status = false;
		boolean flag = isValidPwdandToken(reqPwd, reqToken, cust);
		if (flag && cust.getCustType() != null
				&& cust.getCustType().equals("CONSUMER")
				|| cust.getCustType().equals("SELLER")) {
			status = true;
		}
		return status;
	}
}
