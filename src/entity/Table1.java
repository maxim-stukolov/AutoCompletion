package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;


@Entity
@javax.persistence.Table(name = "table1", schema = "", catalog = "test")
public class Table1 {
    private long id;

    public Table1() {
    }

    public Table1(String name, long id) {
        this.id = id;
        this.name = name;
    }

    @javax.persistence.Column(name = "id")
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private String name;

    @javax.persistence.Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Date birthdate;

    @javax.persistence.Column(name = "birthdate")
    @Basic
    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table1 table1 = (Table1) o;

        if (id != table1.id) return false;
        if (birthdate != null ? !birthdate.equals(table1.birthdate) : table1.birthdate != null) return false;
        if (name != null ? !name.equals(table1.name) : table1.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        return result;
    }
}
