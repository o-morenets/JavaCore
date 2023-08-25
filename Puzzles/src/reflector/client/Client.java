package reflector.client;

import reflector.library.Api;

class Client {
	public static void main(String[] args) {
/*
		System.out.println(Api.member.hashCode()); // java.lang.Object.hashCode() is defined in an inaccessible class or interface
*/
		// Fix:
		System.out.println(((Object)Api.member).hashCode());
	}
}