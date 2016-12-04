
package core.modelo;

import javax.persistence.*;

/**
 *
 * @author erick.araujo
 */

@MappedSuperclass
public class EntidadeBase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == obj || getClass() !=  obj.getClass()) return false;
        
        EntidadeBase that = (EntidadeBase) obj;
        return id != null ? id.equals(that.id) : that.id == null;
    }
    
    
}
