package service;

import java.util.List;

import dao.RequestDao;
import dao.RequestDaoImpl;
import pojo.RequestPojo;

public class RequestServiceImpl implements RequestService {

	RequestDao requestDao;
	
	public RequestServiceImpl() {
		requestDao = new RequestDaoImpl();
	}

	@Override
	public List<RequestPojo> viewAllRequest() {
		return requestDao.viewAllRequest();
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) {
		return requestDao.addRequest(requestPojo);
	}

	@Override
	public List<RequestPojo> viewPendingRequest() {
		return requestDao.viewPendingRequest();
	}

	@Override
	public RequestPojo reviewRequest(int reqId, int status) {
		return requestDao.reviewRequest(reqId, status);
	}

	@Override
	public RequestPojo deleteRequest(int reqId) {
		return requestDao.deleteRequest(reqId);
	}

	@Override
	public RequestPojo fetchARequest(int reqId) {
		return requestDao.fetchARequest(reqId);
	}

}
