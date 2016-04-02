package com.vshuok.es.showcase.product.entity;

import com.vshuok.es.common.entity.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 产品
 */
@Entity
@Table(name = "showcase_product")
public class Product extends BaseEntity<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 206099109836271923L;

	@OneToOne(optional = true)
    @Fetch(FetchMode.SELECT)
    private Category category;

    @NotNull(message = "not.null")
    @Column(name = "name")
    private String name;


    /**
     * 价格 以“角”为单位
     */
    @Column(name = "price")
    private Long price;

    /**
     * 数量
     */
    @Column(name = "number")
    private Long number;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "beginDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date beginDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "endDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    @Column(name = "is_show")
    private Boolean show;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}