package com.example.manageruniversity.filter;

import com.example.manageruniversity.common.object.ObjectUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;

import static com.example.manageruniversity.cache.mem.FilterCache.MEM_FILTER_INSTANCE;

public class FilterFactory {
    public static FilterStrategy getInstance(FilterType key,
                                             Root root,
                                             CriteriaBuilder builder,
                                             String data) {
        if (MEM_FILTER_INSTANCE.containsKey(key.name())) {
            MEM_FILTER_INSTANCE.get(key.name()).setData(data);
        } else {
            MEM_FILTER_INSTANCE.put(key.name(), ObjectUtils.init(key.getClazz(), root, builder, data));
        }
        return MEM_FILTER_INSTANCE.get(key.name());
    }


}
