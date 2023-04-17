package study.nigmat.boot.springboot.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "Field can't be empty")
    @Size(min = 2, max = 30, message = "Size of the field could be between 2 and 30 characters")
    private String name;

    @NotEmpty(message = "Field can't be empty")
    @Size(min = 2, max = 30, message = "Size of the field could be between 2 and 30 characters")
    @Column(name = "lastname")
    private String lastName;

    @Min(value = 0, message = "Field can't be negative")
    @Column(name = "salary")
    private int salary;

    public User() {
    }

    public User(String name, String lastName, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

