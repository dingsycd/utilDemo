package demo;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {
	private String name;
	private String sex;

	public Person(String name, String sex) {
		this.name = name;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name) &&
				Objects.equals(sex, person.sex);
	}

	@Override
	public int hashCode() {

		return Objects.hash(name, sex);
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", sex='" + sex + '\'' +
				'}';
	}

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		Person person1 = new Person("小丁", "男");
		Person person2 = new Person("汤圆", "女");
		Person person3 = new Person("小明", "男");
		Person person4 = new Person("小丁", "男");
		Person person5 = new Person("汤圆", "女");
		Person person6 = new Person("汤圆", "男");
		Person person7 = new Person("小明", "女");
		list.add(person1);
		list.add(person2);list.add(person3);list.add(person4);list.add(person5);list.add(person6);list.add(person7);
		System.out.println(list);
		System.out.println(list.size());
		List<Person> newList = new ArrayList<>();
		while (!CollectionUtils.isEmpty(list)) {
			System.out.println(list);
			System.out.println(list.size());
			Person key = list.get(0);
			System.out.println(key);
			newList.add(key);
			list = list.stream().filter(item -> !(key.getName().equals(item.getName()) && key.getSex().equals(item.getSex()))).collect(Collectors.toList());
		}
		System.out.println(newList);
		System.out.println(newList.size());





	}
}
