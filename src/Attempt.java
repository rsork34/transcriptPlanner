import univ.Course;

public class Attempt
{
    private Course course;
    private String semesterTaken;
    private String grade;
    private String status;

    public Attempt()
    {
        this.course = null;
        this.semesterTaken = null;
        this.grade = null;
        this.status = null;
    }

    public Attempt(Course course, String semesterTaken, String grade, String status) {
        this.course = course;
        this.semesterTaken = semesterTaken;
        this.grade = grade;
        this.status = status;
    }

    // Copy constructor
    public Attempt(Attempt attempt) {
        this(attempt.getCourseAttempted(), attempt.getSemesterTaken(), attempt.getAttemptGrade(), attempt.getStatus());
    }

    public void setSemesterTaken(String semester) {
        if (semester != null && !semester.isEmpty()) {
            this.semesterTaken = semester;
        }
    }

    public void setAttemptGrade(String grade) {
        if (grade != null && !grade.isEmpty()) {
            this.grade = grade;
        }
    }

    public void setCourseAttempted(Course theCourse) {
        if (theCourse != null) {
            this.course = theCourse;
        }
    }

    public void setCourseStatus(String status){
        this.status = status;
    }

    public void setCourseGrade(String grade){
        this.grade = grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    public String getSemesterTaken() {
        return this.semesterTaken;
    }

    public String getCourseGrade() {
        return this.grade;
    }

    public String getCourseCode() {
        return this.course.getCourseCode();
    }

    public String getAttemptGrade() {
        return this.grade;
    }

    public String getStatus() {
        return this.status;
    }

    public Course getCourseAttempted() {
        return this.course;
    }
}
