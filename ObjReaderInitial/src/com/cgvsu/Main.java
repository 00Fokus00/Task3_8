package com.cgvsu;

import com.cgvsu.math.vectors.Vector3f;
import com.cgvsu.model.Model;
import com.cgvsu.obj_writer.ObjWriter;
import com.cgvsu.objreader.ObjReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.cgvsu.model.transformations.Rotation.rotate;
import static com.cgvsu.model.transformations.Scaling.scale;
import static com.cgvsu.model.transformations.Translation.trans;

public class Main {

    public static void main(String[] args) throws IOException {

        Path fileName = Path.of("C:/Users/iafil/OneDrive/Документы/course2/CG_Task_3/3DModels/Faceform/WrapHand.obj");
        String fileContent = Files.readString(fileName);

        System.out.println("Loading model ...");
        Model model = ObjReader.read(fileContent);

        System.out.println("Vertices: " + model.vertices.size());
        System.out.println("Texture vertices: " + model.textureVertices.size());
        System.out.println("Normals: " + model.normals.size());
        System.out.println("Polygons: " + model.polygons.size());

        scale(model, new Vector3f(3,1,1));

        rotate(model, new Vector3f((float) (Math.PI), 0, (float) (0)));

        trans(model, new Vector3f(10F, 0, 10F));

        ObjWriter objWriter = new ObjWriter();

        objWriter.write(model, "C:/Users/iafil/OneDrive/Документы/course2/CG_Task_3/3DModels/Faceform/_WrapHand.obj");

    }
}
