import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import sun.font.TrueTypeFont;

import java.security.KeyStore;

import static org.lwjgl.opengl.GL11.*;

import static org.lwjgl.glfw.GLFW.*;
public class Main {

    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;

    public Main(){
        if (!glfwInit()){   //step1: initialization.
            throw new IllegalStateException("Failed to initialize.");
        }

        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        long window = glfwCreateWindow(WIDTH,HEIGHT,"Test Frame", 0, 0);
        //step2: create a window.
        if (window == 0){
            throw new IllegalStateException("Failed to create window.");
        }

        GLFWVidMode videoMode = glfwGetVideoMode(glfwGetPrimaryMonitor());

        glfwSetWindowPos(window,(videoMode.width() - WIDTH)/2, (videoMode.height()- HEIGHT)/2);

        glfwShowWindow(window); //showing the window


        glfwMakeContextCurrent(window);
        GL.createCapabilities(); //creating the context.

        glEnable(GL_TEXTURE_2D);

        float[] vertices = new float[]{
               -0.5f, 0.5f, 0, // top left
                0.5f, 0.5f, 0, // top right
                0.5f, -0.5f, 0, // bottom right

                0.5f, -0.5f, 0, // bottom right
                -0.5f, -0.5f, 0, // bottom left
                -0.5f, 0.5f, 0, // top left

        };


        float[] texture = new float[]{
                0,0,    1,0,    1,1,
                1,1,    0,1,    0,0
        };
        Model model = new Model(vertices,texture);

        Texture tex = new Texture("./res/man.png");


        while (!glfwWindowShouldClose(window)){

//            float red = 1;
//            float green = 1;
//            float blue = 1;

            if(glfwGetKey(window, GLFW_KEY_W) == GL_TRUE){
//                red = 0.75f;
//                green = 0.75f;
//                blue = 0.75f;

            }
            if(glfwGetKey(window,GLFW_KEY_S) == GL_TRUE){
                glfwSetWindowShouldClose(window, Boolean.TRUE);
            }
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);

            tex.bind();

            model.render();

//            glBegin(GL_QUADS);
//
//            glTexCoord2f(0,0);
////            glColor4f(red,0,0,0);
//            glVertex2f(-0.5f,0.5f);
//
//            glTexCoord2f(1,0);
////            glColor4f(0,green,0,0);
//            glVertex2f(0.5f,0.5f);
//
//            glTexCoord2f(1,1);
////            glColor4f(0,0,blue,0);
//            glVertex2f(0.5f,-0.5f);
//
//            glTexCoord2f(0,1);
////            glColor4f(1,1,1,0);
//            glVertex2f(-0.5f,-0.5f);
//
//            glEnd();

            glfwSwapBuffers(window);            //????
        }

        glfwTerminate();
    }

    public static void main(String args[]){
        new Main();
    }
}
