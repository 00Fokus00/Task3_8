package com.cgvsu.objreader;

import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static com.cgvsu.model.transformations.AllTransformations.allTransform;
import static com.cgvsu.model.transformations.Scaling.scale;
import static com.cgvsu.model.transformations.Translation.trans;

public class TransformTest {

    @Test
    public void rotateTest(){
        ArrayList<Vector3f> arrayV = new ArrayList<>();
        arrayV.add(new Vector3f(1, 2,3));

        allTransform(arrayV, new Vector3f(0,0,0), new Vector3f((float) Math.PI, 0, 0), new Vector3f(1,1,1));

        Vector3f expected = new Vector3f(1, -2, -3);
        Vector3f actual = arrayV.getFirst();

        float epsilon = 0.00001f;

        Assertions.assertEquals(expected.getX(), actual.getX(), epsilon);
        Assertions.assertEquals(expected.getY(), actual.getY(), epsilon);
        Assertions.assertEquals(expected.getZ(), actual.getZ(), epsilon);
    }

    @Test
    public void transTest(){
        ArrayList<Vector3f> arrayV = new ArrayList<>();
        arrayV.add(new Vector3f(1, 2,3));

        allTransform(arrayV, new Vector3f(10,0,10), new Vector3f(0, 0, 0), new Vector3f(1,1,1));

        Vector3f expected = new Vector3f(11, 2, 13);
        Vector3f actual = arrayV.getFirst();

        float epsilon = 0.00001f;

        Assertions.assertEquals(expected.getX(), actual.getX(), epsilon);
        Assertions.assertEquals(expected.getY(), actual.getY(), epsilon);
        Assertions.assertEquals(expected.getZ(), actual.getZ(), epsilon);
    }

    @Test
    public void scaleTest(){
        ArrayList<Vector3f> arrayV = new ArrayList<>();
        arrayV.add(new Vector3f(1, 2,3));

        allTransform(arrayV, new Vector3f(0,0,0), new Vector3f(0, 0, 0), new Vector3f(3,2,4));

        Vector3f expected = new Vector3f(3, 4, 12);
        Vector3f actual = arrayV.getFirst();

        float epsilon = 0.00001f;

        Assertions.assertEquals(expected.getX(), actual.getX(), epsilon);
        Assertions.assertEquals(expected.getY(), actual.getY(), epsilon);
        Assertions.assertEquals(expected.getZ(), actual.getZ(), epsilon);
    }

    /*@Test
    public void scaleTest(){
        Vector3f vertices = new Vector3f(1,2,3);
        Model model = new Model();
        model.vertices.add(vertices);
        Vector3f s = new Vector3f(4,5,6);
        scale(model, s);
        Assertions.assertTrue(model.vertices.get(0).equals(new Vector3f(4, 10, 18)));
    }

    @Test
    public void scaleTest0(){
        Vector3f vertices = new Vector3f(0,0,0);
        Model model = new Model();
        model.vertices.add(vertices);
        Vector3f s = new Vector3f(4,5,6);
        scale(model, s);
        Assertions.assertTrue(model.vertices.get(0).equals(new Vector3f(0, 0, 0)));
    }

    @Test
    public void translationTest(){
        Vector3f vertices = new Vector3f(1,2,3);
        Model model = new Model();
        model.vertices.add(vertices);
        Vector3f s = new Vector3f(4,5,6);
        trans(model, s);
        Assertions.assertTrue(model.vertices.get(0).equals(new Vector3f(5, 7, 9)));
    }*/
}
