package restaurant;

public class Login {
	public String aname="Harinitha";
    public String apwd="2103";
   public boolean admin(user u) {
if(u.getLname().equals(aname) && u.getPassword().equals(apwd)) {
  return true;
}
else {
return false;  
}
   }
}

