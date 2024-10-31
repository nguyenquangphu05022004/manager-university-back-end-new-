package com.example.manageruniversity.filter;

import com.example.manageruniversity.common.object.ObjectUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;

import static com.example.manageruniversity.cache.mem.FilterCache.MEM;

public class FilterFactory {
    public static FilterStrategy getInstance(FilterType key,
                                             Root root,
                                             CriteriaBuilder builder,
                                             String data) {
        if (MEM.containsKey(key.name())) {
            MEM.get(key.name()).setData(data);
        } else {
            MEM.put(key.name(), ObjectUtils.init(key.getClazz(), root, builder, data));
        }
        return MEM.get(key.name());
    }


}
