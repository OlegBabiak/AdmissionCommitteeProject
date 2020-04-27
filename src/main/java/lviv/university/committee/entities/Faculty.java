package lviv.university.committee.entities;

import javax.persistence.*;

@Entity
@Table(name = "faculties")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "faculty_name")
    private String name;
    private int numberOfPlace;
    private int numberOfSocialPlace;

    public Faculty() {
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

    public int getNumberOfPlace() {
        return numberOfPlace;
    }

    public void setNumberOfPlace(int numberOfPlace) {
        this.numberOfPlace = numberOfPlace;
    }

    public int getNumberOfSocialPlace() {
        return numberOfSocialPlace;
    }

    public void setNumberOfSocialPlace(int numberOfSocialPlace) {
        this.numberOfSocialPlace = numberOfSocialPlace;
    }
}
