package pojo;

public class RequestPojo {

	private int reqId;
	private int ep;
	private int reqType;
	private int reqAmount;
	private String submitDate;
	private String approveDate;
	private int manager;
	private int reqStatus;
	
	public RequestPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestPojo(int reqId, int ep, int reqType, int reqAmount, String submitDate, String approveDate,
			int reqStatus) {
		super();
		this.reqId = reqId;
		this.ep = ep;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.submitDate = submitDate;
		this.approveDate = approveDate;
		this.reqStatus = reqStatus;
	}

	public RequestPojo(int reqId, int ep, int reqType, int reqAmount, String submitDate, String approveDate,
			int manager, int reqStatus) {
		super();
		this.reqId = reqId;
		this.ep = ep;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.submitDate = submitDate;
		this.approveDate = approveDate;
		this.manager = manager;
		this.reqStatus = reqStatus;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getEp() {
		return ep;
	}

	public void setEp(int ep) {
		this.ep = ep;
	}

	public int getReqType() {
		return reqType;
	}

	public void setReqType(int reqType) {
		this.reqType = reqType;
	}

	public int getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(int reqAmount) {
		this.reqAmount = reqAmount;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(int reqStatus) {
		this.reqStatus = reqStatus;
	}

	@Override
	public String toString() {
		return "RequestPojo [reqId=" + reqId + ", ep=" + ep + ", reqType=" + reqType + ", reqAmount=" + reqAmount
				+ ", submitDate=" + submitDate + ", approveDate=" + approveDate + ", manager=" + manager
				+ ", reqStatus=" + reqStatus + "]";
	}
}
