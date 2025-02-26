package Cogip.project_cogip.dto;

import Cogip.project_cogip.entities.Companies;

public class CompanyGetDto {

    private int id;
    private String name;
    private String country;
    private String tva;
    private String typeName;

    public CompanyGetDto(Companies company) {
        this.id = company.getId();
        this.name = company.getName();
        this.country = company.getCountry();
        this.tva = company.getTva();
        this.typeName = company.getType().getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
