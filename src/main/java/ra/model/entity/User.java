package ra.model.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name not required")
    @NotBlank(message = "Name not required")
    @Size(min = 4, max = 20,message = "Name from 5 to 20")
    private String firstName;
    @NotEmpty(message = "Name not required")
    @NotBlank(message = "Name not required")
    @Size(min = 4, max = 20,message = "Name from 5 to 20")
    private String lastName;
    @Email(message = "Invalid email")
    private String email;
    @Pattern(regexp = "^0\\d{9}$",message = "phone Invalid")
    private String phone;
    @Min(value = 5,message = "password form 6 character")
    private String password;
    @Min(value = 18,message = "age from 18")
    private int age;

    public User() {
    }

    public User(Long id, String firstName, String lastName, String email, String phone, String password, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
