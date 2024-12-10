package com.cgvsu.model.transformations;

import com.cgvsu.math.matrices.Matrix3f;
import com.cgvsu.math.matrices.Matrix4f;
import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.math.vectors.Vector4f;
import com.cgvsu.model.Model;

import java.util.ArrayList;

public class Rotation {

    public static void rotate(Model model, Vector3f r){

        Matrix3f matrixRx = new Matrix3f(
                new Vector3f(1, 0, 0),
                new Vector3f(0, (float) Math.cos(r.getX()), (float) Math.sin(r.getX())),
                new Vector3f(0, (float) - Math.sin(r.getX()), (float) Math.cos(r.getX()))
        );

        Matrix3f matrixRy = new Matrix3f(
                new Vector3f((float) Math.cos(r.getY()), 0, (float) Math.sin(r.getY())),
                new Vector3f(0, 1, 0),
                new Vector3f((float) - Math.sin(r.getY()), 0, (float) Math.cos(r.getY()))
        );

        Matrix3f matrixRz = new Matrix3f(
                new Vector3f((float) Math.cos(r.getZ()), (float) Math.sin(r.getZ()), 0),
                new Vector3f((float) - Math.sin(r.getZ()), (float) Math.cos(r.getZ()), 0),
                new Vector3f(0, 0, 1)
        );

        for(int i = 0; i < model.vertices.size(); i++){
            model.vertices.set(i, matrixRz.multiplyByVector(model.vertices.get(i)));
            model.vertices.set(i, matrixRy.multiplyByVector(model.vertices.get(i)));
            model.vertices.set(i, matrixRx.multiplyByVector(model.vertices.get(i)));
        }

        System.out.println("Операция поворота выполнена");
    }

    public static ArrayList<Vector3f> rotate(ArrayList<Vector3f> v, Vector3f r){
        final Matrix3f matrix3fR = new Matrix3f(
                new Vector3f((float) (Math.cos(r.getY()) * Math.cos(r.getZ())), (float) (- Math.sin(r.getZ()) * Math.cos(r.getY())), (float) Math.sin(r.getY())),
                new Vector3f((float) (Math.sin(r.getX()) * Math.sin(r.getY()) * Math.cos(r.getZ()) + Math.sin(r.getZ()) * Math.cos(r.getX())), (float) (- Math.sin(r.getX()) * Math.sin(r.getY()) * Math.sin(r.getZ()) + Math.cos(r.getX()) * Math.cos(r.getZ())), (float) (-Math.sin(r.getX()) * Math.cos(r.getY()))),
                new Vector3f((float) (Math.sin(r.getX()) * Math.sin(r.getZ()) - Math.sin(r.getY()) * Math.cos(r.getX()) * Math.cos(r.getZ())), (float) (Math.sin(r.getX()) * Math.cos(r.getZ()) + Math.sin(r.getY()) * Math.sin(r.getZ()) * Math.cos(r.getX())), (float) (Math.cos(r.getX()) * Math.cos(r.getY())))
        );

        for(int i = 0; i < v.size(); i++){
           v.set(i, matrix3fR.multiplyByVector(v.get(i)));
        }
        System.out.println("Операция поворота выполнена");
        return v;
    }

    public static Matrix4f rotate(Vector3f r){
        return new Matrix4f(
                new Vector4f((float) (Math.cos(r.getY()) * Math.cos(r.getZ())), (float) (- Math.sin(r.getZ()) * Math.cos(r.getY())), (float) Math.sin(r.getY()), 0),
                new Vector4f((float) (Math.sin(r.getX()) * Math.sin(r.getY()) * Math.cos(r.getZ()) + Math.sin(r.getZ()) * Math.cos(r.getX())), (float) (- Math.sin(r.getX()) * Math.sin(r.getY()) * Math.sin(r.getZ()) + Math.cos(r.getX()) * Math.cos(r.getZ())), (float) (-Math.sin(r.getX()) * Math.cos(r.getY())), 0),
                new Vector4f((float) (Math.sin(r.getX()) * Math.sin(r.getZ()) - Math.sin(r.getY()) * Math.cos(r.getX()) * Math.cos(r.getZ())), (float) (Math.sin(r.getX()) * Math.cos(r.getZ()) + Math.sin(r.getY()) * Math.sin(r.getZ()) * Math.cos(r.getX())), (float) (Math.cos(r.getX()) * Math.cos(r.getY())), 0),
                new Vector4f(0, 0, 0, 1)
        );
    }
}
