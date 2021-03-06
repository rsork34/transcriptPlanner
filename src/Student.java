
import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private String first;
    private String last;
    private int studentNum;
    private Transcript transcript;

    public Student() {
        this.first = null;
        this.last = null;
        this.studentNum = 0;
        transcript = new Transcript();
    }

    public Student(String first, String last, int studentNum) {
        this.first = first;
        this.last = last;
        this.studentNum = studentNum;
        transcript = new Transcript();
    }

    public void setFirstName(String first) {
        if (first != null && !first.isEmpty())
            this.first = first;
    }

    public void setLastName(String last) {
        if (last != null && !last.isEmpty())
            this.last = last;
    }

    public void setStudentNumber(Integer studentNum) { this.studentNum = studentNum; }

    public void setPlannedCourseList(ArrayList<Attempt> plannedCourseList) {
        if (plannedCourseList != null) {
            transcript.setPlannedCourses(plannedCourseList);
        }
    }

    public void setCompletedCourseList(ArrayList<Attempt> completedCourseList) {
        if (completedCourseList != null) {
            transcript.setCompletedCourses(completedCourseList);
        }
    }

    public void setTranscript(Transcript transcript) {
        if (transcript != null) {
            this.transcript = transcript;
        }
    }

    public void addCompletedCourse(Attempt completed) {
        if (completed != null) {
            transcript.addCompletedCourse(completed);
        }
    }

    public void addPlannedCourse(Attempt planned) {
        if (planned != null) {
            transcript.addPlannedCourse(planned);
        }
    }

    public String getFullName() {
        String fullName;
        if (this.first == null && this.last == null) {
            return null;
        } else if (this.first == null) {
            fullName = this.last;
        } else if (this.last == null) {
            fullName = this.first;
        } else {
            fullName = this.first + " " + this.last;
        }
        return fullName;
    }

    public String getFirstName() { return this.first; }

    public String getLastName() { return this.last; }

    public Integer getStudentNumber() { return this.studentNum; }

    public Transcript getTranscript() {
        return this.transcript;
    }


    @Override
    public String toString() {
        String toString = "";
        if (this.first != null) {
            toString = ("First name: " + this.first + System.getProperty( "line.separator" ));
        }
        if (this.last != null) {
            toString += ("Last name: " + this.last + System.getProperty( "line.separator" ));
        }
        toString += ("Student number: " + this.studentNum + System.getProperty( "line.separator" ));

        return toString;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (o == this) {
            return true;
        }

        if (!(o instanceof Student)) {
            return false;
        }

        Student student = (Student) o;
        if (!(this.first.equals(student.first))){
            return false;
        }
        if (!(this.last.equals(student.last))){
            return false;
        }
        return this.studentNum == student.studentNum;
    }
}
