package com.vshuok.es.showcase.sample.entity;

import com.vshuok.es.common.entity.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Entity
@Table(name = "showcase_sample")
public class Sample extends BaseEntity<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6516380832124232309L;

	@NotNull(message = "{not.null}")
    @Column(name = "name")
    private String name;

    //@Range(min = 1, max = 200, message = "{sample.age.not.valid}")
    @Min(value = 1, message = "{sample.age.not.valid}")
    @Max(value = 200, message = "{sample.age.not.valid}")
    @Column(name = "age")
    private Integer age;


    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;

    @Column(name = "sex")
    @Enumerated(value = EnumType.STRING)
    private Sex sex;

    @Column(name = "is_show")
    private Boolean show;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }


}
