package com.hachicore;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class MemberTest {

    @Test
    public void getterSetter() {
        Member member = new Member();
        member.setName("hachicore");
        assertEquals(member.getName(), "hachicore");
    }

}