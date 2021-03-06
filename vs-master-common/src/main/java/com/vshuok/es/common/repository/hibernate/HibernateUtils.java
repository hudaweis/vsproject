package com.vshuok.es.common.repository.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;

/**
 * <p>
 * 根据 jpa api 获取hibernate相关api
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public class HibernateUtils {

	/**
	 * 根据jpa EntityManager 获取 hibernate Session Api
	 * 
	 * @param em
	 * @return
	 */
	public static Session getSession(EntityManager em) {
		return (Session) em.getDelegate();
	}

	/**
	 * 根据 jpa EntityManager 获取 hibernate SessionFactory api
	 * 
	 * @param em
	 * @return
	 */
	public static SessionFactory getSessionFactory(EntityManager em) {
		return getSessionFactory(em.getEntityManagerFactory());
	}

	/**
	 * 根据jpa EntityManagerFactory 获取 hibernate SessionFactory API
	 * 
	 * @param emf
	 * @return
	 */
	public static SessionFactory getSessionFactory(EntityManagerFactory emf) {
		return ((HibernateEntityManagerFactory) emf).getSessionFactory();
	}

	/**
	 * 根据 jpa EntityManager 获取hibernate Cache api
	 * 
	 * @param em
	 * @return
	 */
	public static Cache getCache(EntityManager em) {
		return getCache(em.getEntityManagerFactory());
	}

	/**
	 * 根据 jpa EntityManagerFactory 获取 hibernate Cache API
	 * 
	 * @param emf
	 * @return
	 */
	public static Cache getCache(EntityManagerFactory emf) {
		return getSessionFactory(emf).getCache();
	}

	/**
	 * 清空一级缓存
	 * 
	 * @param em
	 */
	public static void evictLevel1Cache(EntityManager em) {
		em.clear();
	}

	/**
	 * 清空二级缓存
	 * 
	 * @param em
	 */
	public static void evictLevel2Cache(EntityManager em) {
		evictLevel2Cache(em.getEntityManagerFactory());
	}

	/**
	 * 根据jpa EntityManagerFactory 清空二级缓存 包括: 1、实体缓存 2、集合缓存 3、查询缓存 注意: jpa Cache
	 * api 只能evict 实体缓存，其他缓存是删不掉
	 * 
	 * @param emf
	 */
	public static void evictLevel2Cache(EntityManagerFactory emf) {
		Cache cache = HibernateUtils.getCache(emf);
		cache.evictEntityRegions();
		cache.evictCollectionRegions();
		cache.evictQueryRegions();
		cache.evictNaturalIdRegions();
	}
}
