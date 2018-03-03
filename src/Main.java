import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
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


        while (!glfwWindowShouldClose(window)){

            float red = 1;
            float green = 1;
            float blue = 1;

            if(glfwGetKey(window, GLFW_KEY_W) == GL_TRUE){
                red = 0.75f;
                green = 0.75f;
                blue = 0.75f;
            }
            glfwPollEvents();

            glClear(GL_COLOR_BUFFER_BIT);

            glBegin(GL_QUADS);
            glColor4f(red,0,0,0);
            glVertex2f(-0.5f,0.5f);
            glColor4f(0,green,0,0);
            glVertex2f(0.5f,0.5f);
            glColor4f(0,0,blue,0);
            glVertex2f(0.5f,-0.5f);
            glColor4f(1,1,1,0);
            glVertex2f(-0.5f,-0.5f);

            glEnd();

            glfwSwapBuffers(window);            //????
        }

        glfwTerminate();
    }

    public static void main(String args[]){
        new Main();
    }
}
