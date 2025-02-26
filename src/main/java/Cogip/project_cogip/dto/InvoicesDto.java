package Cogip.project_cogip.dto;


import Cogip.project_cogip.entities.Invoices;

public class InvoicesDto {

    private int id;
    private float price;
    private String ref;
    private int companyId;

    public InvoicesDto() {}

    public InvoicesDto(int id, float price, String ref, int companyId) {
        this.id = id;
        this.price = price;
        this.ref = ref;
        this.companyId = companyId;
    }

    public InvoicesDto(float price, String ref, int companyId) {
        this.price = price;
        this.ref = ref;
        this.companyId = companyId;
    }

    public InvoicesDto(Invoices invoices) {
        this.id = invoices.getId();
        this.price = invoices.getPrice();
        this.ref = invoices.getRef();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
