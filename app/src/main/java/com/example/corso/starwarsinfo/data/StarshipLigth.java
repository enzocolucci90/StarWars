package com.example.corso.starwarsinfo.data;

public class StarshipLigth {

    String starshipName;
    String starshipModel;
    String starshipManufacturer;
    String starshipCostInCredits;
    String starshipLength;

    public StarshipLigth() {
    }

    public StarshipLigth(String starshipName, String starshipModel, String starshipManufacturer, String starshipCostInCredits, String starshipLength) {
        this.starshipName = starshipName;
        this.starshipModel = starshipModel;
        this.starshipManufacturer = starshipManufacturer;
        this.starshipCostInCredits = starshipCostInCredits;
        this.starshipLength = starshipLength;
    }

    public String getStarshipName() {
        return starshipName;
    }

    public void setStarshipName(String starshipName) {
        this.starshipName = starshipName;
    }

    public String getStarshipModel() {
        return starshipModel;
    }

    public void setStarshipModel(String starshipModel) {
        this.starshipModel = starshipModel;
    }

    public String getStarshipManufacturer() {
        return starshipManufacturer;
    }

    public void setStarshipManufacturer(String starshipManufacturer) {
        this.starshipManufacturer = starshipManufacturer;
    }

    public String getStarshipCostInCredits() {
        return starshipCostInCredits;
    }

    public void setStarshipCostInCredits(String starshipCostInCredits) {
        this.starshipCostInCredits = starshipCostInCredits;
    }

    public String getStarshipLength() {
        return starshipLength;
    }

    public void setStarshipLength(String starshipLength) {
        this.starshipLength = starshipLength;
    }
}
