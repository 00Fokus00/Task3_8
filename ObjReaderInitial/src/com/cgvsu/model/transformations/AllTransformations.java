package com.cgvsu.model.transformations;

import com.cgvsu.math.matrices.Matrix3f;
import com.cgvsu.math.matrices.Matrix4f;
import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.math.vectors.Vector4f;

import java.util.ArrayList;

import static com.cgvsu.model.transformations.Rotation.rotate;
import static com.cgvsu.model.transformations.Scaling.scale;
import static com.cgvsu.model.transformations.Translation.trans;

public class AllTransformations {

    public static ArrayList<Vector3f> allTransform(ArrayList<Vector3f> v, Vector3f t, Vector3f r, Vector3f s){

        Matrix4f res = trans(t).multiplyByMatrix(rotate(r)).multiplyByMatrix(scale(s));

        for (int i = 0; i < v.size(); i++){
            Vector4f resV = res.multiplyByVector(v.get(i).vector3To4());
            v.set(i, resV.vector4To3());
        }
        return v;
    }
}
