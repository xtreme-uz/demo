package com.example.demo.repository;

import com.example.demo.repository.criteria.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.function.Consumer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchQueryCriteriaConsumer implements Consumer<SearchCriteria> {

    private Predicate predicate;
    private CriteriaBuilder builder;
    private Root root;

    @Override
    public void accept(SearchCriteria param) {
        if (param.getOperation().equalsIgnoreCase(">")) {
            predicate = builder.and(predicate, builder
                    .greaterThanOrEqualTo(root.get(param.getKey()), param.getValue().toString()));
        } else if (param.getOperation().equalsIgnoreCase("<")) {
            predicate = builder.and(predicate, builder
                    .lessThanOrEqualTo(root.get(param.getKey()), param.getValue().toString()));
        } else if (param.getOperation().equalsIgnoreCase(":")) {
            predicate = (root.get(param.getKey()).getJavaType() == String.class) ?
                    builder.and(predicate, builder.like(root.get(param.getKey()), "%" + param.getValue() + "%")) :
                    builder.and(predicate, builder.equal(root.get(param.getKey()), param.getValue()));
        }
    }

    @Override
    public Consumer<SearchCriteria> andThen(Consumer<? super SearchCriteria> after) {
        return null;
    }
}
