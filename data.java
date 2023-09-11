package application;

import java.io.InputStream;

public final class data {
		  
		  private String user;
		  private String userID;
		  private InputStream profilePicture;
		public InputStream getProfilePicture() {
			return profilePicture;
		}

		public void setProfilePicture(InputStream inputStream) {
			this.profilePicture = inputStream;
		}

		private final static data INSTANCE = new data();
		  
		  private data() {}
		  
		  public static data getInstance() {
		    return INSTANCE;
		  }
		  
		  public void setUser(String u) {
		    this.user = u;
		  }
		  
		  public String getUser() {
		    return this.user;
		  }

		public String getUserID() {
			return userID;
		}

		public void setUserID(String userID) {
			this.userID = userID;
		}
		}
