//package com.samsundot.invoice.controller;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Set;
//
//import javax.transaction.Transactional;
//
//import org.apache.commons.codec.binary.Base64;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.samsundot.invoice.bean.Ordermains;
//import com.samsundot.invoice.bean.Stu;
//import com.samsundot.invoice.bean.Ter;
//import com.samsundot.invoice.repository.OrdermainsRepository;
//import com.samsundot.invoice.repository.StuRepository;
//import com.samsundot.invoice.repository.TerRepository;
//import com.samsundot.invoice.repository.UserRepository;
//import com.samsundot.invoice.utils.ResultVOUtil;
//
//@RestController
//public class TestController {
//
//	@Autowired
//	private OrdermainsRepository ordermainsRepository;
//	@Autowired
//	private TerRepository terRepository;
//	@Autowired
//	private StuRepository stuRepository;
//	@Autowired
//	private UserRepository userrepository;
//
//	public static void main(String[] args) {
//		// BASE64Decoder decoder = new BASE64Decoder();
//		//
//		// byte[] asBytes =
//		// Base64.getDecoder().decode("PHA+55Sz6K+35Lq677ya546L5aicCjwvcD48cD5RUe+8mjg3NjQ5MjE5Mgo8L3A+PHA+55Sz6K+354mI5Z2X77ya5omL5py657qv5YeA5ZCO5Y+w6L+Q6KGM5ZKM5rWB55WF5bqm5o+Q5Y2HCjwvcD48cD7lr7nnlLPor7fniYjlnZfnmoTlu7rorq7lkozmg7Pms5XvvJrmiYvmnLrlkI7lj7Doh6rliqjov5DooYznqIvluo/lpKrnuYHnkJDmi4nmhaLnvZHpgJ/vvIzlubbkuJTkvb/nlKjlubTpmZDlop7plb/kvJrkuKXph43ljaHjgII8L3A+PHA+PGJyPjwvcD4=");
//		// System.out.println(new String(asBytes, "utf-8")); // 输出为: some string
//		//
//		// System.out.println(new String(decoder.decodeBuffer(encodedText),
//		// "UTF-8"))
//
//		System.out.println(decodeStr(
//				"PHA+55Sz6K+35Lq677ya546L5aicCjwvcD48cD5RUe+8mjg3NjQ5MjE5Mgo8L3A+PHA+55Sz6K+354mI5Z2X77ya5omL5py657qv5YeA5ZCO5Y+w6L+Q6KGM5ZKM5rWB55WF5bqm5o+Q5Y2HCjwvcD48cD7lr7nnlLPor7fniYjlnZfnmoTlu7rorq7lkozmg7Pms5XvvJrmiYvmnLrlkI7lj7Doh6rliqjov5DooYznqIvluo/lpKrnuYHnkJDmi4nmhaLnvZHpgJ/vvIzlubbkuJTkvb/nlKjlubTpmZDlop7plb/kvJrkuKXph43ljaHjgII8L3A+PHA+PGJyPjwvcD4="));
//
//	}
//
//	public static String decodeStr(String encodeStr) {
//		byte[] b = encodeStr.getBytes();
//		Base64 base64 = new Base64();
//		b = base64.decode(b);
//		String s = new String(b);
//		return s;
//	}
//
//	@GetMapping("/test/{id}")
//	public Object test(@PathVariable(value = "id") String id) {
//		Ordermains Ordermains = ordermainsRepository.findOne(id);
//		return ResultVOUtil.success(Ordermains);
//	}
//
//	@GetMapping("/queryter")
//	public Object queryTer(String id) {
//		Ter ter = terRepository.findOne(id);
//		Set<Stu> list = ter.getStuList();
//		return ResultVOUtil.success(ter);
//	}
//
//	@GetMapping("/querystu1")
//	public Object queryStu() {
//		Stu stu = stuRepository.findOne("1");
//		return ResultVOUtil.success(stu);
//	}
//	@Transactional
//	@PutMapping("/updateage")
//	public void updateAge(String ids) {
//		String[] strs = ids.split(",");
//		List<String> list = Arrays.asList(strs);
//		userrepository.updateAge(list);
//	}
//
//}
