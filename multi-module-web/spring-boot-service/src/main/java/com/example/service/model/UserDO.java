package com.example.service.model;

import com.example.common.util.StringUtil;
import com.example.common.validation.InsertGroup;
import com.example.common.validation.LoginGroup;
import com.example.common.validation.UpdateGroup;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Accessors(chain = true)
@Data
public class UserDO implements Serializable {

    private static final long serialVersionUID = 4382629624053154693L;

    private Long id;


    private String name;

    @NotNull(message = "用户名不能为空！", groups = {InsertGroup.class, UpdateGroup.class, LoginGroup.class})
    @Pattern(regexp = StringUtil.ALPHABET_NUMERIC, message = "用户名只能是英文、数字、下划线",groups = {InsertGroup.class, UpdateGroup.class, LoginGroup.class})
    @Size(max = 20, message = "用户名最长20位！", groups = {InsertGroup.class, UpdateGroup.class, LoginGroup.class})
    private String username;

    @NotNull(message = "密码不能为空！", groups = {InsertGroup.class, LoginGroup.class})
    @Pattern(regexp = StringUtil.ALPHABET_NUMERIC_SYMBOL, message = "密码只能是英文、数字、下划线，及+-.@",groups = {InsertGroup.class, UpdateGroup.class, LoginGroup.class})
    @Size(min = 6, max = 20, message = "密码必须6-20位！", groups = {InsertGroup.class, UpdateGroup.class, LoginGroup.class})
    private String password;

    @NotNull(message = "性别不能为空！", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 2, message = "长度超长！", groups = {InsertGroup.class, UpdateGroup.class})
    private String gender;

    @Pattern(regexp = StringUtil.PHONE_NUMBER, message = "请输入1开头的11位手机号！", groups = {InsertGroup.class, UpdateGroup.class})
    private String phoneNumber;

    @Pattern(regexp = StringUtil.EMAIL, message = "请输入有效格式的邮箱！", groups = {InsertGroup.class, UpdateGroup.class})
    @Max(value = 50, message = "长度超长！", groups = {InsertGroup.class, UpdateGroup.class})
    private String email;

    private String career;

    @Size(min = 18, max = 18, message = "身份证必须是18位！", groups = {InsertGroup.class, UpdateGroup.class})
    private String idNumber;

    private String birthday;

    private String address;

    private Long createdAt;

    private Long updatedAt;

    private List<RoleDO> roles;

}