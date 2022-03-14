
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.SystemException;
import io.javalin.Javalin;

import pojo.RequestPojo;
import pojo.UserPojo;
import service.RequestService;
import service.RequestServiceImpl;
import service.UserService;
import service.UserServiceImpl;


public class ExpenseMain {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		RequestService requestService = new RequestServiceImpl();
		
		
		Javalin myServer = Javalin.create((config) -> config.enableCorsForAllOrigins()).start(4040);
		
		// User
		// fetchAllAccount
		myServer.get("/api/all/accounts", ctx -> {
			List<UserPojo> allAccouts = userService.fetchAllAccounts();
			ctx.json(allAccouts);
		});
		
		// fetchAAccount
		myServer.get("/api/accounts/{bid}", ctx -> {
			String userId = ctx.pathParam("bid");
			UserPojo fetchedAccount = userService.fetchAAccount(Integer.parseInt(userId));
			ctx.json(fetchedAccount);
		});
		
		// updateAccount
		myServer.put("/api/accounts", ctx -> {
			UserPojo updateAccount = ctx.bodyAsClass(UserPojo.class);
			UserPojo returnedUpdatedAccount = userService.updateAccount(updateAccount);
			ctx.json(returnedUpdatedAccount);
		});
		
		//login
		myServer.post("/api/login", (ctx) -> {
			// there is an incoming book json in the request body, fetching the request body
			// and storing it in newBook
			UserPojo newreq = ctx.bodyAsClass(UserPojo.class);

			// call the service
			UserPojo userGotFromDB = userService.login(newreq);
			ctx.json(userGotFromDB);
		});
		
/*-----------------------------------------------------------------------------------------------------------*/		
		// Request
		// viewAllRequest
		myServer.get("/api/all/requests", ctx -> {
			List<RequestPojo> allRequests = requestService.viewAllRequest();
			ctx.json(allRequests); 
		});
		
		//fetch all emp request
		myServer.get("/api/epRequests/{bid}", ctx -> {
			String userId = ctx.pathParam("bid");
			List<RequestPojo> allEpRequest = requestService.viewAllEpRequest(Integer.parseInt(userId));
			ctx.json(allEpRequest);
		});
		
		// fetchARequest
		myServer.get("/api/requests/{bid}", ctx -> {
			String reqId = ctx.pathParam("bid");
			RequestPojo fetchedRequest = requestService.fetchARequest(Integer.parseInt(reqId));
			ctx.json(fetchedRequest);
		});
				
		// addRequest
		myServer.post("/api/requests", ctx -> {
			RequestPojo newRequest = ctx.bodyAsClass(RequestPojo.class);
			RequestPojo returnedRequest = requestService.addRequest(newRequest);
			ctx.json(returnedRequest);
		});
		
		// viewPendingRequest
		myServer.get("/api/all/pendings", ctx -> {
			List<RequestPojo> allRequests = requestService.viewPendingRequest();
			ctx.json(allRequests); 
		});
		
		// reviewRequest
		myServer.put("/api/requests", ctx -> { //1-reqID 2-status
			RequestPojo updateStatus = ctx.bodyAsClass(RequestPojo.class);
//			String reqId = ctx.pathParam("bid1"); //reqID
//			String reqStatus = ctx.pathParam("bid2"); //status
			RequestPojo returnedUpdatedRequest = requestService.reviewRequest(updateStatus);
			ctx.json(returnedUpdatedRequest);
		});
		
		// deleteRequest
		myServer.delete("/api/request/{bid}", ctx -> {
			String reqId = ctx.pathParam("bid");
			RequestPojo deletedRequest = requestService.deleteRequest(Integer.parseInt(reqId));
			ctx.json(deletedRequest);
		});
		
		myServer.exception(SystemException.class, (se, ctx) -> {
			Map<String, String> error = new HashMap<String, String>();
			error.put("message", se.getMessage());
			error.put("datetime", LocalDateTime.now()+"");
			ctx.json(error);
		});
	}

}
