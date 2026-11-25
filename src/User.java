public class User {
    private String userName;
    private final int userID;
    private String email;

    User(String userName, int userID, String email) {
        this.userName = userName;
        this.userID = userID;
        setEmail(email);
    }

    public void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.email = email;

    }

    public String getUserName() {

        return userName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return userName +
                "\nEMAIL>> " + email;
    }

    public int getUserID() {
        return userID;
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.length() < 5) {
            return false;
        }
        return email.matches("^[A-Za-z0-9._]+@gmail\\.com$");

    }


}