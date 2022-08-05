package com.blb.edu.mapper;

import com.blb.edu.pojo.UndoLog;

/**
 * @Entity com.blb.edu.pojo.UndoLog
 */
public interface UndoLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(UndoLog record);

    int insertSelective(UndoLog record);

    UndoLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UndoLog record);

    int updateByPrimaryKey(UndoLog record);

}
