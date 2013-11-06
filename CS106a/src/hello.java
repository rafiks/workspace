/* File: Hello.java
 * This program displays 
 * "Hello, world" on the screen
 * It is inspired by the first program in
 * Brian Kernighan and Dennis Richie's classic book.
 * The C Programming Language 
 */

import acm.graphics.*;
import acm.program.*;


public class HelloProgram extends GraphicsProgram {
	public void run() {
		add(new GLabel("hello, world", 100, 75));
	}
}