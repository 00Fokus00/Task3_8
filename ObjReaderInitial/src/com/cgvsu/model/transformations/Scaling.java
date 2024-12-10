package com.cgvsu.model.transformations;

import com.cgvsu.math.matrices.Matrix4f;
import com.cgvsu.math.vectors.Vector4f;
import com.cgvsu.model.Model;
import com.cgvsu.math.matrices.Matrix3f;
import com.cgvsu.math.vectors.Vector3f;

import java.util.ArrayList;

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

    public static ArrayList<Vector3f> scale(ArrayList<Vector3f> v, Vector3f s){
        Matrix3f matrix3fS = new Matrix3f(
                new Vector3f(s.getX(), 0, 0),
                new Vector3f(0, s.getY(), 0),
                new Vector3f(0, 0, s.getZ())
        );

        for(int i = 0; i < v.size(); i++){
            v.set(i, matrix3fS.multiplyByVector(v.get(i)));
        }
        System.out.println("Операция масштабирования выполнена");
        return v;
    }

    public static Matrix4f scale(Vector3f s){
        return new Matrix4f(
                new Vector4f(s.getX(), 0, 0, 0),
                new Vector4f(0, s.getY(), 0, 0),
                new Vector4f(0, 0, s.getZ(), 0),
                new Vector4f(0, 0, 0, 1)

        );
    }
}
