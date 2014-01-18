package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@javax.persistence.Table(name = "table2", schema = "", catalog = "test")
public class Table2 {
    private long id;

    public Table2() {
    }

    public Table2(String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Table2 table2 = (Table2) o;

        if (id != table2.id) return false;
        if (name != null ? !name.equals(table2.name) : table2.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
