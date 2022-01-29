package com.cbs.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cbs.dao.ImplOfCabBookingDao;
import com.cbs.dbCon.DbConnection;
import com.cbs.exceptions.CabBookingException;
import com.cbs.model.Admin;
import com.cbs.model.Cab;
import com.cbs.model.Employee;

public class CabBookinngSystemServiceImpl implements CabBookinngSystemService {

	ImplOfCabBookingDao implOfCabBookingDao = new ImplOfCabBookingDao();

	@Override
	public String adminRegisterService(Admin admin) throws CabBookingException {
		return implOfCabBookingDao.adminRegisterService(admin);
	}

	@Override
	public String empRegisterService(Employee emp) throws CabBookingException {
		return implOfCabBookingDao.empRegisterService(emp);
	}

	@Override
	public String adminLoginService(Integer adminId, String adminPassword) throws CabBookingException {
		return implOfCabBookingDao.adminLoginService(adminId, adminPassword);

	}

	@Override
	public String empLoginService(Integer Id, String Password) throws CabBookingException {
		return implOfCabBookingDao.empLoginService(Id, Password);

	}

	@Override
	public String addCab(Cab cab) throws CabBookingException {
		return implOfCabBookingDao.addCab(cab);
	}

	@Override
	public List<Cab> viewAvailableCabs() throws CabBookingException {
		List<Cab> availableCabs = implOfCabBookingDao.viewAvailableCabs();
		for (Cab cab : availableCabs) {
			System.out.println(" ########## The list of all available cabs as below ############");
			System.out.println(" The Cab unique id is " + cab.getCabId());
			System.out.println(" The cab number  is " + cab.getCabNumber());
			System.out.println(" The Cab driver name is " + cab.getDriverName());
			System.out.println(" The Cab driver number is " + cab.getDriverNumber());

		}
		return availableCabs;
	}

	@Override
	public String requestCab(String cabNumber) throws Exception {
		return implOfCabBookingDao.requestCab(cabNumber);
	}

	@Override
	public Cab approveCabRequest(String cabNumber) throws CabBookingException {
		Cab updatedCab = implOfCabBookingDao.approveCabRequest(cabNumber);
		if (updatedCab != null) {
			System.out.println(" ########## updated cab details are below ############");
			System.out.println(" The updated Cab unique id is " + updatedCab.getCabId());
			System.out.println(" The updated  cab number  is " + updatedCab.getCabNumber());
			System.out.println(" The updated  Cab driver name is " + updatedCab.getDriverName());
			System.out.println(" The updated  Cab driver number is " + updatedCab.getDriverNumber());
			System.out.println(" Theu pdated status is " + updatedCab.getCabIsBooked());
		} else {
			System.out.println(" ########## The given cab number doesn't exist in data base ############");
		}
		return updatedCab;
	}

	@Override
	public List<Cab> viewRegistereCabs() {
		List<Cab> cabs = implOfCabBookingDao.viewRegistereCabs();

		for (Cab cab : cabs) {
			System.out.println(" ########## The list of all register cabs as below ############");
			System.out.println(" The Cab unique id is " + cab.getCabId());
			System.out.println(" The cab number  is " + cab.getCabNumber());
			System.out.println(" The Cab driver name is " + cab.getDriverName());
			System.out.println(" The Cab driver number is " + cab.getDriverNumber());

		}
		return cabs;
	}
}
