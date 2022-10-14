package ru.deevdenis.authenticationmc.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, length = 20, nullable = false)
    private String name;
    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "ban")
    private boolean ban;
    @Column(name = "ban_date")
    private Date banDate;
    @Column(name = "ban_description")
    private String banDescription;

    @Column(name = "registration_date", nullable = false)
    private Date registrationDate;

    /**
     *     @link privilege:
     *     0 - user
     *     1 - helper
     *     2 - admin
     *     3 - senior admin
     *     4 - chief admin
     *     5 - owner
     */
    @Column(name = "privilege", nullable = false)
    private int privilege;

    private void init() {
        setName("");
        setPassword("");
        setPrivilege(0);
        setBan(false);
        setRegistrationDate(new Timestamp(System.currentTimeMillis()));
    }

    public User() {
        init();
    }

    public User(Long id, String name, String password, boolean ban, Date banDate, String banDescription, Date registrationDate, int privilege) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.ban = ban;
        this.banDate = banDate;
        this.banDescription = banDescription;
        this.registrationDate = registrationDate;
        this.privilege = privilege;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public Date getBanDate() {
        return banDate;
    }

    public void setBanDate(Date banDate) {
        this.banDate = banDate;
    }

    public String getBanDescription() {
        return banDescription;
    }

    public void setBanDescription(String banDescription) {
        this.banDescription = banDescription;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isBan() == user.isBan() &&
                getPrivilege() == user.getPrivilege() &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getBanDate(), user.getBanDate()) &&
                Objects.equals(getBanDescription(), user.getBanDescription()) &&
                Objects.equals(getRegistrationDate(), user.getRegistrationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPassword(), isBan(), getBanDate(), getBanDescription(), getRegistrationDate(), getPrivilege());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", ban=" + ban +
                ", banDate=" + banDate +
                ", banDescription='" + banDescription + '\'' +
                ", registrationDate=" + registrationDate +
                ", privilege=" + privilege +
                '}';
    }
}
