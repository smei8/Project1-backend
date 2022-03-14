package service;

import java.util.List;

import dao.RequestDao;
import dao.RequestDaoImpl;
import exception.SystemException;
import pojo.RequestPojo;

public class RequestServiceImpl implements RequestService {

	RequestDao requestDao;
	
	public RequestServiceImpl() {
		requestDao = new RequestDaoImpl();
	}

	@Override
	public List<RequestPojo> viewAllRequest() throws SystemException {
		return requestDao.viewAllRequest();
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) throws SystemException {
		return requestDao.addRequest(requestPojo);
	}

	@Override
	public List<RequestPojo> viewPendingRequest() throws SystemException {
		return requestDao.viewPendingRequest();
	}

	@Override
	public RequestPojo reviewRequest(RequestPojo requestPojo) throws SystemException {
		return requestDao.reviewRequest(requestPojo);
	}

	@Override
	public RequestPojo deleteRequest(int reqId) throws SystemException {
		return requestDao.deleteRequest(reqId);
	}

	@Override
	public RequestPojo fetchARequest(int reqId) throws SystemException {
		return requestDao.fetchARequest(reqId);
	}

	@Override
	public List<RequestPojo> viewAllEpRequest(int userId) throws SystemException {
		return requestDao.viewAllEpRequest(userId);
	}

}
