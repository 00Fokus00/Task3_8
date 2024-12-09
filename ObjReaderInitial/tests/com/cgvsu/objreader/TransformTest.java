package com.cgvsu.objreader;

import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.cgvsu.model.transformations.Scaling.scale;
import static com.cgvsu.model.transformations.Translation.trans;

public class TransformTest {

    @Test
    public void scaleTest(){
        Vector3f vertices = new Vector3f(1,2,3);
        Model model = new Model();
        model.vertices.add(vertices);
        Vector3f s = new Vector3f(4,5,6);
        scale(model, s);
        Assertions.assertTrue(model.vertices.get(0).equals(new Vector3f(4, 10, 18)));
    }

    @Test
    public void translationTest(){
        Vector3f vertices = new Vector3f(1,2,3);
        Model model = new Model();
        model.vertices.add(vertices);
        Vector3f s = new Vector3f(4,5,6);
        trans(model, s);
        Assertions.assertTrue(model.vertices.get(0).equals(new Vector3f(5, 7, 9)));
    }
}
