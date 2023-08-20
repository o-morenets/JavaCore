package _08_oop._03_inheritance._07_abstract_vs_interface._00_Example.otherpackage;

import _08_oop._03_inheritance._07_abstract_vs_interface._00_Example.Child;

public class ClassToDo extends Child {

	@Override
	protected String doNothing() {
		return super.doNothing();
	}

	public static void main(String[] args) {
		ClassToDo classTODO = new ClassToDo();

		Child child = new Child();
		child.doSomething();
//        child.todo(); // protected, cannot be invoked from other package

		classTODO.doNothing();
	}
}
