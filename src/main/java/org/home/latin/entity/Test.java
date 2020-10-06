package org.home.latin.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="test")
public class Test {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="date")
    private Date date;

    @Column(name="start_index")
    private Integer startIndex;

    @Column(name="end_index")
    private Integer endIndex;

    @Column(name="number_words")
    private Integer numberWords;

    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinTable(
            name="test_word",
            joinColumns = @JoinColumn(name="test_id"),
            inverseJoinColumns = @JoinColumn(name="word_id")
    )
    private List<Word> words;

    public Test() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public Integer getNumberWords() {
        return numberWords;
    }

    public void setNumberWords(Integer numberWords) {
        this.numberWords = numberWords;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public void addWord(Word word) {
        if (words == null) {
            words = new ArrayList<>();
        }
        words.add(word);
    }

    public Word getWordToTest() {
        if (words == null) {
            System.out.println("No words, nothing to go next");
            return null;
        }
      return words.listIterator().next();
    }

    public void removeWord(Word word) {
        if (words == null) {
            System.out.println("No words, nothing to remove");
            return;
        }
        for(Word myWord: words){
            if(word.getId()==myWord.getId()){
                System.out.println("Removing word="+word);
                words.remove(word);
            }
        }
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", numberWords=" + numberWords +
                ", words=" + words +
                '}';
    }
}
