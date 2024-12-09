package com.cgvsu.model.transformations;

import com.cgvsu.model.Model;
import com.cgvsu.math.matrices.Matrix3f;
import com.cgvsu.math.vectors.Vector3f;

public class Scaling {

    public static void scale(Model model, Vector3f s){
        Matrix3f matrix3f = new Matrix3f(
                new Vector3f(s.getX(), 0, 0),
                new Vector3f(0, s.getY(), 0),
                new Vector3f(0, 0, s.getZ())
        );

        for(int i = 0; i < model.vertices.size(); i++){
            model.vertices.set(i, matrix3f.multiplyByVector(model.vertices.get(i)));
        }

        System.out.println("Операция масштабирования выполнена");
    }
}
