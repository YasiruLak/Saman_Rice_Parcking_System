package model;

public class Driver {
    private String name;
    private String NIC;
    private String licenseNo;
    private String address;
    private Integer contact;

    public Driver() {
    }

    public Driver(String name, String NIC, String licenseNo, String address, Integer contact) {
        this.name = name;
        this.NIC = NIC;
        this.licenseNo = licenseNo;
        this.address = address;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return name;
    }
}


