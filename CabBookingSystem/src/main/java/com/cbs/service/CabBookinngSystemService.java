package com.cbs.service;

import java.util.List;

import com.cbs.exceptions.CabBookingException;
import com.cbs.model.Admin;
import com.cbs.model.Cab;
import com.cbs.model.Employee;

public interface CabBookinngSystemService {

	String adminRegisterService(Admin admin) throws CabBookingException;// Insert

	String adminLoginService(Integer adminId, String password) throws CabBookingException;

	String empRegisterService(Employee employee) throws CabBookingException;

	String empLoginService(Integer employeeId, String password) throws CabBookingException;

	String addCab(Cab cab) throws CabBookingException;

	List<Cab> viewAvailableCabs() throws CabBookingException;

	String requestCab(String cabId) throws CabBookingException, Exception;

	List<Cab> viewRegistereCabs();

	Cab approveCabRequest(String cabNumber) throws CabBookingException;

}
