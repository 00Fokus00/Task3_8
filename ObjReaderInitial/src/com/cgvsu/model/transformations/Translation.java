package com.cgvsu.model.transformations;

import com.cgvsu.math.matrices.Matrix4f;
import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.math.vectors.Vector4f;
import com.cgvsu.model.Model;

public class Translation {

    private static Vector3f vector4To3(Vector4f vector4f){
        return new Vector3f(vector4f.getX(), vector4f.getY(), vector4f.getZ());
    }
    private static Vector4f vector3To4(Vector3f vector3f){
        return new Vector4f(vector3f.getX(), vector3f.getY(), vector3f.getZ(), 1);
    }

    public static void trans(Model model, Vector3f t){

        Matrix4f matrix4f = new Matrix4f(
                new Vector4f(1, 0, 0, t.getX()),
                new Vector4f(0, 1, 0, t.getY()),
                new Vector4f(0, 0, 1, t.getZ()),
                new Vector4f(0, 0, 0, 1)
        );


        for(int i = 0; i < model.vertices.size(); i++){
            Vector4f res = matrix4f.multiplyByVector(vector3To4(model.vertices.get(i)));
            model.vertices.set(i, vector4To3(res));
        }

        System.out.println("Операция перемещения выполнена");
    }
}
