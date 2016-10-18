package com.panda.iweb.test.oval;

import com.panda.iweb.test.entity.OvalEntity;
import com.panda.iweb.test.entity.OvalEnum;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huixiangdou on 2016/8/22.
 */
public class OvalTest {
    @Test
    public void testWhen() {
        OvalEntity entity = new OvalEntity();
        Validator validator = new Validator();
        entity.setOvalEnum(OvalEnum.O1);
        List<Integer> list = new ArrayList<>();
        entity.setList(list);
        List<ConstraintViolation> constraintViolations = validator.validate(entity);
        for(ConstraintViolation constraintViolation:constraintViolations){
            System.out.println(constraintViolation.getMessage());
        }
    }
}
