package com.mzl.javastackstudy.entity;

/**
 * @ClassName: UserConverter
 * @Description: 用户实体类转换
 * @Author: mzl
 * @CreateDate: 2023/10/18 15:55
 * @Version: 1.0
 */
public class UserConverter {

    /**
     * 用户类转换
     * @param user 用户
     * @return 用户传输对象
     */
    public UserDTO userConvertToUserDto(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        userDTO.setPhone(user.getPhone());
        userDTO.setAddress(user.getAddress());

        return userDTO;
    }

}