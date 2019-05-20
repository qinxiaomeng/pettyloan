package com.brother.common.mapper;

import com.brother.common.model.BaseModel;
import com.brother.common.model.request.BaseRequest;

import java.util.List;

public interface CrudMapper<E extends BaseModel,T extends BaseRequest> extends BaseMapper {
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    E get(String id);

    /**
     * 查询数据列表，如果需要分页，请设置分页对象
     * @param param
     * @return
     */
    List<E> findList(T param);

    /**
     * 查询所有数据列表
     * @param param
     * @return
     */
    List<E> findAllList(T param);

    /**
     * 查询数据总数量，用于分页
     * @param param
     * @return
     */
    int getCount(T param);

    /**
     * 插入数据
     * @param entity
     * @return
     */
    int insert(E entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    int update(E entity);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * @param id
     * @see public int delete(T entity)
     * @return
     */
    int delete(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * @param entity
     * @return
     */
    int delete(E entity);
}
