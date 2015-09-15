package ro.stefan.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Users extends BaseEntityAudit{

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "surname")
    private String surname;

    @NotEmpty
    @Column(name = "username")
    private String username;

    @NotEmpty
    @Column(name = "password")
    private String password;

    @NotEmpty
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "enabled")
    private Boolean enabled;

    @NotNull
    @Column(name = "accNonExp")
    private Boolean accNonExp;

    @NotNull
    @Column(name = "accNonLocked")
    private Boolean accNonLocked;

    @NotNull
    @Column(name = "credNonExpired")
    private Boolean credNonExpired;

    @OneToOne()
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToOne
    @JoinColumn(name = "id_unit")
    private Unit unit;

    @OneToOne
    @JoinColumn(name = "id_city")
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nume) {
        this.name = nume;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String prenume) {
        this.surname = prenume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String parola) {
        this.password = parola;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String mail) {
        this.email = mail;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getAccNonExp() {
        return accNonExp;
    }

    public void setAccNonExp(Boolean accNonExp) {
        this.accNonExp = accNonExp;
    }

    public Boolean getAccNonLocked() {
        return accNonLocked;
    }

    public void setAccNonLocked(Boolean accNonLocked) {
        this.accNonLocked = accNonLocked;
    }

    public Boolean getCredNonExpired() {
        return credNonExpired;
    }

    public void setCredNonExpired(Boolean credNonExpired) {
        this.credNonExpired = credNonExpired;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != null ? !id.equals(users.id) : users.id != null) return false;
        if (!name.equals(users.name)) return false;
        if (!surname.equals(users.surname)) return false;
        if (!username.equals(users.username)) return false;
        if (!password.equals(users.password)) return false;
        if (!email.equals(users.email)) return false;
        if (!enabled.equals(users.enabled)) return false;
        if (!accNonExp.equals(users.accNonExp)) return false;
        if (!accNonLocked.equals(users.accNonLocked)) return false;
        if (!credNonExpired.equals(users.credNonExpired)) return false;
        if (!role.equals(users.role)) return false;
        return unit.equals(users.unit);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + enabled.hashCode();
        result = 31 * result + accNonExp.hashCode();
        result = 31 * result + accNonLocked.hashCode();
        result = 31 * result + credNonExpired.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", nume='" + name + '\'' +
                ", prenume='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + password + '\'' +
                ", mail='" + email + '\'' +
                ", enabled=" + enabled +
                ", accNonExp=" + accNonExp +
                ", accNonLocked=" + accNonLocked +
                ", credNonExpired=" + credNonExpired +
                ", role=" + role +
                ", unit=" + unit +
                '}';
    }
}
