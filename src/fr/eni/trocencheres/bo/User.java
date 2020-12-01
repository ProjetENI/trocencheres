package fr.eni.trocencheres.bo;

import java.time.LocalDate;

public class User {
	private String userFistName;
	private String userLastName;
	private String userLogin;
	private String userPassword;
	private LocalDate dateRegistration = LocalDate.now();
}
