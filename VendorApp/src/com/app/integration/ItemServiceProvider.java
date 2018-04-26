package com.app.integration;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Customer;
import com.app.model.Item;
import com.app.service.ICustomerService;
import com.app.service.IItemService;
import com.app.util.JsonUtil;
import com.app.validator.CustomerValidator;

@Path("/itemService")
@Component
public class ItemServiceProvider {

	@Autowired
	private ICustomerService custService;

	@Autowired
	private CustomerValidator custValidator;

	@Autowired
	private IItemService itemService;

	@Autowired
	private JsonUtil<Item> jsonUtil;

	@POST
	@Path("/saveItem")
	public String saveItem(@HeaderParam("user") String un,
			@HeaderParam("password") String pwd,
			@HeaderParam("token") String token, String json) {
		boolean flag = false;

		if (un == null && "".equals(un.trim()))
			return "invalid or empty user name ";

		Customer cust = custService.getCustByMailId(un);

		if (cust == null)
			return "Username is invalid!";

		flag = custValidator.isValidCustforItemProcess(pwd, token, cust);
		if (!flag) {
			return "invalid authentication details(pwd,token)/invalid custtype for operation";
		}
		Item obj = (Item) jsonUtil.convertJsonToObj(json, Item.class);

		if (obj == null) {
			return "No item details found";

		}

		int itemId = itemService.saveItem(obj);

		if (itemId != 0) {
			return "Item saved with id: " + itemId;
		} else {
			return "item not saved";
		}
	}
}
