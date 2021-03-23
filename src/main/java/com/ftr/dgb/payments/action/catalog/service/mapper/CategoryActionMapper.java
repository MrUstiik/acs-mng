package com.ftr.dgb.payments.action.catalog.service.mapper;

import com.ftr.dgb.payments.action.catalog.domain.*;
import com.ftr.dgb.payments.action.catalog.service.dto.CategoryActionDto;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link CategoryAction} and its DTO {@link CategoryActionDto}.
 */
@Mapper(componentModel = "spring", uses = { CategoryMapper.class })
public interface CategoryActionMapper extends EntityMapper<CategoryActionDto, CategoryAction> {
    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.categoryId", target = "categoryCategoryId")
    CategoryActionDto toDto(CategoryAction categoryAction);

    @Mapping(source = "categoryId", target = "category")
    CategoryAction toEntity(CategoryActionDto categoryActionDto);

    default CategoryAction fromId(String id) {
        if (id == null) {
            return null;
        }
        CategoryAction categoryAction = new CategoryAction();
        categoryAction.setId(id);
        return categoryAction;
    }
}
