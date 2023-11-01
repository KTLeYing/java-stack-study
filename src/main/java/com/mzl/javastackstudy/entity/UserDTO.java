package com.mzl.javastackstudy.entity;

import lombok.Data;

/**
 * @ClassName:   UserDTO
 * @Description: 用户
 * @Author: mzl
 * @CreateDate: 2023/10/18 15:47
 * @Version: 1.0
 */
@Data
public class UserDTO {

    private String name;

    private Integer age;

    private String phone;

    private String address;

}