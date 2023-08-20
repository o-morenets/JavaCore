package _19_io._99_examples;

import java.net.URI;

public class URIExample {

	public static void main(String[] args) {
		URI uri = URI.create("http://www.example.com/path?query=value#fragment");
		System.out.println("URI Scheme: " + uri.getScheme());
		System.out.println("URI Host: " + uri.getHost());
		System.out.println("URI Path: " + uri.getPath());
		System.out.println("URI Query: " + uri.getQuery());
		System.out.println("URI Fragment: " + uri.getFragment());
	}
}

