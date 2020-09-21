package org.home.latin.domain;

public class PostedWord {
    private Long id;
    private String nameNl;
    private String firstColumnLat;
    private String secondColumnLat;
    private String gender;
    private String type;
    private String imagePath;

    //zelfstandig naamwoord = noun type

    public PostedWord(Long id, String nameNl,String firstColumnLat, String secondColumnLat, String gender, String type, String imagePath) {
        this.id=id;
        this.nameNl = nameNl;
        this.firstColumnLat = firstColumnLat;
        this.secondColumnLat = secondColumnLat;
        this.gender=gender;
        this.type = type;
        this.imagePath = imagePath;
    }

    public PostedWord(String nameNl) {
        this.nameNl = nameNl;
    }

    public PostedWord() {
    }

    public String getNameNl() {
        return nameNl;
    }

    public String getType() {
        return type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getSecondColumnLat() {
        return secondColumnLat;
    }

    public void setNameNl(String nameNl) {
        this.nameNl = nameNl;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setSecondColumnLat(String secondColumnLat) {
        this.secondColumnLat = secondColumnLat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstColumnLat() {
        return firstColumnLat;
    }

    public void setFirstColumnLat(String firstColumnLat) {
        this.firstColumnLat = firstColumnLat;
    }

    @Override
    public String toString() {
        return "PostedWord{" +
                "nameNl='" + nameNl + '\'' +
                ", firstColumnLat='" + firstColumnLat + '\'' +
                ", secondColumnLat='" + secondColumnLat + '\'' +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
