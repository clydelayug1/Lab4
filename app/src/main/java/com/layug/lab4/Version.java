package com.layug.lab4;



public class Version {
    int logo;
    String company, country, industry, ceo, description;

    public Version(int logo, String company, String country, String industry, String ceo, String description) {
        this.logo = logo;
        this.company = company;
        this.country = country;
        this.industry = industry;
        this.ceo = ceo;
        this.description = description;
    }

    public int getLogo(){
        return logo;
    }

    public String getCompany() {
        return company;
    }

    public String getCountry(){
        return country;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCeo() {
        return ceo;
    }
    public String getDescription() {
        return description;
    }

}

