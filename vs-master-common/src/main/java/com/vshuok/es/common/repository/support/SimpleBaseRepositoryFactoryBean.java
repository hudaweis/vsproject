package com.vshuok.es.common.repository.support;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.common.repository.callback.SearchCallback;
import com.vshuok.es.common.repository.support.annotation.SearchableQuery;

import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import java.io.Serializable;

/**
 * <p>
 * 基础Repostory简单实现 factory bean
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public class SimpleBaseRepositoryFactoryBean<R extends JpaRepository<M, ID>, M, ID extends Serializable>
		extends JpaRepositoryFactoryBean<R, M, ID> {

	public SimpleBaseRepositoryFactoryBean() {
	}

	@SuppressWarnings("rawtypes")
	protected RepositoryFactorySupport createRepositoryFactory(
			EntityManager entityManager) {
		return new SimpleBaseRepositoryFactory(entityManager);
	}
}

class SimpleBaseRepositoryFactory<M, ID extends Serializable> extends
		JpaRepositoryFactory {

	private EntityManager entityManager;

	public SimpleBaseRepositoryFactory(EntityManager entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
	}

	protected Object getTargetRepository(RepositoryMetadata metadata) {
		Class<?> repositoryInterface = metadata.getRepositoryInterface();

		if (isBaseRepository(repositoryInterface)) {

			JpaEntityInformation<M, ID> entityInformation = getEntityInformation((Class<M>) metadata
					.getDomainType());
			SimpleBaseRepository repository = new SimpleBaseRepository<M, ID>(
					entityInformation, entityManager);

			SearchableQuery searchableQuery = AnnotationUtils.findAnnotation(
					repositoryInterface, SearchableQuery.class);
			if (searchableQuery != null) {
				String countAllQL = searchableQuery.countAllQuery();
				if (!StringUtils.isEmpty(countAllQL)) {
					repository.setCountAllQL(countAllQL);
				}
				String findAllQL = searchableQuery.findAllQuery();
				if (!StringUtils.isEmpty(findAllQL)) {
					repository.setFindAllQL(findAllQL);
				}
				Class<? extends SearchCallback> callbackClass = searchableQuery
						.callbackClass();
				if (callbackClass != null
						&& callbackClass != SearchCallback.class) {
					repository.setSearchCallback(BeanUtils
							.instantiate(callbackClass));
				}

				repository.setJoins(searchableQuery.joins());

			}

			return repository;
		}
		return super.getTargetRepository(metadata);
	}

	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		if (isBaseRepository(metadata.getRepositoryInterface())) {
			return SimpleBaseRepository.class;
		}
		return super.getRepositoryBaseClass(metadata);
	}

	private boolean isBaseRepository(Class<?> repositoryInterface) {
		return BaseRepository.class.isAssignableFrom(repositoryInterface);
	}

	@Override
	protected QueryLookupStrategy getQueryLookupStrategy(
			QueryLookupStrategy.Key key) {
		return super.getQueryLookupStrategy(key);
	}
}