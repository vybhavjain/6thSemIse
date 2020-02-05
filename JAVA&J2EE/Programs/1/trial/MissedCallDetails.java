package trial;

import java.util.*;
class MissedCallDetails
{
Calendar calObj;
Long tel_num;
String name;
MissedCallDetails(Calendar cob, Long tn, String n)
{
    calObj = cob;
    tel_num = tn;
    name = n;
}
void display()
{ 
    System.out.println("Current Time is  "+calObj.getTime()+"\nTelephone number is  "+tel_num+"Name is  "+name);
}}
