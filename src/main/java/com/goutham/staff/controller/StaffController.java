package com.goutham.staff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goutham.staff.entity.Staff;
import com.goutham.staff.repositary.StaffRepositary;



@Controller
public class StaffController {

	@Autowired
	private StaffRepositary srepo;
	
	@GetMapping({"/list", "/"})
	public ModelAndView getAllStaffs() {
		ModelAndView mav = new ModelAndView("list-staffs");
		mav.addObject("staffs", srepo.findAll());
		return mav;
	}
	
	@GetMapping("/addStaffForm")
	public ModelAndView addEmployeeForm() {
		ModelAndView mav = new ModelAndView("add-staff-form");
		Staff newStaff = new Staff();
		mav.addObject("staff", newStaff);
		return mav;
	}
	
	@PostMapping("/saveStaff")
	public String saveEmployee(@ModelAttribute Staff staff) {
		srepo.save(staff);
		return "redirect:/list";
	}
	
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam Long staffId) {
		ModelAndView mav = new ModelAndView("add-staff-form");
		Staff staff = srepo.findById(staffId).get();
		mav.addObject("staff", staff);
		return mav;
	}
	
	@GetMapping("/deleteStaff")
	public String deleteEmployee(@RequestParam Long staffId) {
		srepo.deleteById(staffId);
		return "redirect:/list";
	}
	
}
