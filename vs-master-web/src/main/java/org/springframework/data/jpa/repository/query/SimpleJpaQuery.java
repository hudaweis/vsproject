package org.springframework.data.jpa.repository.query;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.ParameterAccessor;
import org.springframework.data.repository.query.Parameters;
import org.springframework.data.repository.query.ParametersParameterAccessor;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.orm.jpa.EntityManagerFactoryUtils;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
final class SimpleJpaQuery extends AbstractJpaQuery {

	private static final Logger LOG = LoggerFactory
			.getLogger(SimpleJpaQuery.class);

	private final StringQuery query;
	private final StringQuery countQuery;

	private final JpaQueryMethod method;

	@SuppressWarnings("rawtypes")
	SimpleJpaQuery(JpaQueryMethod method, EntityManager em, String queryString) {

		super(method, em);

		this.method = method;
		this.query = new StringQuery(queryString);
		this.countQuery = new StringQuery(
				method.getCountQuery() == null ? QueryUtils
						.createCountQueryFor(queryString) : method
						.getCountQuery());

		Parameters parameters = method.getParameters();
		boolean hasPagingOrSortingParameter = parameters.hasPageableParameter()
				|| parameters.hasSortParameter();

		if (method.isNativeQuery() && hasPagingOrSortingParameter) {
			throw new IllegalStateException(
					"Cannot use native queries with dynamic sorting and/or pagination!");
		}

		EntityManager target = null;
		if (!method.isNativeQuery()) {
			try {
				target = em.getEntityManagerFactory().createEntityManager();
				target.createQuery(query.getQuery());
			} catch (RuntimeException e) {
				throw e instanceof IllegalArgumentException ? e
						: new IllegalArgumentException(e);
			} finally {
				EntityManagerFactoryUtils.closeEntityManager(target);
			}
		}
	}

	SimpleJpaQuery(JpaQueryMethod method, EntityManager em) {
		this(method, em, method.getAnnotatedQuery());
	}

	@Override
	protected ParameterBinder createBinder(Object[] values) {
		return new StringQueryParameterBinder(getQueryMethod().getParameters(),
				values, query);
	}

	@Override
	public Query doCreateQuery(Object[] values) {

		ParameterAccessor accessor = new ParametersParameterAccessor(
				method.getParameters(), values);
		String sortedQueryString = QueryUtils.applySorting(query.getQuery(),
				accessor.getSort(), query.getAlias());
		EntityManager em = getEntityManager();

		Query query = null;

		if (method.isNativeQuery()) {
			query = method.isQueryForEntity() ? em.createNativeQuery(
					sortedQueryString, method.getReturnedObjectType()) : em
					.createNativeQuery(sortedQueryString);
		} else {
			query = em.createQuery(sortedQueryString);
		}

		return createBinder(values).bindAndPrepare(query);
	}

	@Override
	protected TypedQuery<Long> doCreateCountQuery(Object[] values) {
		return createBinder(values).bind(
				getEntityManager().createQuery(countQuery.getQuery(),
						Long.class));
	}

	public static RepositoryQuery fromQueryAnnotation(
			JpaQueryMethod queryMethod, EntityManager em) {

		LOG.debug("Looking up query for method {}", queryMethod.getName());

		String query = queryMethod.getAnnotatedQuery();

		return query == null ? null
				: new SimpleJpaQuery(queryMethod, em, query);
	}

}
