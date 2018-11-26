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
            if (grade.equals("P") || grade.equals("F") || grade.equals("INC") || grade.equals("MNR")) {
                this.grade = grade;
            }
            else {
                try {
                    double gradeNum = Double.parseDouble(grade);
                    if (gradeNum >= 0 && gradeNum <= 100) {
                        this.grade = grade;
                    }
                }
                catch (Exception e) {
                    return;
                }
            }
        }
    }

    public void setCourseAttempted(Course theCourse) {
        if (theCourse != null) {
            this.course = theCourse;
        }
    }

    public void setCourseStatus(String status){
        if (status != null) {
            this.status = status;
        }
    }

    public void setGrade(String grade){
        if (grade != null) {
            this.grade = grade;
        }
    }

    public String getSemesterTaken() {
        return this.semesterTaken;
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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Attempt)) {
            return false;
        }

        Attempt a = (Attempt)o;

        if (a.getCourseCode().equals(this.getCourseCode()) && a.getAttemptGrade().equals(this.getAttemptGrade()) &&
            a.getCourseAttempted().equals(this.getCourseAttempted()) && a.getSemesterTaken().equals(this.getSemesterTaken()) &&
            a.getStatus().equals(this.getStatus())) {
            return true;
        }
        return false;
    }
}
