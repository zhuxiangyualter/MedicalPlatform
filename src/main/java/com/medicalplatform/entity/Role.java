package com.medicalplatform.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.shiro.authz.Permission;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * 角色实体
 *
 * @author am
 */
@Entity
@Table(name = "ROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {
    @Getter
    @Setter
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "F_ID", length = 128, nullable = false, unique = true)
    protected String id;

    /**
     * 数据受限类型：不受限
     */
    public static final String AUTHORITY_LEVEL_ALL = "0";
    /**
     * 数据受限类型：仅限自己所在单位的数据
     */
    public static final String AUTHORITY_LEVEL_ORGANIZATION = "1";
    /**
     * 数据受限类型：仅限自己的数据
     */
    public static final String AUTHORITY_LEVEL_SELF = "2";
    /**
     * 角色名称
     */
    @Column(name = "F_NAME", nullable = false, length = 16)
    private String name = "";
    /**
     * 描述
     */
    @Column(name = "F_DESCRIPTION", length = 128)
    private String description = "";

    /**
     * 数据权限级别 0-> 所有，1->仅限本学院，2->仅限辅导的班级
     */
    @Column(name = "AUTHORITY_LEVEl")
    private String authorityLevel;
    /**
     * 年级权限，保存数组json
     * 若为空，不限制，若有值，限制年级
     */
    @Column(name = "F_LIMIT_GRADE")
    private String limitGrade;

    /**
     * 所具有的权限
     */
//    @ManyToMany(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
//    @JoinTable(name = "TB_ROLE_PERM",
//            joinColumns = @JoinColumn(name = "F_ROLE_ID"),
//            inverseJoinColumns = @JoinColumn(name = "F_PERM_ID"),
//            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT),
//            inverseForeignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
//    private Set<Permission> permissions;

//    @ManyToMany(targetEntity = User.class, mappedBy = "roles")
//    private Set<User> users;

    public Role(String id) {
        this.id = id;
    }

    // ============ equals and hash ============

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Role)) {
            return false;
        }
        final Role role = (Role) o;
        return Objects.equals(getId(), role.getId()) && Objects.equals(getName(), role.getName()) &&
                Objects.equals(getDescription(), role.getDescription());
    }

    @Override
    public String toString() {
        return "Role{" + "name='" + name + '\'' + ", description='" + description + '\'' + '}';
    }
}
