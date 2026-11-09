public class User {
    private String userName;
    private final int userID;
    private String email;

    User(String userName, int userID, String email) {
        this.userName = userName;
        this.userID = userID;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }
    public String toString(){
        return userName+
                "\nEMAIL>> "+email;
    }
    public int getUserID(){
        return userID;
    }


}