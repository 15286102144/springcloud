package com.hqyj.springcloud.springCloudClientAccount.models.account.dao;


import com.hqyj.springcloud.springCloudClientAccount.models.account.entity.User;
import com.hqyj.springcloud.springCloudClientAccount.models.common.vo.SearchVo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserDao {

    @Insert("insert into user (user_name, password, user_img, create_date) " +
            "values (#{userName}, #{password}, #{userImg}, #{createDate})")
    @Options(useGeneratedKeys = true, keyColumn = "user_id", keyProperty = "userId")
    void insertUser(User user);

    @Select("select * from user where user_name = #{userName}")
    User getUserByUserName(String userName);

    @Select("<script>" +
            "select * from user "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (user_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by user_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<User> getUsersBySearchVo(SearchVo searchVo);

    @Update("update user set user_name = #{userName}, " +
            "user_img = #{userImg} where user_id = #{userId}")
    void updateUser(User user);

    @Delete("delete from user where user_id = #{userId}")
    void deleteUser(int userId);

    @Select("select * from user where user_id = #{userId}")
    User getUserByUserId(int userId);
}