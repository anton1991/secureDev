package module;

public class UserBean {
	  private String username;
      private String password;
      private String firstName;
      private String lastName;
      private String type;
      private String phone;
      private String address;
      public boolean valid;
      private String photo;
	
	
      public String getFirstName() {
         return firstName;
	}

      public void setFirstName(String newFirstName) {
         firstName = newFirstName;
	}

	
      public String getLastName() {
         return lastName;
			}

      public void setLastName(String newLastName) {
         lastName = newLastName;
			}
			

      public String getPassword() {
         return password;
	}

      public void setPassword(String newPassword) {
         password = newPassword;
	}
	
			
      public String getUsername() {
         return username;
			}

      public void setUserName(String newUsername) {
         username = newUsername;
			}

				
      public boolean isValid() {
         return valid;
	}

      public void setValid(boolean newValid) {
         valid = newValid;
	}	
      public String getType() {
          return type;
 	}

       public void setType(String newType) {
          type = newType;
 	}

        public String getPhoto() {
            return photo;
   	}

         public void setPhoto(String newPhoto) {
            photo = newPhoto;
   	}
         public String getPhone() {
             return phone;
    	}

          public void setPhone(String newPhone) {
             phone = newPhone;
    	}
          public String getAddress() {
              return address;
     	}

           public void setAddess(String newAddress) {
        	   address = newAddress;
     	}
}
