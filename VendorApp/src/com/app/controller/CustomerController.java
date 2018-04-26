package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;

@Controller
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@Autowired
	private CodeUtil codeUtil;

	@Autowired
	private CodecUtil codecUtil;

	@Autowired
	private CommonUtil commonUtil;

	@RequestMapping("/regCust")
	public String showCustReg() {
		return "CustomerReg";
	}

	@RequestMapping(value = "/insertCust")
	public String saveCust(@ModelAttribute("cust") Customer customer,
			ModelMap map) {

		String pwd = codeUtil.generatePwd();
		String tkn = codeUtil.generateToken();

		customer.setCustPwd(codecUtil.doEncode(pwd));
		customer.setCustToken(codecUtil.doEncode(tkn));

		int custId = service.saveCustomer(customer);

		if (custId != 0) {
			String text = "Welcome to customer (" + customer.getCustType()
					+ ")" + " your password is : " + pwd + "token is : 	" + tkn
					+ "user name is " + customer.getCustEmail();
			commonUtil.sendMail(customer.getCustEmail(),
					"registered customer name is : ", text);
		}

		/**
		 * call to utility method
		 */
		map.addAttribute("msg", "saving customer with id: " + custId);

		return "CustomerReg";
	}
}
