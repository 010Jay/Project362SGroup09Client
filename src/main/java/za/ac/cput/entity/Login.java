package za.ac.cput.entity;

/**
 * Login.java
 * Entity for the Login
 * Author: Jason Jaftha (217009301)
 * Date: 13 September 2021
 */

public class Login {

    //Attributes
        private String studentNumber;
        private String username;
        private String password;

    public Login(Builder builder) {
        this.studentNumber = builder.studentNumber;
        this.username = builder.username;
        this.password = builder.password;
    }

    public String getStudentNo() {
        return studentNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setStudentNo(String studentNo) {
        this.studentNumber = studentNo;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
                "studentNo=" + studentNumber +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder {

        //Attributes
            private String studentNumber;
            private String username;
            private String password;

        public Builder setStudentNo(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Login build()
        {
            return new Login(this);
        }

        public Builder copy(Login login)
        {
            this.studentNumber = login.studentNumber;
            this.username = login.username;
            this.password = login.password;

            return this;
        }
    }
}
