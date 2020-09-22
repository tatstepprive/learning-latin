package org.home.latin.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="word")
public class Word {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name_nl")
    private String nameNl;

    @Column(name="first_column_lat")
    private String firstColumnLat;

    @Column(name="second_column_lat")
    private String secondColumnLat;

    @Column(name="gender")
    private String gender;

    @Column(name="type")
    private String type;

    @Column(name="image_path")
    private String imagePath;

    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(
            name="test_word",
            joinColumns = @JoinColumn(name="word_id"),
            inverseJoinColumns = @JoinColumn(name="test_id")
    )
    List<Test> tests;

    public Word() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameNl() {
        return nameNl;
    }

    public void setNameNl(String nameNl) {
        this.nameNl = nameNl;
    }

    public String getFirstColumnLat() {
        return firstColumnLat;
    }

    public void setFirstColumnLat(String firstColumnLat) {
        this.firstColumnLat = firstColumnLat;
    }

    public String getSecondColumnLat() {
        return secondColumnLat;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", nameNl='" + nameNl + '\'' +
                ", firstColumnLat='" + firstColumnLat + '\'' +
                ", secondColumnLat='" + secondColumnLat + '\'' +
                ", gender='" + gender + '\'' +
                ", type='" + type + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
