package x.gerry.model.vo;

import java.io.Serializable;

/**
 * @author:Gerry
 * @description:
 * @date: Created in 2019/1/10
 */
public class DemoInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String name;
    private String desc;

}
