package com.ourblog.common.bean.user;

import com.ourblog.common.bean.common.BaseEntity;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName User
 * @Description 用户实体类
 * @Author Yudachi
 * @Date 2021/1/21 10:27
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_user")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "u_id")
    private Integer id;
    @Column(name = "u_username")
    private String username;
    @Column(name = "u_password")
    private String password;
    @Column(name = "u_email")
    private String email;
}
