package lviv.university.committee.entities;

import javax.persistence.*;

@Entity
@Table(name = "rating_lists")
public class RatingList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @Column(name = "sum_subjects_grade")
    private int sumSubjectsGrade;

    @Column(name = "avg_certificate_mark")
    private int avgCertificateMark;

    @Column(name = "final_mark")
    private int finalMark;


    public RatingList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public int getSumSubjectsGrade() {
        return sumSubjectsGrade;
    }

    public void setSumSubjectsGrade(int sumSubjectsGrade) {
        this.sumSubjectsGrade = sumSubjectsGrade;
    }

    public int getAvgCertificateMark() {
        return avgCertificateMark;
    }

    public void setAvgCertificateMark(int avgCertificateMark) {
        this.avgCertificateMark = avgCertificateMark;
    }

    public int getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }
}
