package com.assetco.search.results;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UserSegmentTests {

    private UserSegment userSegment;

    @BeforeEach
    public void setup() {userSegment= null;}
    @Test
    public void startsEmpty(){
        assertNull(userSegment);
    }
    public void setSegment(UserSegment userSegment)
    {
        this.userSegment=userSegment;
    }
    @Test
    public void setSegmentNewsMedia(){
        setSegment(UserSegment.NewsMedia);
        assertEquals(userSegment.fetchSegmentName(),"NewsMedia");
    }
    @Test
    public void setSegmentOtherMedia(){
        setSegment(UserSegment.OtherMedia);
        assertEquals(userSegment.fetchSegmentName(),"OtherMedia");
    }
    @Test
    public void fetchByNameSegmentGeneralPublic(){
        setSegment(UserSegment.GeneralPublic);
        assertEquals(userSegment.fetchSegmentName(),"GeneralPublic");
    }
    @Test
    public void fetchByNameSegmentNewsMedia(){
        var segname = "NewsMedia";
        setSegment(UserSegment.fetchByName(segname));
        assertEquals(userSegment.fetchSegmentName(),segname);
    }
    @Test
    public void fetchByNameSegmentOtherMedia(){
        var segname = "OtherMedia";
        setSegment(UserSegment.fetchByName(segname));
        assertEquals(userSegment.fetchSegmentName(),segname);

    }
    @Test
    public void setSegmentGeneralPublic(){
        var segname = "GeneralPublic";
        setSegment(UserSegment.fetchByName(segname));
        assertEquals(userSegment.fetchSegmentName(),segname);

    }

    @Test
    public void fetchByNameSegmentNewsMediaCase(){
        var segname = "NeWsMEdIa";
//        IllegalStateException thrown = assertThrows(IllegalStateException.class,()->UserSegment.fetchByName(segname));
        setSegment(UserSegment.fetchByName(segname));
        assertTrue(segname.equalsIgnoreCase(userSegment.fetchSegmentName()));
    }


    @Test
    public void fetchByNameSegmentNull(){
        var segname = "asdasdasd";
        IllegalStateException thrown = assertThrows(IllegalStateException.class,()->UserSegment.fetchByName(segname));
    }

    @Test
    public void userSegmentValues() {
        assertEquals(
                namesOfUserSegmentEnumerationValues(),
                Arrays.asList("NewsMedia", "OtherMedia", "GeneralPublic"));
    }

    private List<String> namesOfUserSegmentEnumerationValues() {
        return Arrays.stream(UserSegment.values()).map(Enum::name).collect(Collectors.toList());
    }
}
