package bs.model.persistence.dao;

import java.util.ArrayList;
import java.util.List;

/**
 * SimpleQueryBuilder is class used for building JPQL queries easy.
 * Class can build simple query with clause AND.
 * @author Mateusz
 */
public class SimpleQueryBuilder {

	private String fromEntity;
	
	private List<String> conditions;
	
	private SimpleQueryBuilder(Builder builder) {
		this.fromEntity = builder.fromEntity;
		this.conditions = builder.conditions;
	}
	
	public static class Builder {
		
		private String fromEntity;
		
		private List<String> conditions;
		
		public Builder(String fromEntity) {
			this.conditions = new ArrayList<>();
			this.fromEntity = "FROM " + fromEntity + " e ";
		}
		
		/**
		 * @return Generated JPQL query.
		 */
		public String build() {
			return new SimpleQueryBuilder(this).toString();
		}
		
		/**
		 * @return Adequate clause in view of conditions list.
		 */
		private String generateConditionClause() {
			return conditions.size() == 0 ? "WHERE " : "AND ";
		}
		
		public Builder conditionEquals(String property, String value) {
			StringBuilder conditionBuilder = new StringBuilder();
			conditionBuilder.append(generateConditionClause());
			conditionBuilder.append("e." + property + " = " + value);
			conditions.add(conditionBuilder.toString());
			return this;
		}
		
		public Builder conditionGreaterThan(String property, String value) {
			StringBuilder conditionBuilder = new StringBuilder();
			conditionBuilder.append(generateConditionClause());
			conditionBuilder.append("e." + property + " > " + value);
			conditions.add(conditionBuilder.toString());
			return this;
		}
		
		public Builder conditionLessThan(String property, String value) {
			StringBuilder conditionBuilder = new StringBuilder();
			conditionBuilder.append(generateConditionClause());
			conditionBuilder.append("e." + property + " < " + value);
			conditions.add(conditionBuilder.toString());
			return this;
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder queryBuilder = new StringBuilder();
		queryBuilder.append(fromEntity);
		for (String condition: conditions)
			queryBuilder.append(condition);
		return queryBuilder.toString();
	}
	
}
