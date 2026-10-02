package mappers;

import java.util.List;

public class Employee {

    private final Integer id;
    private final String email;
    private final String name;
    private final String gender;
    private final Integer age;
    private final String post;
    private final String employedDate;
    private final List<String> skills;

    public Employee(List<String> employeeData) {
        this.id = Integer.valueOf(employeeData.get(0));
        this.email = employeeData.get(1);
        this.name = employeeData.get(2);
        this.gender = employeeData.get(3);
        this.age = Integer.valueOf(employeeData.get(4));
        this.post = employeeData.get(5);
        this.employedDate = employeeData.get(6);
        this.skills = List.of(employeeData.get(7).split(", "));
    }

    public Integer getId() { return id; }

    public String getEmail() { return email; }

    public String getName() { return name; }

    public String getGender() { return gender; }

    public Integer getAge() { return age; }

    public String getPost() { return post; }

    public String getEmployedDate() { return employedDate; }

    public List<String> getSkills() { return skills; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id = ").append(id);
        sb.append(", email = '").append(email).append('\'');
        sb.append(", name = '").append(name).append('\'');
        sb.append(", gender = '").append(gender).append('\'');
        sb.append(", age = ").append(age);
        sb.append(", post = '").append(post).append('\'');
        sb.append(", employedDate = '").append(employedDate).append('\'');
        sb.append(", skills = '").append(skills);
        return sb.toString();
    }
}
