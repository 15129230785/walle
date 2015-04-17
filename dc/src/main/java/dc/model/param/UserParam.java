package dc.model.param;

import java.io.Serializable;

/**
 * Created by evan.wan on 2015/4/7.
 */
public class UserParam implements Serializable {
    private Long id;
    private String name;

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
}
