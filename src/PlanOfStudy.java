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
}
