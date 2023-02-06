package com.assetco.search.results;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum UserSegment {
    NewsMedia,
    OtherMedia,
    GeneralPublic;

    public static UserSegment fetchByName(String segname) {
        return
        Arrays.stream(values()).filter(v->v.name().equalsIgnoreCase(segname)).collect( Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException();
                    }
                    return list.get(0);
                }
        ));
    }

    public String fetchSegmentName()
    {
        return this.name();
    }

}
