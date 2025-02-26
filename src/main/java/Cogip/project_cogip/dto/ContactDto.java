package Cogip.project_cogip.dto;

import Cogip.project_cogip.entities.Contact;

public class ContactDto {


    private String name;
    private String phone;
    private String email;
    private int company_id;

    public ContactDto() {}

    public ContactDto(String name, String phone, String email, int company_id) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.company_id = company_id;
    }

    public ContactDto(Contact contact) {

        name = contact.getName();
        phone = contact.getPhone();
        email = contact.getEmail();
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

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }
}
