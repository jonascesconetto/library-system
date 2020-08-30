package cesconetto.daepractica01.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    //public enum Roles {editor, autor, revisor};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role")
    //@Enumerated
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
