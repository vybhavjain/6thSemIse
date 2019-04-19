package simpleFactory;

public class FirstFirst extends NameDivider {
	FirstFirst(String name){
		int i = name.indexOf(" ");
		if(i>0) {
			fName = name.substring(0, i);
			lName = name.substring(i+1);
		} else {
			lName = name;
			fName ="";
		}
	}
}
