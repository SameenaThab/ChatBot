import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt	.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.StringTokenizer;

public class ChatBot extends JFrame implements KeyListener
{

JPanel p=new JPanel();
JTextArea dialog=new JTextArea(20,50);
JTextArea input=new JTextArea(5,50);
JScrollPane scroll=new JScrollPane(
	dialog,
	JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
	);
int match[]=new int[5];
boolean notcontain;
String[] list={"Monish Bhuvanagiri" 
,"Vuppala Hanisha" 
,"Chaya Paruchuri"
,"Siddabathina kavya Sri" 
,"Krishna Boggavarapu" 
,"Asma sulthana"
,"Sameena thabassum"
,"Saiprashanth Chaganti" 
,"Priyanka Medathati" 
,"Manisha Gilda" 
,"Pujitha" 
,"Munagala Manjusha" 
,"Karra Srividya" 
,"Tanguturi Kumari" 
,"Anusha Kotha" 
,"Nissar" 
,"Sudulaguntla Niharika" 
,"Krishna Damarla" 
,"Madhavi Aminigadda"
,"Harshitha Nalluri" 
,"Neelima" 
,"Swathi Nekkanti" 
,"Lavanya Venna" 
,"Kavuri Varaja" 
,"Puralasetti Ramadevi"
,"Divya Vlhc"
,"Vahini"};
String[] kw=
{
"what",
"who",
"how",
"many",
"where",
"no",
"number",
"of",
"staff",
"teaching",
"non",
"placed",
"placements",
"hod",
"principal",
"final",
"fourth",
"4th",
"sections",
"students",
"strength",
"boys",
"girls",
"cs2",
"cs1",
"2nd",
"1st",
"section",
"total",
"eligibility",
"you",
"hi",
"hello",
"list",
"thank"
};
public static void main(String[] args){
	new ChatBot();
}


public ChatBot()
{
super("Chat Bot");
setSize(600,400);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);

dialog.setEditable(false);
input.addKeyListener(this);
p.add(scroll);
p.add(input);
p.setBackground(new Color(255,100,0));
add(p);
addText("hi! This is Chatbot.How may i help you?\n");
setVisible(true);
}


public void keyPressed(KeyEvent e){
int i,j,k;
if(e.getKeyCode()==KeyEvent.VK_ENTER)
	{
	input.setEditable(false);
	//---------grab quote-----------
	String quote=input.getText();
	input.setText("");
	addText("-->You:\t"+quote);
	quote=quote.trim();
	while(
	quote.charAt(quote.length()-1)=='!'||
	quote.charAt(quote.length()-1)=='.'||
	quote.charAt(quote.length()-1)=='?')
		{
		quote=quote.substring(0,quote.length()-1);
		}
	quote=quote.trim();
	//-------check for matches-----
	  String[] ip=quote.split(" ");
	k=0;
for(j=0;j<kw.length;j++)
		{
			System.out.println("entered kw"+j+"loop");
		for(i=0;i<ip.length;i++)
			{
			if(kw[j].equals(ip[i]))
				break;
			}
		if(i<ip.length) {match[k++]=j;System.out.println("matched kw"+j);}
		}
int count=0;
for(i=0;i<match.length;i++)
	{
	if(match[i]==0) count++;
	}
if(count==match.length)
			{notcontain=true; System.out.println("notcontain=true");}
		else
			{notcontain=false; System.out.println("notcontain=false");}
	answer();
	}
}


public void keyReleased(KeyEvent e){
if(e.getKeyCode()==KeyEvent.VK_ENTER)
	{
	input.setEditable(true);
	}
}

public void keyTyped(KeyEvent e){}

public void addText(String str){
	dialog.setText(dialog.getText()+str);
}

public boolean  contains(int k)
	{
	int i;
	boolean res=false;
	notcontain=false;
	for(i=0;i<match.length;i++)
		{if(match[i]==k) break;}
	if(i<match.length)
		{res=true; }
	return res; 
	}
public void answer()
{
//default
if(notcontain)
{addText("\n-->ChatBot\t answer not available or you may check your spelling\n");}
		
else
		{

		if(contains(33))
			{addText("\n-->ChatBot\tlist of students selected in tcs are:\n");
			for(int i=0;i<list.length;i++)
				addText(list[i]+"\n");
			}
		//how you
		else if(contains(30)&&contains(2)){addText("\n-->ChatBot\ti am fine\n");}
		
		//thank you
		else if(contains(30)&&contains(34)){addText("\n-->ChatBot\t my pleasure");}

		//you who what 
		else if(contains(30)){
			if(contains(1)||contains(0))addText("\n-->ChatBot\tI am chatbot designed for providing college information of cse final year\n");
			else
			addText("\n-->ChatBot\t  answer not available or you may check your spelling");}

		//hi hello
		else if(contains(31)||contains(32)){addText("\n-->ChatBot\thi\n");}

		//non teaching
		else if(contains(10)&&contains(9)){addText("\n-->ChatBot\t no.of non teaching staff=8\n");}
		
		//teaching
		else if(contains(9)){addText("\n-->ChatBot\t no. of teaching stafff=37\n");}
		
		//placed,placements
		else if(contains(11)||contains(12))
		{
		//eligibility
		if(contains(29)){addText("\n-->ChatBot\t eligibility criteria is above 65%\n");}

		//no of placements
		else {addText("\n-->ChatBot\t 26 students palced in 2013 and still counting\n");}
		}
		
		//sections
		else if(contains(18))
			{
			//final fourth 4th
			addText("\n-->ChatBot\tno of sections in final year:2\n");
			}
		//boys
		else if(contains(21))
			{
			//cs 2
			if(contains(23)||(contains(27)&&contains(25)))
			{addText("\n-->ChatBot\tno of boys in section 2:29\n");}
			
			//cs 1
			else if(contains(24)||(contains(27)&&contains(26)))
			{addText("\n-->ChatBot\tno of boys in section 2:39\n");}
			
			else
			{addText("\n-->ChatBot\ttotal no of boys : 58\n");}
			}

		//girls
		else if(contains(22))
			{
			//cs 2
			if(contains(23)||(contains(27)&&contains(25)))
			{addText("\n-->ChatBot\tno of girls in section 2:38\n");}
			
			//cs 1
			else if(contains(24)||(contains(27)&&contains(26)))
			{addText("\n-->ChatBot\tno of girls in section 2:32\n");}
			
						
			else
			{addText("\n-->ChatBot\ttotal no of girls : 51\n");}
			}
		
		//strength
		else if((contains(28)&&contains(20))||contains(20)||contains(19))
			{
			addText("\n-->ChatBot\ttotal strength in final year:138\n");
			}
		
		//hod
		else if(contains(13)){addText("\n-->ChatBot\t Dr. K. Srinivas Rao\n");}
		
		//principal
		else if(contains(14)){addText("\n-->ChatBot\t Dr.Sambasiva Rao\n");}
		
		else{addText("\n-->ChatBot\t answer not available or you may check your spelling\n");}
		}
for(int i=0;i<match.length;i++)
	{match[i]=0;}

}//method


}//class
