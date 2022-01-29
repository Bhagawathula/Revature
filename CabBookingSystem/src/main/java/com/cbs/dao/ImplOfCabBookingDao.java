package com.cbs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cbs.dbCon.DbConnection;
import com.cbs.exceptions.CabBookingException;
import com.cbs.model.Admin;
import com.cbs.model.Cab;
import com.cbs.model.Employee;
import com.cbs.service.CabBookinngSystemService;

public class ImplOfCabBookingDao implements CabBookingDao {

	@Override
	public String adminRegisterService(Admin admin) throws CabBookingException {
		int success = 0;
		try (Connection con = DbConnection.getConnection()) {
			String sql = "insert into admin values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, admin.getAdminID());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getUserName());
			success = ps.executeUpdate();
			System.out.println("Admin Successfully Registered");
		} catch (Exception e) {
			System.out.println(e);
		}
		return "success";
	}

	@Override
	public String empRegisterService(Employee emp) throws CabBookingException {
		int success = 0;
		try (Connection con = DbConnection.getConnection()) {
			String Query = "insert into Employee values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(Query);
			System.out.println("employee registration");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getEmail());
			ps.setString(3, emp.getName());
			ps.setString(4, emp.getPassword());
			ps.setString(5, emp.getDepartment());
			success = ps.executeUpdate();
			System.out.println("Employee Successfully Registered");
		} catch (Exception e) {
			System.out.println(e);
		}
		return "success";
	}

	@Override
	public String adminLoginService(Integer adminId, String adminPassword) throws CabBookingException {
		Admin admin = new Admin();
		int success = 0;
		try (Connection connection = DbConnection.getConnection()) {
			String Query1 = "select adminId,Password from Admin where adminId=? and Password=?";
			PreparedStatement ps = connection.prepareStatement(Query1);
			ps.setInt(1, adminId);
			ps.setString(2, adminPassword);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				System.out.println("login fail");
				return "Login failed";
			} else {
				System.out.println("login successful");
				return "Login Success";
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new CabBookingException("Internal Error");
		}

	}

	@Override
	public String empLoginService(Integer Id, String Password) throws CabBookingException {
		Employee emp = new Employee();
		int success = 0;
		try (Connection con = DbConnection.getConnection()) {
			String Query2 = "select Id,Password from Employee where Id=? and Password=?";
			PreparedStatement ps = con.prepareStatement(Query2);
			ps.setInt(1, Id);
			ps.setString(2, Password);
			ResultSet resultSet = ps.executeQuery();
			if (!resultSet.next()) {
				System.out.println("login fail");
				return "Employee login failed";
			} else {
				System.out.println("Successful login");
				return "Employee ln successfully";
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new CabBookingException("Internal Error");
		}

	}

	@Override
	public String addCab(Cab cab) throws CabBookingException {
		int success = 0;
		try (Connection con = DbConnection.getConnection()) {
			String sql = "insert into Cab values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cab.getCabId());
			ps.setString(2, cab.getCabNumber());
			ps.setString(3, cab.getDriverName());
			ps.setString(4, cab.getDriverNumber());
			ps.setString(5, cab.getCabIsBooked());
			success = ps.executeUpdate();
			System.out.println("Cab details are added successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
		return "Cab addedd successfully";
	}

	@Override
	public List<Cab> viewAvailableCabs() throws CabBookingException {
		List<Cab> listOfAvailableCabs = new ArrayList<>();
		try (Connection con = DbConnection.getConnection()) {
			String Query3 = "select *from Cab where cabIsBooked= 'notbooked' ";
			PreparedStatement ps = con.prepareStatement(Query3);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cab cab = new Cab();
				System.out.println(rs.getString("cabNumber") + "  " + rs.getString("driverName") + " "
						+ rs.getString("driverNumber") + " " + rs.getString("cabIsBooked"));
				cab.setCabId(rs.getInt("cabId"));
				cab.setCabNumber(rs.getString("cabNumber"));
				cab.setDriverName(rs.getString("driverName"));
				cab.setDriverNumber(rs.getString("driverNumber"));
				cab.setCabIsBooked(rs.getString("cabIsBooked"));
				listOfAvailableCabs.add(cab);
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new CabBookingException("Internal Error");
		}
		return listOfAvailableCabs;
	}

	@Override
	public String requestCab(String cabNumber) throws Exception {
		Cab cab = new Cab();
		int success = 0;
		try (Connection connection = DbConnection.getConnection()) {
			String sql = "select cabNumber,bookedStatus from Cab where cabNumber=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, cabNumber);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				System.out.println("Cab is not vailable");
				return "The requested cab not available or not exist for given cabNumber";
			} else {
				System.out.println("cab is available");
				return "The requested cab  available";

			}
		} catch (Exception e) {
			System.out.println(e);
			throw new CabBookingException("Internal Error");
		}
	}

	public Cab approveCabRequest(String cabNumber) throws CabBookingException {
		try (Connection con = DbConnection.getConnection()) {
			int flag = 0;
			String sql = "UPDATE Cab SET cabIsBooked = 'approve ' WHERE cabNumber=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cabNumber);
			flag = ps.executeUpdate();
			if (flag >= 1) {
				String Query3 = "select * from Cab  WHERE cabNumber=? ";
				PreparedStatement pts = con.prepareStatement(Query3);
				pts.setString(1, cabNumber);
				ResultSet rs = pts.executeQuery();
				while (rs.next()) {
					Cab cab = new Cab();
					System.out.println(rs.getString("cabNumber") + "  " + rs.getString("driverName") + " "
							+ rs.getString("driverNumber") + " " + rs.getString("cabIsBooked"));
					cab.setCabId(rs.getInt("cabId"));
					cab.setCabNumber(rs.getString("cabNumber"));
					cab.setDriverName(rs.getString("driverName"));
					cab.setDriverNumber(rs.getString("driverNumber"));
					cab.setCabIsBooked(rs.getString("cabIsBooked"));
					return cab;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new CabBookingException("Internal Error");
		}
		return null;
	}

	public List<Cab> viewRegistereCabs() {
		List<Cab> listOfAvailableCabs = new ArrayList<>();
		try (Connection con = DbConnection.getConnection()) {
			String Query3 = "select *from Cab where bookedStatus=false ";
			PreparedStatement ps = con.prepareStatement(Query3);
			ResultSet rs = ps.executeQuery();
			System.out.println("######### Featchig all register cabs deatils #########");
			while (rs.next()) {
				Cab cab = new Cab();
				System.out.println(rs.getString("cabNumber") + "  " + rs.getString("driverName") + " "
						+ rs.getString("driverNumber") + " " + rs.getString("cabIsBooked"));
				cab.setCabId(rs.getInt("cabId"));
				cab.setCabNumber(rs.getString("cabNumber"));
				cab.setDriverName(rs.getString("driverName"));
				cab.setDriverNumber(rs.getString("driverNumber"));
				cab.setCabIsBooked(rs.getString("cabIsBooked"));
				listOfAvailableCabs.add(cab);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return listOfAvailableCabs;
	}
}
