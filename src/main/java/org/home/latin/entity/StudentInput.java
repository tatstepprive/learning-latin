package org.home.latin.entity;


import javax.persistence.*;

@Entity
@Table(name="student_input")
public class StudentInput {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_column_lat")
    private String firstColumnLat;

    @Column(name="second_column_lat")
    private String secondColumnLat;

    @Column(name="gender")
    private String gender;

    public StudentInput(){

    }

    public StudentInput(Word word){
         this.setFirstColumnLat(word.getFirstColumnLat());
         this.setSecondColumnLat(word.getSecondColumnLat());
         this.setGender(word.getGender());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAllLat(){
        return getFirstColumnLat().concat(" ").concat(getSecondColumnLat()).concat(" (").concat(getGender()).concat(") ");
    }
    @Override
    public String toString() {
        return "StudentInput{" +
                "id=" + id +
                ", firstColumnLat='" + firstColumnLat + '\'' +
                ", secondColumnLat='" + secondColumnLat + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
