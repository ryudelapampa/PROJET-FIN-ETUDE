package fr.diginamic.projet_final.exception;

public class ServiceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public ServiceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public ServiceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
