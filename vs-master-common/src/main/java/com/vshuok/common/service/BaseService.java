package com.vshuok.common.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.*;

import com.google.common.collect.Lists;
import com.vshuok.es.common.entity.AbstractEntity;
import com.vshuok.es.common.entity.search.Searchable;
import com.vshuok.es.common.repository.BaseRepository;

/**
 * <p>
 * 抽象service层基类 提供一些简便方法
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public abstract class BaseService<M extends AbstractEntity, ID extends Serializable> {

	protected BaseRepository<M, ID> baseRepository;

	public void setBaseRepository(BaseRepository<M, ID> baseRepository) {
		this.baseRepository = baseRepository;
	}

	/**
	 * 保存单个实体
	 * 
	 * @param m
	 * @return
	 */
	public M save(M m) {
		return baseRepository.save(m);
	}

	public M saveAndFlush(M m) {
		m = save(m);
		baseRepository.flush();
		return m;
	}

	/**
	 * 更新单个实体
	 * 
	 * @param m
	 * @return
	 */
	public M update(M m) {
		return baseRepository.save(m);
	}

	/**
	 * 根据主键删除相应实体
	 * 
	 * @param id
	 */
	public void delete(ID id) {
		baseRepository.delete(id);
	}

	/**
	 * 删除实体
	 * 
	 * @param m
	 */
	public void delete(M m) {
		baseRepository.delete(m);
	}

	/**
	 * 根据主键删除相应实体
	 * 
	 * @param ids
	 */
	public void delete(ID[] ids) {
		baseRepository.delete(ids);
	}

	/**
	 * 按照主键查询
	 * 
	 * @param id
	 * @return
	 */
	public M findOne(ID id) {
		return baseRepository.findOne(id);
	}

	/**
	 * 实体是否存在
	 * 
	 * @param id
	 * @return
	 */
	public boolean exists(ID id) {
		return baseRepository.exists(id);
	}

	/**
	 * 统计实体总数
	 * 
	 * @return
	 */
	public long count() {
		return baseRepository.count();
	}

	/**
	 * 查询所有实体
	 * 
	 * @return
	 */
	public List<M> findAll() {
		return baseRepository.findAll();
	}

	/**
	 * 按照顺序查询所有实体
	 * 
	 * @param sort
	 * @return
	 */
	public List<M> findAll(Sort sort) {
		return baseRepository.findAll(sort);
	}

	/**
	 * 分页排序查询实体
	 * 
	 * @param pageable
	 * @return
	 */
	public Page<M> findAll(Pageable pageable) {
		return baseRepository.findAll(pageable);
	}

	/**
	 * 按条件分页并排序查询实体
	 * 
	 * @param searchable
	 * @return
	 */
	public Page<M> findAll(Searchable searchable) {
		return baseRepository.findAll(searchable);
	}

	/**
	 * 按条件不分页不排序查询实体
	 * 
	 * @param searchable
	 * @return
	 */
	public List<M> findAllWithNoPageNoSort(Searchable searchable) {
		searchable.removePageable();
		searchable.removeSort();
		return Lists.newArrayList(baseRepository.findAll(searchable)
				.getContent());
	}

	/**
	 * 按条件排序查询实体(不分页)
	 * 
	 * @param searchable
	 *            条件
	 * @return
	 */
	public List<M> findAllWithSort(Searchable searchable) {
		searchable.removePageable();
		return Lists.newArrayList(baseRepository.findAll(searchable)
				.getContent());
	}

	/**
	 * 按条件分页并排序统计实体数量
	 * 
	 * @param searchable
	 * @return
	 */
	public Long count(Searchable searchable) {
		return baseRepository.count(searchable);
	}

}
