package tw.org.iii.customer;


public class CCustomer {
    private String account;
    private String name;
    private String phone;
    private String email;
    private String address;

    public CCustomer(String account, String name, String phone, String email, String address) {
        this.account = account;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
