package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pojo.RequestPojo;

public class RequestDaoImpl implements RequestDao {

	@Override
	public List<RequestPojo> viewAllRequest() {
		List<RequestPojo> allRequests = new ArrayList<RequestPojo>();
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM request_details;";
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				RequestPojo requestPojo = new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				allRequests.add(requestPojo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allRequests;
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) {
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO request_details(user_id, type, request_amount, status) VALUES("
					+ requestPojo.getuserId() + "," + requestPojo.getReqType() + "," + requestPojo.getReqAmount()+",1) RETURNING req_id";
			
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				requestPojo.setReqId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestPojo;
	}

	@Override
	public List<RequestPojo> viewPendingRequest() {
		List<RequestPojo> requestList = new ArrayList<RequestPojo>();
		Connection conn = DBUtil.obtainConnection();

		try {
			// adding any filters or sorting orders.
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM request_details WHERE status=1";
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				requestList.add(new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3),
						rs.getInt(4), rs.getString(5), rs.getString(6),
						rs.getInt(7), rs.getInt(8)));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return requestList;
	}


	@Override
	public RequestPojo deleteRequest(int reqId) {
		RequestPojo reqPojo = null;
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			reqPojo = fetchARequest(reqId);
			
			String query = "DELETE FROM request_details WHERE req_id="+reqId;
			int rows = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reqPojo;
	}

	@Override
	public RequestPojo fetchARequest(int reqId) {
		RequestPojo reqPojo = null;
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM request_details WHERE req_id="+reqId;
			
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				reqPojo = new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reqPojo;
	}

	@Override
	public RequestPojo reviewRequest(int reqId, int status) {
		List<RequestPojo> pendingList = new ArrayList<RequestPojo>();
		RequestPojo reqPojo = null;
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			//String query = "SELECT * FROM request_details WHERE req_id="+reqId;
			//ResultSet rs = stmt.executeQuery(query);
			pendingList = viewPendingRequest();
			Iterator<RequestPojo> itr = pendingList.iterator();
			while(itr.hasNext()) {
				reqPojo = itr.next();
				if(reqPojo.getReqId() == reqId) {
					String query1 = "UPDATE request_details SET status="+status+"WHERE req_id="+reqId;
					int row1 = stmt.executeUpdate(query1);
					reqPojo.setReqStatus(status);
					break;
				}
			}
//			if (rs.next()) {
//				int reqStatus = rs.getInt(8);
//				if(reqStatus == 1)
//					case 1: //pending status
//						String query1 = "UPDATE request_details SET status="+status+"WHERE req_id="+reqId;
//						int row1 = stmt.executeUpdate(query1);
//						break;
//					case 2: 
//				}
//					
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return reqPojo;
	}

}
