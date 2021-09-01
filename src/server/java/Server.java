package server.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import javabeans.Login;
import javabeans.ProfileInfo;
import javabeans.Profiles;
import javabeans.UserDetails;

import java.awt.Color;

public class Server {
	private ServerSocket serverSocket;
	private int PORT;
	private boolean isServerOn;
	private Socket client;
	private static JTextPane log;
	private static StyledDocument styledDocument;
	private static Style style;
	public static Color error, success;

	public Server(int port) {
		// Server.log = log;
		PORT = port;
		// error = Color.RED;
		// success = Color.GREEN;
		// style = log.addStyle("Style", null);
		try {
			// isServerOn = true;

			serverSocket = new ServerSocket(PORT);
			serverSocket.setReuseAddress(true);
			// Server Started
			logWriter("Server Started", success);
			while (true) {
				client = serverSocket.accept();
				RequestHandler clientRequest = new RequestHandler(client);
				new Thread(clientRequest).start();
			}
		} catch (Exception e) {
			// Server Errors
			logWriter("Server Error : " + e, error);
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
					// Server Stopped
					logWriter("Server Stopped", error);
				} catch (Exception e) {
					// Server Stop error
					logWriter("Error Stopping Server : " + e, error);
				}
			}
		}
	}

	public void stopServer() {
		isServerOn = false;
	}

	public static void logWriter(String log, Color type) {
		try {
			// styledDocument = Server.log.getStyledDocument();
			// style.addAttribute(StyleConstants.Foreground, type);
			// styledDocument.insertString(Server.log.getText().length(), " " + log + "\n",
			// style);
			System.out.println(log);
		} catch (Exception e) {

		}
	}

	private class RequestHandler implements Runnable {
		private final Socket clientSocket;
		Database db;

		public RequestHandler(Socket socket) {
			this.clientSocket = socket;
			db = new Database();
		}

		@Override
		public void run() {
			Login login = null;
			DataInputStream request = null;
			ObjectOutputStream response = null;
			ObjectInputStream objectRequest = null;
			try {
				request = new DataInputStream(clientSocket.getInputStream());
				String req = request.readUTF();
				// Client Request
				logWriter(req + " request from " + clientSocket.getInetAddress().getHostAddress(), success);
				switch (req) {
					case "REGISTER": // Register
						objectRequest = new ObjectInputStream(clientSocket.getInputStream());
						UserDetails registerDetails = (UserDetails) objectRequest.readObject();
						login = db.register(registerDetails);
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(login);
						break;
					case "LOGIN": // Login
						objectRequest = new ObjectInputStream(clientSocket.getInputStream());
						login = (Login) objectRequest.readObject();
						login = db.login(login.getUserName(), login.getPassword());
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(login);
						break;
					case "UPDATE": // Update
						objectRequest = new ObjectInputStream(clientSocket.getInputStream());
						UserDetails updateDetails = (UserDetails) objectRequest.readObject();
						login = db.update(updateDetails);
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(login);
						break;
					case "DELETE": // Delete
						objectRequest = new ObjectInputStream(clientSocket.getInputStream());
						login = (Login) objectRequest.readObject();
						boolean isSuccess = db.delete(login.getUserID());
						login = isSuccess ? login : null;
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(login);
						break;
					case "USERNAME": // Check Username
						DataInputStream user = new DataInputStream(clientSocket.getInputStream());
						String username = user.readUTF();
						DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
						output.writeUTF(db.isUsernameExsist(username) ? "true" : "false");
						break;
					case "FILTER": // Filter
						DataInputStream userFilter = new DataInputStream(clientSocket.getInputStream());
						String filter = userFilter.readUTF();
						Profiles filteredProfiles = db.filter(filter);
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(filteredProfiles);
						break;
					case "DETAIL": // User Request For profile using ID
						DataInputStream userDetailReq = new DataInputStream(clientSocket.getInputStream());
						int id = Integer.parseInt(userDetailReq.readUTF());
						UserDetails userDetails = db.getUserDetails(id);
//						System.out.println(userDetails.getProfileInfo().getAge());
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(userDetails);
						break;
					case "ID_SET_TO_PROFILES":
						objectRequest = new ObjectInputStream(clientSocket.getInputStream());
						Profiles profiles = (Profiles) objectRequest.readObject();
						profiles.setProfiles(new HashSet<ProfileInfo>());
						for (int userId : profiles.getIds()) {
							profiles.getProfiles().add(db.profileInfo(userId));
						}
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(profiles);
						break;
					case "PAIR_REQUEST": // Pair Request
						DataInputStream userPairReq = new DataInputStream(clientSocket.getInputStream());
						String pairReq[] = userPairReq.readUTF().split(" ");
						int userId = Integer.parseInt(pairReq[0]);
						int targetId = Integer.parseInt(pairReq[1]);
						boolean remove = pairReq[2].equals("0");

						ProfileInfo userInfo = db.profileInfo(userId);
						if (remove)
							userInfo.getRequestedPair().remove(targetId);
						else
							userInfo.getRequestedPair().add(targetId);
						db.profileInfo(userInfo, true);

						ProfileInfo targetInfo = db.profileInfo(targetId);
						if (remove)
							targetInfo.getPairRequest().remove(userId);
						else
							targetInfo.getPairRequest().add(userId);
						db.profileInfo(targetInfo, true);

						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(userInfo);
						break;
					case "ACCEPT_PAIR": // Accept Pair
						DataInputStream userPairAccept = new DataInputStream(clientSocket.getInputStream());
						String accepted[] = userPairAccept.readUTF().split(" ");
						int userIdA = Integer.parseInt(accepted[0]);
						int targetIdA = Integer.parseInt(accepted[1]);
						boolean removeA = accepted[2].equals("0");

						ProfileInfo userInfoA = db.profileInfo(userIdA);
						if (removeA)
							userInfoA.getAcceptedPair().remove(targetIdA);
						else {
							userInfoA.getAcceptedPair().add(targetIdA);
							userInfoA.getPairRequest().remove(targetIdA);
//							userInfoA.getRequestedPair().remove(targetIdA);
						}
						db.profileInfo(userInfoA, true);

						ProfileInfo targetInfoA = db.profileInfo(targetIdA);
						if (removeA)
							targetInfoA.getAcceptedPair().remove(userIdA);
						else {
							targetInfoA.getAcceptedPair().add(userIdA);
							targetInfoA.getRequestedPair().remove(userIdA);
//							targetInfoA.getPairRequest().remove(userIdA);
						}
						db.profileInfo(targetInfoA, true);

						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(userInfoA);
						break;
					case "DECLINE_PAIR": // Decline Pair
						DataInputStream userDeclineReq = new DataInputStream(clientSocket.getInputStream());
						String declineReq[] = userDeclineReq.readUTF().split(" ");
						int userIdD = Integer.parseInt(declineReq[0]);
						int targetIdD = Integer.parseInt(declineReq[1]);

						ProfileInfo userInfoD = db.profileInfo(userIdD);
						userInfoD.getRequestedPair().remove(targetIdD);
						userInfoD.getPairDeclined().add(targetIdD);
						db.profileInfo(userInfoD, true);

						ProfileInfo targetInfoD = db.profileInfo(targetIdD);
						targetInfoD.getPairRequest().remove(userIdD);
						db.profileInfo(targetInfoD, true);

						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(userInfoD);
						break;
					default: // Invalid
						response = new ObjectOutputStream(clientSocket.getOutputStream());
						response.writeObject(null);
				}
			} catch (Exception e) {
				// Client Request Error
				logWriter("Client Request Error : " + e, error);
			} finally {
				try {
					if(db!=null){
						db.close();
					}
					if (response != null)
						response.close();
					if (request != null) {
						request.close();
						clientSocket.close();
					}
				} catch (Exception e) {
					// Thread Closing Error
					logWriter("Thread Closing Error : " + e, error);
				}
			}
		}
	}

	public static void main(String[] arg) {
		new Server(3000);
	}
}
