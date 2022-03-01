/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author Moudhaffer
 */
public class User {
    private int userid;
    private String username;
    private String passwd;
    private String email;
    private String profileInfo;
    private String type;
    
    public User(){
        
    }

    public User(int userid) {
        this.userid = userid;
    }

    public User(int userid, String username,String passwd, String email, String profileInfo, String type) {
        this.userid = userid;
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.profileInfo = profileInfo;
        this.type = type;
    }

    public User(String username, String passwd, String email, String profileInfo, String type) {
        this.username = username;
        this.passwd = passwd;
        this.email = email;
        this.profileInfo = profileInfo;
        this.type = type;
    }
    

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public User(String username, String email, String profileInfo, String type) {
        this.username = username;
        this.email = email;
        this.profileInfo = profileInfo;
        this.type = type;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.userid;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return !(this.userid != other.userid && this.username != other.username);
    }

    @Override
    public String toString() {
        return "User{" + "userid=" + userid + ", username=" + username + ", email=" + email + ", profileInfo=" + profileInfo + ", type=" + type + '}';
    }
    
}
