import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class UserLogin {
	HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
	static ArrayList<ItemDetails> ar_items = new ArrayList<ItemDetails>();
	JFrame f1,f2;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton display_item,check;
	JTextField cid,phone,itemid,quan,itemname,itemc;

void add_collection()
{
	hm.put(9887667887L,123);
	hm.put(7665436788L,232);
	hm.put(647485869L,456);
}

int check_collection(Long val)
{
	add_collection();
	if(hm.containsKey(val)) 
		return hm.get(val);
	else
		return -1;
}
	
UserLogin(){
	this.f1 = new JFrame("Customer information");
	this.f2 = new JFrame("Customer Information");
	this.jl1 = new JLabel("Enter customer id");
	this.cid = new JTextField(10);
	this.jl2 = new JLabel("Enter mobile number");
	this.phone = new JTextField(12);
	this.check = new JButton("Check phone");
	this.jl3 = new JLabel("Enter item id");
	this.itemid = new JTextField(10);
	this.jl4 = new JLabel("Enter quantity bought");
	this.quan = new JTextField(4);
	this.jl5 = new JLabel("Item name");
	this.itemname= new JTextField(30);
	this.jl6 = new JLabel("Item cost");
	this.itemc= new JTextField(4);
	this.display_item = new JButton("Item Details");
	String uname = JOptionPane.showInputDialog(null,"Enter username");
	String passwd = JOptionPane.showInputDialog(null,"Enter Password");
	if(uname.equals("uname@gmail.com")&&passwd.equals("pass"))
	{
		JPanel jp=new JPanel();
		jp.add(jl2);
		jp.add(phone);		
		jp.add(check); 
		f1.add(jp);
		f1.setSize(200,200);
		f1.setVisible(true);
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				f1.setVisible(false);
				JPanel jp=new JPanel();
				jp.add(jl1);
				jp.add(cid);
				jp.add(jl3);
				jp.add(itemid);
				jp.add(jl4);
				jp.add(quan);
				jp.add(display_item);
				jp.add(jl5);
				jp.add(itemname);
				jp.add(jl6);
				jp.add(itemc);
				f2.add(jp);
				//check collection
			int v=check_collection(Long.parseLong(phone.getText()));
			cid.setText(Integer.toString(v));
			if(v==-1)
			{
				String cid1 = JOptionPane.showInputDialog(null,"Enter customer id");
				cid.setText(cid1);
			}
				f2.setVisible(true);	
			}
		});
	}
	else
		JOptionPane.showMessageDialog(null,"Invalid details Please run the code once again ");
	
	display_item.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			int v1 = Integer.parseInt(itemid.getText());
			int qty = Integer.parseInt(quan.getText());
			check_item(v1,qty);
		}
	});
}

void check_item(int id,int qty)
{
	for(ItemDetails item:ar_items)
	{
		if(item.item_id==id)
		{
			itemname.setText(item.item_name);
			itemc.setText(Float.toString(item.cost*qty));
		}
	}
}

public static void main(String args[])
{
	Scanner sc = new Scanner(System.in);
	for(int i=0;i<3;i++)
		{
			System.out.println("Enter item id");
			int id = Integer.parseInt(sc.nextLine());
			System.out.println("Enter item name");
			String item_name = sc.nextLine();
			System.out.println("Enter item cost");
			float cost =Float.parseFloat(sc.nextLine());
			ItemDetails it = new ItemDetails(id,item_name,cost);
			ar_items.add(it);
		}
	UserLogin ul = new UserLogin();
	}
}

class ItemDetails {
int item_id;
String item_name;
float cost;
ItemDetails(int it,String iname,float c)
{
	item_id =it;
	item_name = iname;
	cost = c;
}
public String toString()
{
	return item_id+ "   "+item_name+ "   "+cost+"  ";
}
}
