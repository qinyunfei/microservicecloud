package com.qin.wcc.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "`dept`")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {
    @Id
    @Column(name = "`deptno`")
    private Long deptno;

    @Column(name = "`dname`")
    private String dname;

    @Column(name = "`db_source`")
    private String dbSource;

    private static final long serialVersionUID = 1L;

}