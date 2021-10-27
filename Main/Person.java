package Main;

import java.io.Serializable;

public class Person implements Serializable {
    private final String Name;
    private final String Family;
    private final String BirthDate;
    private final String BirthPlace;
    private final String Job;
    private final String Gender;
    private final int IDPersonal;
    private final double EmploymentSalary;

    public Person(String name, String family, String birthDate, String birthPlace, String job, String gender,
                  int iDPersonal, double employmentSalary) {
        Name = name;
        Family = family;
        BirthDate = birthDate;
        BirthPlace = birthPlace;
        Job = job;
        Gender = gender;
        IDPersonal = iDPersonal;
        EmploymentSalary = employmentSalary;
    }

    public String getName() {
        return Name;
    }

    public String getFamily() {
        return Family;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public String getBirthPlace() {
        return BirthPlace;
    }

    public String getJob() {
        return Job;
    }

    public String getGender() {
        return Gender;
    }

    public int getIDPersonal() {
        return IDPersonal;
    }

}