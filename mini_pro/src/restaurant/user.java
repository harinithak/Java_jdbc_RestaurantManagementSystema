package restaurant;

public class user {
	 private String lname;
	    private String password;
	    public user() {
	   
	    }
	    public user(String lname,String password) {
	    super();
	    this.lname=lname;
	    this.password=password;
	    }
	    public void setlname(String lname) {
	    this.lname=lname;
	    }
	   
	    public String getLname() {
	return lname;
	}
	public void setpassword(String password) {
	    this.password=password;
	    }
	public String getPassword() {
	return password;
	}
	@Override
	public String toString() {
	return "user [lname=" + lname + ", password=" + password + "]";
	}

}
