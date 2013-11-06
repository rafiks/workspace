/*
 * File: HelloProgram.java
 * -----------------------
 * This program displays "hello, world" on the screen.
 * It is inspired by the first program in Brian
 * Kernighan and Dennis Ritchie's classic book,
 * The C Programming Language.
 */

import java.awt.Color;
import acm.graphics.*;
import acm.program.*;

public class HelloProgram extends GraphicsProgram {
   public void run() {
	   GLabel label = new GLabel("hello, world", 100, 75);
	   label.setFont("Purisa-ITALIC-32");
	   label.setColor(Color.RED);
	   add(label);
   }
}
