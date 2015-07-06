package ro.stefan.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Users {

    @Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="id")
    private Long id;

    @NotEmpty @Column(name = "nume")
    private String nume;

    @NotEmpty @Column(name = "prenume")
    private String prenume;

    @NotEmpty @Column(name = "username")
    private String username;

    @NotEmpty @Column(name = "parola")
    private String parola;

    @NotEmpty @Column(name = "mail")
    private String mail;

    @NotNull @Column(name = "enabled")
    private Boolean enabled;

    @NotNull @Column(name = "accNonExp")
     Boolean accNonExp;

    @NotNull @Column(name = "accNonLocked")
    private Boolean accNonLocked;

    @NotNull @Column(name = "credNonExpired")
    private Boolean credNonExpired;

    @OneToOne()
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToOne
    @JoinColumn(name = "id_unit")
    private Unit unit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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
        if (!nume.equals(users.nume)) return false;
        if (!prenume.equals(users.prenume)) return false;
        if (!username.equals(users.username)) return false;
        if (!parola.equals(users.parola)) return false;
        if (!mail.equals(users.mail)) return false;
        if (!enabled.equals(users.enabled)) return false;
        if (!accNonExp.equals(users.accNonExp)) return false;
        if (!accNonLocked.equals(users.accNonLocked)) return false;
        if (!credNonExpired.equals(users.credNonExpired)) return false;
        if (!role.equals(users.role)) return false;
        return unit.equals(users.unit);

    }

    @Override
    public int hashCode() {
        int result = nume.hashCode();
        result = 31 * result + prenume.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + parola.hashCode();
        result = 31 * result + mail.hashCode();
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
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                ", mail='" + mail + '\'' +
                ", enabled=" + enabled +
                ", accNonExp=" + accNonExp +
                ", accNonLocked=" + accNonLocked +
                ", credNonExpired=" + credNonExpired +
                ", role=" + role +
                ", unit=" + unit +
                '}';
    }
}
