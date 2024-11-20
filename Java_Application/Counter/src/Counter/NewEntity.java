/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Counter;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Игорь
 */
@Entity
public class NewEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String printPhone(Long phoneNum) {
    StringBuilder sb = new StringBuilder(15);
    StringBuilder temp = new StringBuilder(phoneNum.toString());

    while (temp.length() < 10)
        temp.insert(0, "0");

    char[] chars = temp.toString().toCharArray();

    sb.append("(");
    for (int i = 0; i < chars.length; i++) {
        if (i == 3)
            sb.append(") ");
        else if (i == 6)
            sb.append("-");
        sb.append(chars[i]);
    }

    return sb.toString();
}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NewEntity)) {
            return false;
        }
        NewEntity other = (NewEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Counter.NewEntity[ id=" + id + " ]";
    }
    
}
