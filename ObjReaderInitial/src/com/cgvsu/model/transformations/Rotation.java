package com.cgvsu.model.transformations;

import com.cgvsu.math.matrices.Matrix3f;
import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.model.Model;

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
            model.vertices.set(i, matrixRx.multiplyByVector(model.vertices.get(i)));
            model.vertices.set(i, matrixRy.multiplyByVector(model.vertices.get(i)));
            model.vertices.set(i, matrixRz.multiplyByVector(model.vertices.get(i)));
        }

        System.out.println("Операция поворота выполнена");
    }
}
