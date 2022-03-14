package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.SystemException;
import pojo.RequestPojo;

public class RequestDaoImpl implements RequestDao {

	public static final Logger LOG = LogManager.getLogger(RequestDaoImpl.class);

	@Override
	public List<RequestPojo> viewAllRequest() throws SystemException {
		LOG.info("Entered viewAllRequest() in DAO");

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
			throw new SystemException();
		}
		LOG.info("Exited viewAllRequest() in DAO");
		return allRequests;
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) throws SystemException {
		LOG.info("Entered addRequest() in DAO");

		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO request_details(user_id, type, request_amount, manager, status) VALUES("
					+ requestPojo.getuserId() + "," + requestPojo.getReqType() + "," + requestPojo.getReqAmount()+","+ requestPojo.getManager() +",1) RETURNING req_id";
			
			ResultSet rs = stmt.executeQuery(query);
			if (rs.next()) {
				requestPojo.setReqId(rs.getInt(1));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exited addRequest() in DAO");
		return requestPojo;
	}

	@Override
	public List<RequestPojo> viewPendingRequest() throws SystemException {
		LOG.info("Entered viewPendingRequest() in DAO");

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
			throw new SystemException();
		}
		LOG.info("Exited viewPendingRequest() in DAO");
		return requestList;
	}


	@Override
	public RequestPojo deleteRequest(int reqId) throws SystemException {
		LOG.info("Entered deleteRequest() in DAO");

		RequestPojo reqPojo = null;
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			reqPojo = fetchARequest(reqId);
			
			String query = "DELETE FROM request_details WHERE req_id="+reqId;
			int rows = stmt.executeUpdate(query);

		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exited deleteRequest() in DAO");
		return reqPojo;
	}

	@Override
	public RequestPojo fetchARequest(int reqId) throws SystemException {
		LOG.info("Entered fetchARequest() in DAO");

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
			throw new SystemException();
		}
		LOG.info("Exited fetchARequest() in DAO");
		return reqPojo;
	}
	
//	@Override
//	public RequestPojo reviewRequest(int reqId, int status) {
//		List<RequestPojo> pendingList = new ArrayList<RequestPojo>();
//		RequestPojo reqPojo = null;
//		Connection conn = DBUtil.obtainConnection();
//
//		try {
//			Statement stmt = conn.createStatement();
//			//String query = "SELECT * FROM request_details WHERE req_id="+reqId;
//			//ResultSet rs = stmt.executeQuery(query);
//			pendingList = viewPendingRequest();
//			Iterator<RequestPojo> itr = pendingList.iterator();
//			while(itr.hasNext()) {
//				reqPojo = itr.next();
//				if(reqPojo.getReqId() == reqId) {
//					String query1 = "UPDATE request_details SET status="+status+", approve_date=CURRENT_DATE WHERE req_id="+reqId;
//					int row1 = stmt.executeUpdate(query1);
//					reqPojo.setReqStatus(status);
//					break;
//				}
//			}
////			if (rs.next()) {
////				int reqStatus = rs.getInt(8);
////				if(reqStatus == 1)
////					case 1: //pending status
////						String query1 = "UPDATE request_details SET status="+status+"WHERE req_id="+reqId;
////						int row1 = stmt.executeUpdate(query1);
////						break;
////					case 2: 
////				}
////					
////			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return reqPojo;
//	}


	@Override
	public RequestPojo reviewRequest(RequestPojo requestPojo) throws SystemException {
		LOG.info("Entered reviewRequest() in DAO");

		List<RequestPojo> pendingList = new ArrayList<RequestPojo>();
		//RequestPojo reqPojo = null;
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			String query1 = "UPDATE request_details SET status="+requestPojo.getReqStatus()+", approve_date=CURRENT_DATE WHERE req_id="+requestPojo.getReqId();
			int row1 = stmt.executeUpdate(query1);
			//String query = "SELECT * FROM request_details WHERE req_id="+reqId;
			//ResultSet rs = stmt.executeQuery(query);
//			pendingList = viewPendingRequest();
//			Iterator<RequestPojo> itr = pendingList.iterator();
//			while(itr.hasNext()) {
//				reqPojo = itr.next();
//				if(reqPojo.getReqId() == reqid) {
//					
//					//reqPojo.setReqStatus(reqStatus);
//					break;
//				}
//			}
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
			throw new SystemException();
		}
		
		LOG.info("Exited reviewRequest() in DAO");
		return requestPojo;
	}

	@Override
	public List<RequestPojo> viewAllEpRequest(int userId) throws SystemException {
		LOG.info("Entered viewAllRequest() in DAO");

		List<RequestPojo> allEpRequests = new ArrayList<RequestPojo>();
		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM request_details WHERE user_id="+userId;
			
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				RequestPojo requestPojo = new RequestPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				allEpRequests.add(requestPojo);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}
		LOG.info("Exited viewAllRequest() in DAO");
		return allEpRequests;
	}
	

	

}
