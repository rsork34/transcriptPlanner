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

    public void addCourseToPlan(String code, String title, )
}
