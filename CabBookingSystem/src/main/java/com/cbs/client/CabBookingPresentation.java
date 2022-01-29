package com.cbs.client;

import java.util.List;
import java.util.Scanner;

import com.cbs.dao.CabBookingDao;
import com.cbs.dao.ImplOfCabBookingDao;
import com.cbs.exceptions.CabBookingException;
import com.cbs.model.Admin;
import com.cbs.model.Cab;
import com.cbs.model.Employee;
import com.cbs.service.CabBookinngSystemService;
import com.cbs.service.CabBookinngSystemServiceImpl;

public class CabBookingPresentation {
	
	public static void main(String[] args) throws CabBookingException {
		
		CabBookinngSystemServiceImpl cabBookinngSystemServiceImpl = new CabBookinngSystemServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println(" Welcome to cabBookingSystem ");
		System.out.println("Please choose options from below ");
		int ch = 0;
		do {
			System.out.println("-----------------------------");
			System.out.println("1) Login as a Admin");
			System.out.println("2) Login as an Employee ");
			System.out.println("3) Admin registration");
			System.out.println("-----------------------------");
			try {
				ch = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (ch) {
			case 1: {// login as admin
				System.out.println("-----------------------------");
				System.out.println("        Admin Login           ");
				System.out.println("-----------------------------");
				System.out.println("Enter your admin id");
				Integer adminId = sc.nextInt();
				System.out.println("Enter your username");
				String userName = sc.next();
				System.out.println("Enter your Password");
				String Password = sc.next();
				String success = null;
				try {
					success = cabBookinngSystemServiceImpl.adminLoginService(adminId, Password);
				} catch (CabBookingException e) {
					e.printStackTrace();
				}
				if ("Login Success".equalsIgnoreCase(success)) {
					System.out.println("-----------------------------");
					System.out.println("Logged-in as: " + adminId);
					System.out.println("-----------------------------");
					System.out.println("Select from below options");
					int op = 0;
					do {
						System.out.println("1.add employees");
						System.out.println("2.add cab detals");
						System.out.println("3.view all cab detals");
						System.out.println("4.Approve request");
						try {
							op = Integer.parseInt(sc.next());
						} catch (NumberFormatException e) {
						}
						switch (op) {
						case 1: {// add Employees
							System.out.println("Employee Registration");
							Employee emp = new Employee();
							System.out.println("enter employee Id");
							emp.setId(sc.nextInt());// sc.nextLine()
							System.out.println("Enter employee Name");
							emp.setName(sc.next());
							System.out.println("Enter employee email");
							emp.setEmail(sc.next());
							System.out.println("Enter employee password");
							emp.setPassword(sc.next());
							System.out.println("Enter employee department");
							emp.setDepartment(sc.next());
							try {
								cabBookinngSystemServiceImpl.empRegisterService(emp);
							} catch (CabBookingException e) {
								System.out.println(e);
							}
							break;
						}

						case 2: {// add cab details
							Cab cab = new Cab();
							System.out.println("enter cab Id");
							cab.setCabId(sc.nextInt());// sc.nextLine()
							System.out.println("Please enter cab number");
							cab.setCabNumber(sc.next());
							System.out.println("Please enter driver name");
							cab.setDriverName(sc.next());
							System.out.println("Please enter driver phone number");
							cab.setDriverNumber(sc.next());
							System.out.println("whether the cab is booked");
							cab.setCabIsBooked(sc.next());
							try {
								cabBookinngSystemServiceImpl.addCab(cab);
							} catch (CabBookingException e) {
								System.out.println("Excpetion occured ading cab " + e);
							}
							break;
						}
						case 3: {// view all cab details
							System.out.println("total registered cabs are");
							cabBookinngSystemServiceImpl.viewRegistereCabs();

							System.out.println("total available cabs are");
							try {
								cabBookinngSystemServiceImpl.viewAvailableCabs();

							} catch (CabBookingException e) {
								e.printStackTrace();
							}

							break;
						}
						case 4: {// approve request for a cab
							System.out.println("enter the cab no to book a cab");
							String c = sc.next();
							cabBookinngSystemServiceImpl.approveCabRequest(c);

							break;
						}
						default: {
							System.out.println("enter valid option");
							break;
						}
						}
						System.out.println("enter any key");
						op = sc.nextInt();
					} while (op != 4);
				} else {
					System.out.println("Invalid Credentials");
				}
				break;
			}
			case 2: {// employee login
				Employee emp = new Employee();
				System.out.println("-----------------------------");
				System.out.println("      Employee Login           ");
				System.out.println("-----------------------------");
				ImplOfCabBookingDao book = new ImplOfCabBookingDao();
				System.out.println("Enter Employee id");
				Integer Id = sc.nextInt();
				System.out.println("Enter Employee Password");
				String Password = sc.next();
				String success = null;
				try {
					success = cabBookinngSystemServiceImpl.empLoginService(Id, Password);
				} catch (CabBookingException e) {
					e.printStackTrace();
				}
				if ("Employee ln successfully".equalsIgnoreCase(success)) {
					System.out.println("-----------------------------");
					System.out.println("Logged-in as: " + Id);
					System.out.println("-----------------------------");
					System.out.println("Select from below options");
					System.out.println("-----------------------------");
					int x = 0;
					do {
						System.out.println("1.Book a cab");
						try {
							x = Integer.parseInt(sc.next());
						} catch (NumberFormatException e) {
						}
						switch (x) {

						case 1: {// book a cab{
							ImplOfCabBookingDao bookingDao = new ImplOfCabBookingDao();
							System.out.println("enter cab number that you want to book");
							String cabNumber = sc.next();
							try {
								cabBookinngSystemServiceImpl.requestCab(cabNumber);
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						}
						default: {
							System.out.println("you are an employee");
							break;
						}
						}
					} while (x != 3);
					System.out.println("......................");
				} else {
					System.out.println("Invalid Credentials");
				}
				break;
			}
			case 3: {// Admin registration
				ImplOfCabBookingDao book = new ImplOfCabBookingDao();
				System.out.println("Admin Registration");
				Admin admin = new Admin();
				System.out.println("enter adminId");
				admin.setAdminID(Integer.parseInt(sc.nextLine()));
				System.out.println("Enter Admin Name");
				admin.setUserName(sc.next());
				System.out.println("Enter admin password");
				admin.setPassword(sc.next());

				try {
					cabBookinngSystemServiceImpl.adminRegisterService(admin);
				} catch (CabBookingException e) {
					System.out.println(e);
				}
				break;
			}

			default: {
				System.out.println("....");
				break;
			}
			}
			System.out.println("press any key to continue");
			ch = sc.nextInt();
		} while (ch != 5);
	}
}
