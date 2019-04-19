package simpleFactory;

public class NameFactory {
	NameDivider getInstance(String name) {
		int i = name.indexOf(",");
		if(i>0)
			return new LastFirst(name);
		else return new FirstFirst(name);
	}

}
