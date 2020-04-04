package main;

import models.*;
import controllers.*;
import views.*;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(model, controller);
	}
}
