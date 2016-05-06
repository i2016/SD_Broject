package com.cal;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
public class CalApplication extends Application {
GridPane pane =new GridPane();
	TextField Cal=new TextField();
	Button p1=new Button("1");
	Button p2=new Button("2");
	Button p3=new Button("3");
	Button p4=new Button("4");
	Button p5=new Button("5");
	Button p6=new Button("6");
	Button p7=new Button("7");
	Button p8=new Button("8");
	Button p9=new Button("9");
	Button p0=new Button("0");
	Button pdot=new Button(".");//button for Dot
	Button pcl=new Button("C");//button clear for all
	Button plus=new Button("+");
	Button miuns=new Button("-");
	Button multi=new Button("*");
	Button div=new Button("/");
	Button mod=new Button("%");
	Button peq=new Button("=");
	Button pow=new Button("x^2");
	Button prot=new Button("root");//button for find root
	Button pcc=new Button("<-");//button clear by one
	Button pleftarc=new Button("(");
	Button prightarc=new Button(")");
	Button minusNumber=new Button("+/-");//***** for minus number which use in operations *******
	//Button salab=new Button("(-)");
    @Override
    public void start(Stage stage) {
       /* Rectangle2D platform=Screen.getPrimary().getVisualBounds();
   			double w=platform.getWidth();
   			double h=platform.getHeight();*/
   		
p1.setMinWidth(70);p7.setMinWidth(70);plus.setMinWidth(70);
p2.setMinWidth(70);p8.setMinWidth(70);miuns.setMinWidth(70);
p3.setMinWidth(70);p9.setMinWidth(70);multi.setMinWidth(70);
p4.setMinWidth(70);p0.setMinWidth(70);div.setMinWidth(70);
p5.setMinWidth(70);pdot.setMinWidth(70);mod.setMinWidth(70);
p6.setMinWidth(70);pcl.setMinWidth(70);peq.setMinWidth(70);peq.setMaxWidth(150);
prot.setMinWidth(70);pcc.setMinWidth(70);pow.setMinWidth(70);
pleftarc.setMinWidth(70);prightarc.setMinWidth(70);
//salab.setMinWidth(70);
minusNumber.setMinWidth(70);
pane.add(Cal,0,0,5,1);
pane.setPadding(new Insets(20,20,20,20));
pane.setHgap(5);
pane.setVgap(5);
//////////////////PUT BUTTON IN PANE////////
pane.addRow(1,p1,p2,p3,plus,pcc);    
pane.addRow(2,p4,p5, p6,miuns,prot);    
pane.addRow(3,p7,p8, p9,multi,pow);
pane.addRow(4,p0,pdot,pcl,div,mod); 
pane.add(peq,0,5,2,1);
pane.add(pleftarc,3,5);
pane.add(prightarc,4,5);
pane.add(minusNumber,2,5);
Cal.setEditable(false); //for prevent to write from the keybord
p0.setOnAction(e->b0());
p1.setOnAction(e->b1());
p2.setOnAction(e->b2());
p3.setOnAction(e->b3());
p4.setOnAction(e->b4());
p5.setOnAction(e->b5());
p6.setOnAction(e->b6());
p7.setOnAction(e->b7());
p8.setOnAction(e->b8());
p9.setOnAction(e->b9());
pcl.setOnAction(e->pclear());
plus.setOnAction(e->handle1());
miuns.setOnAction(e->miu());
multi.setOnAction(e->bmul());
div.setOnAction(e->bdiv());
pow.setOnAction(e->bpow());
pdot.setOnAction(e->bdot());
mod.setOnAction(e->reminder());
pleftarc.setOnAction(e->arcleft());
prightarc.setOnAction(e->arcright());
peq.setOnAction(e->pequal());
prot.setOnAction(e->root());
pcc.setOnAction(e->clearone());
minusNumber.setOnAction(e->salabFun());// for miuns number
Cal.setEditable(false); //for prevent to write from the keybord
Scene scene=new Scene(pane);
stage.setTitle("Calculator");
stage.setScene(scene);
stage.show();
    }
      public void b0()
    {	
	String s= (Cal.getText()+"0");
Cal.setText(s);}
  
    public void b1()
    {	
	String s= (Cal.getText()+"1");
Cal.setText(s);}
    public void b2()
    {	
	String s= (Cal.getText()+"2");
Cal.setText(s);}
    public void b3()
    {	
	String s= (Cal.getText()+"3");
Cal.setText(s);}
    public void b4()
    {	
	String s= (Cal.getText()+"4");
Cal.setText(s);}
    public void b5()
    {	
	String s= (Cal.getText()+"5");
Cal.setText(s);}
    public void b6()
    {	
	String s= (Cal.getText()+"6");
Cal.setText(s);}
    public void b7()
    {	
	String s= (Cal.getText()+"7");
Cal.setText(s);}
    public void b8()
    {	
	String s= (Cal.getText()+"8");
Cal.setText(s);}
    public void b9()
    {	
	String s= (Cal.getText()+"9");
Cal.setText(s);}
    public void miu()
    {	
	String s= (Cal.getText()+"-");
Cal.setText(s);}
	public void handle1()
	{	
		
	String s= (Cal.getText()+"+");
Cal.setText(s);
}
	public void bmul()
    {	
	String s= (Cal.getText()+"*");
Cal.setText(s);}
    public void bdiv()
    {	
	String s= (Cal.getText()+"/");
Cal.setText(s);}
    public void bdot()
    {	
	String s= (Cal.getText()+".");
Cal.setText(s);}
    public void bpow()
    {	
	double d= Double.parseDouble(Cal.getText());

	
	Cal.setText(d*d+" ");}
    public void reminder()
    {
    	String s= (Cal.getText()+"%");
    	Cal.setText(s);
    }
    public void arcleft()
    {
    	String s= (Cal.getText()+"(");
    	Cal.setText(s);
    }
    public void arcright()
    {
    	String s= (Cal.getText()+")");
    	Cal.setText(s);
    }
  /*  public void pequal()
    {	
String s=Cal.getText();
String a=""+m.toPost(s);

Cal.setText(a);}*/
    
    public void root()
    {
    double d= Double.parseDouble(Cal.getText());	
    	Double num= Math.sqrt(d);
        String a=""+num;
       Cal.setText(a);
}
    public void pequal()
    {	
    	
String s=Cal.getText();
/* String d="";  //handel minus number 
for(int i=0;i<s.length();i++)
{
	char ch=s.charAt(i);
	if(m.isOperator(ch))
	{
		if(m.isOperator(s.charAt(i+1)=='-'))
		{
			
			d=s.replace('-','#');
		}
	}
	
}*/
String a=""+m.toPost(s);

Cal.setText(a);
}
    public void salabFun()
    {
    	String s= (Cal.getText()+'-');
    	Cal.setText(s);
    	
    }

public void pclear()
{	

Cal.clear();}
/////////////////////clear if text is empty do nothing
public void clearone() 
{
	try{
	Cal.deleteText(Cal.getText().length()-1, Cal.getText().length());	
}
catch(Exception s)
{
	Cal.setText(" ");
}
}
 public void salabFun()
    {
    	String s= (Cal.getText()+'-');
    	Cal.setText(s);
    	
    }

	public static void main(String[] args) {
		Application.launch(args);

	}

}
