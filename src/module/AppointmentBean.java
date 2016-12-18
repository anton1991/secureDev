package module;

public class AppointmentBean {
	  private String email;
      private String firstName;
      private String lastName;
      private String phone;
      private String regarding;
      private String month;
      private String day;
      private String time;
      private String message;
	
	
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
			
	
			
      public String getEmail() {
         return email;
			}

      public void setEmail(String newEmail) {
    	  email = newEmail;
			}

				
      public String getMessage() {
         return message;
	}

      public void setMessage(String new_Message) {
    	  message = new_Message;
	}
      public String getPhone() {
          return phone;
 	}

       public void setPhone(String new_Phone) {
    	   phone = new_Phone;
 	}
       public String getRegarding() {
           return regarding;
  	}

        public void setRegarding(String new_Regarding) {
        	regarding = new_Regarding;
  	}
        public String getMonth() {
            return month;
   	}

         public void setMonth(String new_Month) {
        	 month = new_Month;
         }
         
         public String getDay() {
             return day;
    	}

          public void setDay(String new_Day) {
         	 day = new_Day;
          }
          public String getTime() {
              return time;
     	}

           public void setTime(String new_Time) {
          	 time = new_Time;
           }
  
   	
       

}
