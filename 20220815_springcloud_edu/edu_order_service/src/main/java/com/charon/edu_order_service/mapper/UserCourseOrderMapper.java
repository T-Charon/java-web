package com.charon.edu_order_service.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.charon.comment.entity.UserCourseOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Entity com.charon.edu_comment_api.entity.UserCourseOrder
 */
public interface UserCourseOrderMapper extends BaseMapper<UserCourseOrder> {
    Boolean updateOrder(Long id,Byte status);

    @Insert("insert into user_course_order(user_id,course_id,activity_id,pay_type_id,trade_no,price,status,is_del)\n" +
            "  values(#{userId},#{courseId},#{activityId},#{payTypeId},#{tradeNo},#{price},#{status},#{isDel})")
    void insertOrder(UserCourseOrder order);

    @Select("select * from user_course_order order by id limit #{from},#{size} ")
    List<UserCourseOrder> selectOrderLimit(long from, long size);
}




