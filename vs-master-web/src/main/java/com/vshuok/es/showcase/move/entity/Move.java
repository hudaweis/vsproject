package com.vshuok.es.showcase.move.entity;

import com.vshuok.es.common.entity.BaseEntity;
import com.vshuok.es.common.entity.validate.group.Create;
import com.vshuok.es.common.plugin.entity.Movable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "showcase_moveable")
public class Move extends BaseEntity<Long> implements Movable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4881533226187248907L;

	@NotNull(groups = Create.class)
    @Column(name = "name")
    private String name;

    @Column(name = "weight")
    private Integer weight;


    @Column(name = "is_show")
    private Boolean show;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

	@Override
	public Integer getWeigth() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public void setWeigth(Integer weigth) {
		// TODO Auto-generated method stub
		this.weight=weigth;
	}

}
