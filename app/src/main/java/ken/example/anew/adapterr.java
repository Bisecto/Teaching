package ken.example.anew;

public class adapterr {
    private int id;
    private String firstname;
    private String lastname;
    private String mobile;
    private String email;
    private String about;

    public adapterr(int id, String firstname, String lastname, String mobile, String email, String about) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
        this.about = about;
    }

    @Override
    public String toString() {
        return "adapterr{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    public adapterr() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
