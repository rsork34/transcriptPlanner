import univ.*;

public class PlanOfStudy
{
    Student student;
    CourseCatalog catalog;

    public PlanOfStudy(){
        student = new Student();
        catalog = new CourseCatalog();
    }

    public PlanOfStudy(Student student){
        this.student = student;
        catalog = new CourseCatalog();
    }

    public Student getStudent() {
        return this.student;
    }

    public CourseCatalog getCatalog() {
        return catalog;
    }

    public void addAttemptToPlan(Course course, String semester, String grade, String status) {
       Attempt toAdd = new Attempt(course, semester, grade, status);

       if (status.toLowerCase().equals("in progress")) {
           student.getTranscript().addPlannedCourse(toAdd);
       }
       else if (status.toLowerCase().equals("completed")) {
           student.getTranscript().addCompletedCourse(toAdd);
       }
       else {
           System.out.println("Error, invalid course status");
       }
    }

    @Override
    public String toString() {
        String toReturn = "Completed Courses: ";

        for (Attempt a : student.getTranscript().getCompletedCourses()) {
            toReturn += a.getCourseCode() + ", ";
        }

        toReturn += "Planned Courses: ";

        for (Attempt a : student.getTranscript().getPlannedCourses()) {
            toReturn += a.getCourseCode() + ", ";
        }

        return toReturn;
    }
}
