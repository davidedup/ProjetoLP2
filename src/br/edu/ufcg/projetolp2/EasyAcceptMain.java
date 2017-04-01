package br.edu.ufcg.projetolp2;

import easyaccept.EasyAccept;

public class EasyAcceptMain {

	public static void main(String[] args) {
		args = new String[]{"br.edu.ufcg.projetolp2.controllers.MainController",
				"accptance_test/us1.txt",
				"accptance_test/us1_exception.txt",
				"accptance_test/us2.txt",
				"accptance_test/us2_exception.txt",
				"accptance_test/us3.txt",
				"accptance_test/us3_exception.txt",
				"accptance_test/us4_test.txt",
				"accptance_test/us5_test.txt",
				"accptance_test/us6_test.txt",
				"accptance_test/us6_test_exception.txt"
				};
		EasyAccept.main(args);
	}

}
