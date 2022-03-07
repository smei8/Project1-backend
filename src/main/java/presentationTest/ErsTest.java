package presentationTest;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import pojo.RequestPojo;
import pojo.UserPojo;
import service.RequestService;
import service.RequestServiceImpl;
import service.UserService;
import service.UserServiceImpl;


public class ErsTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UserService userService = new UserServiceImpl();
		RequestService requestService = new RequestServiceImpl();
		
//		System.out.println("*********************************************************************************************************");
//		System.out.println("This is fetch all employee account");
//		
//		
//		List<UserPojo> allEmployees = userService.fetchAllAccounts();
//		Iterator<UserPojo> itr = allEmployees.iterator();
//		
//		while(itr.hasNext()) {
//			UserPojo employee = itr.next();
//			System.out.format("%10s %20s %20s %20s\n",
//					employee.getUserID(), employee.getUsername(), employee.getFullName(), employee.getEmail());
//		}
//		System.out.println("*********************************************************************************************************");
//		System.out.println("*********************************************************************************************************");
//		System.out.println("This is fetch all pending request");
//		
//		
//		List<RequestPojo> allRequests = requestService.viewPendingRequest();
//		Iterator<RequestPojo> itr = allRequests.iterator();
//		
//		while(itr.hasNext()) {
//			RequestPojo request = itr.next();
//			System.out.format("%10s %20s %20s %20s\n",
//					request.getReqId(), request.getEp(), request.getReqType(), request.getReqAmount(), request.getSubmitDate(), request.getApproveDate(), request.getManager(), request.getReqStatus());
//		}
//		System.out.println("*********************************************************************************************************");

//		System.out.println("*********************************************************************************************************");
//		System.out.println("this is fetch a account");
//		System.out.println("enter the user id: ");
//		Scanner scan = new Scanner(System.in);
//
//		int aUser = scan.nextInt();
//		UserPojo fetchaAccount = userService.fetchAAccount(aUser);
//		
//		System.out.println("User ID: " + fetchaAccount.getUserID());
//		System.out.println("Username: " + fetchaAccount.getUsername());
//		System.out.println("Password: " + fetchaAccount.getPassword());
//		System.out.println("Full Name: " + fetchaAccount.getFullName());
//		System.out.println("Email Address: " + fetchaAccount.getEmail());	
//		
//		System.out.println("*********************************************************************************************************");
//		System.out.println("this is fetch a request");
//		System.out.println("enter req id: ");
//
//		int aReq = scan.nextInt();
//		RequestPojo fetchaRequest = requestService.deleteRequest(aReq);
//		
//		System.out.println("Request ID: " + fetchaRequest.getReqId());
//		System.out.println("Ep Id: " + fetchaRequest.getEp());
//		System.out.println("Type: " + fetchaRequest.getReqType());
//		System.out.println("Amount: " + fetchaRequest.getReqAmount());
//		System.out.println("Status:" + fetchaRequest.getReqStatus());
//		System.out.println("Request deleted successfully!");
//		System.out.println("*********************************************************************************************************");
//		System.out.println("enter the user id: ");
//		int updateUserId = scan.nextInt();
//		
//		UserPojo fetchOldAcc = userService.fetchAAccount(updateUserId);
//
//		System.out.println("Enter new password: ");
//		scan.nextLine();
//		fetchOldAcc.setPassword(scan.nextLine());
//		
//		userService.updateAccount(fetchOldAcc);
//		
////		
////		System.out.println("Enter new full name: ");
////		fetchOldAcc.setFullName(scan.nextLine());
////		scan.nextLine();
////		userService.updateAccount(fetchOldAcc);
//		System.out.println("Account updated successfully!");
		System.out.println("*********************************************************************************************************");
		System.out.println("List of all pending request");
		int oldstatus = 0;
		List<RequestPojo> allPending = requestService.viewPendingRequest();
		
		Iterator<RequestPojo> itr = allPending.iterator();
		while(itr.hasNext()) {
			RequestPojo reqPojo = itr.next();
			oldstatus = reqPojo.getReqStatus();
		}
		
		
		System.out.println("Enter req id you would like to approve/denie: ");
		int reqId = scan.nextInt();

		System.out.println("Approve or Denie (2/3): ");
		int newStatus = scan.nextInt();

		//RequestPojo fetchedPending = requestService.reviewRequest(RequestrequestPojo);

		//System.out.println("Account updated successfully!");
//		
//		System.out.println("*********************************************************************************************************");
//		System.out.println("This is fetch all request");
//		
//		List<RequestPojo> allRequests = requestService.viewAllRequest();
//		Iterator<RequestPojo> itr = allRequests.iterator();
//		
//		while(itr.hasNext()) {
//			RequestPojo request = itr.next();
//			System.out.format("%10s %20s %20s %20s\n",
//					request.getReqId(), request.getEp(), request.getReqType(), request.getReqAmount(), request.getSubmitDate(), request.getApproveDate(), request.getManager(), request.getReqStatus());
//		}
//		System.out.println("*********************************************************************************************************");
//		System.out.println("this is add request");
//		
//		RequestPojo newRequest = new RequestPojo();
//		
//		System.out.println("enter ep id: ");
//		newRequest.setEp(scan.nextInt());
//		System.out.println("Enter request type: ");
//		newRequest.setReqType(scan.nextInt());
//
//		System.out.println("Enter request amount: ");
//		newRequest.setReqAmount(scan.nextInt());
//		
//		newRequest.setManager(1);
//		newRequest.setReqStatus(1);
//		
//		RequestPojo addedRequest = requestService.addRequest(newRequest);
//		
//		System.out.println("*********************************************************************************************************");
////		System.out.println("Request ID" + "\t" + "User Id" + "\t" + "Type + "\t" + "Amount" + "\t" + "submit date" + "\t" + "approve date" + "\t" + "manager" + "\t" + "status");
//		System.out.println("*********************************************************************************************************");
//		System.out.println("Book was added successfully!\nYou Request ID is " + addedRequest.getReqId());
//	
	}

}
