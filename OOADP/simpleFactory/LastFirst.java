package simpleFactory;

public class LastFirst extends NameDivider {
	LastFirst(String name){
		int i = name.indexOf(",");
		if(i>0) {
			lName = name.substring(0, i);
			fName = name.substring(i+1);
		} else {
			lName = name;
			fName ="";
		}
	}
}
