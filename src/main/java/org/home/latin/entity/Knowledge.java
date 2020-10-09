package org.home.latin.entity;


import javax.persistence.*;

@Entity
@Table(name="knowledge")
public class Knowledge {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "word_id")
    private Word word;

    @OneToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name = "student_input_id")
    private StudentInput studentInput;

    @Column(name="ok")
    private Boolean ok;

    public Knowledge(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }


    public StudentInput getStudentInput() {
        return studentInput;
    }

    public void setStudentInput(StudentInput studentInput) {
        this.studentInput = studentInput;
    }

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    @Override
    public String toString() {
        return "Knowledge{" +
                "id=" + id +
                ", test=" + test +
                ", word=" + word +
                ", studentInput=" + studentInput +
                ", ok=" + ok +
                '}';
    }
}
