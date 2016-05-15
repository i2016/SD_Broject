package com.gluonapplication;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
/**
 *
 * @author AHMED SERAG
 */
public class GluonApplication extends Application 
{
    GridPane pane =new GridPane();
	TextField TextCal=new TextField();
	Operation operation;
	boolean []clear=new boolean[1]; // text field clear when user write new number 
	/* Button Creation For All*/
        Button button0=new Button("0");
	Button button1=new Button("1");
	Button button2=new Button("2");
	Button button3=new Button("3");
	Button button4=new Button("4");
	Button button5=new Button("5");
	Button button6=new Button("6");
	Button button7=new Button("7");
	Button button8=new Button("8");
	Button button9=new Button("9");
	Button buttondot=new Button(".");//button for Dot eg 6.4
	Button buttonClearOne=new Button("<-");//button clear for all in TextField
	Button buttonplus=new Button("+");
	Button buttonmiuns=new Button("-");
	Button buttonmulti=new Button("*");
	Button buttondiv=new Button("/");
	Button buttonmod=new Button("%");
	Button buttonpeq=new Button("=");
	Button buttonpow=new Button("X^n");//for any power 
	Button buttonroot=new Button("√");//button for find root
	Button buttonClearAll=new Button("AC");//button clear by one
	Button buttonleftarc=new Button("(");
	Button buttonrightarc=new Button(")");
	Button buttonminusNumber=new Button("+/-");//***** for minus number which use in operations ******
	Button buttonlog=new Button("log(");
	Button buttonln=new Button("ln(");
	Button buttonfact=new Button("!X");
	@Override
    public void start(Stage stage) 
    { /////// Put   Minimum Width For Button
button1.setMinWidth(70);button7.setMinWidth(70);buttonplus.setMinWidth(70);
button2.setMinWidth(70);button8.setMinWidth(70);buttonmiuns.setMinWidth(70);
button3.setMinWidth(70);button9.setMinWidth(70);buttonmulti.setMinWidth(70);
button4.setMinWidth(70);button0.setMinWidth(70);buttondiv.setMinWidth(70);
button5.setMinWidth(70); buttondot.setMinWidth(70);buttonmod.setMinWidth(70);
button6.setMinWidth(70); buttonClearAll.setMinWidth(70);buttonpeq.setMinWidth(70);
buttonpeq.setMaxWidth(150);buttonroot.setMinWidth(70); buttonClearOne.setMinWidth(70);
buttonpow.setMinWidth(70);buttonleftarc.setMinWidth(70);buttonrightarc.setMinWidth(70);
buttonminusNumber.setMinWidth(70);buttonlog.setMinWidth(70);
buttonln.setMinWidth(70);buttonfact.setMinWidth(70);
button1.setPrefHeight(50);button7.setPrefHeight(50);buttonplus.setPrefHeight(50);
button2.setPrefHeight(50);button8.setPrefHeight(50);buttonmiuns.setPrefHeight(50);
button3.setPrefHeight(50);button9.setPrefHeight(50);buttonmulti.setPrefHeight(50);
button4.setPrefHeight(50);button0.setPrefHeight(50);buttondiv.setPrefHeight(50);
button5.setPrefHeight(50); buttondot.setPrefHeight(50);buttonmod.setPrefHeight(50);
button6.setPrefHeight(50); buttonClearAll.setPrefHeight(50);buttonpeq.setPrefHeight(50);
buttonpeq.setPrefHeight(50);buttonroot.setPrefHeight(50); buttonClearOne.setPrefHeight(50);
buttonpow.setPrefHeight(50);buttonleftarc.setPrefHeight(50);buttonrightarc.setPrefHeight(50);
buttonminusNumber.setPrefHeight(50);buttonfact.setMinHeight(50);
buttonlog.setPrefHeight(50);buttonln.setPrefHeight(50);
TextCal.setPrefHeight(50);
pane.add(TextCal,0,0,5,2);
pane.setPadding(new Insets(20,20,20,20));
pane.setHgap(5);
pane.setVgap(5);
//////////////////PUT BUTTON IN PANE////////
pane.addRow(2,buttonpow,buttonmod,buttonClearAll,buttonClearOne); 
pane.addRow(3,button1,button2,button3,buttonplus);    
pane.addRow(4,button4,button5, button6,buttonmiuns);    
pane.addRow(5,button7,button8, button9,buttonmulti);
pane.addRow(6,button0, buttondot, buttonminusNumber,buttondiv); 
pane.addRow(7,buttonpeq,buttonroot,buttonleftarc,buttonrightarc);
pane.addRow(8,buttonlog,buttonln,buttonfact);

TextCal.setEditable(false); //for prevent to write from the keybord
//Event For All Button 
button0.setOnAction(e->Funzero()); /////// Action in funcation
button1.setOnAction(e->Funone());
button2.setOnAction(e->Funtwo());
button3.setOnAction(e->Funthree());
button4.setOnAction(e->Funfour());
button5.setOnAction(e->Funfive());
button6.setOnAction(e->Funsix());
button7.setOnAction(e->Funseven());
button8.setOnAction(e->Funeight());
button9.setOnAction(e->Funnine());
 buttonClearAll.setOnAction(e->Funclear());
buttonplus.setOnAction(e->Funplus());
buttonmiuns.setOnAction(e->Funmiuns());
buttonmulti.setOnAction(e->Funmul());
buttondiv.setOnAction(e->Fundiv());
 buttonpow.setOnAction(e->Funpow());
 buttondot.setOnAction(e->Fundot());
buttonmod.setOnAction(e->Funreminder());
buttonleftarc.setOnAction(e->Funarcleft());
buttonrightarc.setOnAction(e->Funarcright());
buttonpeq.setOnAction(e->Funequal());
buttonroot.setOnAction(e->Funroot());
 buttonClearOne.setOnAction(e->Funclearone());
buttonminusNumber.setOnAction(e->Funmiunsnumber());// for miuns number
buttonlog.setOnAction(e->Funsin()); /////// Action in funcation
buttonln.setOnAction(e->Funtan());
buttonfact.setOnAction(e->Funfact());
///////CSS modification///////
pane.setStyle("-fx-font-size:20;-fx-background-color:#000000;");
buttonClearOne.setStyle("-fx-background-color:#bd262b;-fx-effect:dropshadow(two-pass-box , #375557 , 2,1,1,1 )");
buttonClearAll.setStyle("-fx-background-color:#bd262b;-fx-effect:dropshadow(two-pass-box , #375557 , 2,1,1,1 )");
TextCal.setStyle("-fx-background-color:white;-fx-text-fill: black;");
buttonplus.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");
buttonmiuns.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");

buttonmulti.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");
buttondiv.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");
buttonpow.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");
buttonroot.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");

buttonmod.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");
buttonleftarc.setStyle("-fx-background-color:#393939;-fx-text-fill: white;");
buttonrightarc.setStyle("-fx-background-color:#393939;-fx-text-fill: white;");
buttonminusNumber.setStyle("-fx-background-color: #393939;-fx-text-fill: white;");
buttonpeq.setStyle("-fx-background-color:#339933;-fx-text-fill: white;");

button0.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button1.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button2.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button3.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button4.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button5.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button6.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button7.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button8.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
button9.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");
buttondot.setStyle("-fx-background-color:#1f1f1f;-fx-text-fill: white;");

Scene scene=new Scene(pane);
stage.setTitle("Calculator");
stage.setScene(scene);
stage.show();
    }
public void Funzero()
   {
    	  if(clear[0]==true)
      	{
      		TextCal.clear();
      		
      	}
      	clear[0]=false;
String s= (TextCal.getText()+"0");
TextCal.setText(s);
   }
   
  
public void Funone()
    {	
    	if(clear[0]==true)
    	{
    		TextCal.clear();
    		
    	}
    	clear[0]=false;
	String s= (TextCal.getText()+"1");
TextCal.setText(s);
    }
public void Funtwo()
    {	
    	if(clear[0]==true)
    	{
    		TextCal.clear();
    		
    	}
    	clear[0]=false;
	String s= (TextCal.getText()+"2");
TextCal.setText(s);
    }
public void Funthree()
    {	
    	if(clear[0]==true)
    	{
    		TextCal.clear();
    		
    	}
    	clear[0]=false;
	String s= (TextCal.getText()+"3");
TextCal.setText(s);}
public void Funfour()
    {	
    	if(clear[0]==true)
    	{
    		TextCal.clear();
    		
    	}
    	clear[0]=false;
	String s= (TextCal.getText()+"4");
TextCal.setText(s);
    }
public void Funfive()
    {	
    	if(clear[0]==true)
    	{
    		TextCal.clear();
    		
    	}
    	clear[0]=false;
	String s= (TextCal.getText()+"5");
TextCal.setText(s);
    }
public void Funsix()
    {	if(clear[0]==true)
	{
		TextCal.clear();
		
	}
	clear[0]=false;
	String s= (TextCal.getText()+"6");
TextCal.setText(s);
    }
 public void Funseven()
    {	
    	if(clear[0]==true)
    	{
    		TextCal.clear();
    		
    	}
    	clear[0]=false;
	String s= (TextCal.getText()+"7");
TextCal.setText(s);
    }
public void Funeight()
    {	if(clear[0]==true)
	{
		TextCal.clear();
		
	}
	clear[0]=false;
	String s= (TextCal.getText()+"8");
TextCal.setText(s);
    }
    public void Funnine()
    {	
    	if(clear[0]==true)
    	{
    		TextCal.clear();
    		
    	}
    	clear[0]=false;
	String s= (TextCal.getText()+"9");
TextCal.setText(s);
    }
public void Funmiuns()
    {	
String s= (TextCal.getText()+" - ");
TextCal.setText(s);
clear[0]=false;
    }
public void Funplus()
     {	
		
	String s= (TextCal.getText()+" + ");
TextCal.setText(s);
clear[0]=false;
      }
public void Funmul()
    {	
	String s= (TextCal.getText()+" * ");
        TextCal.setText(s);
        clear[0]=false;
    }
public void Fundiv()
    {	
	String s= (TextCal.getText()+" / ");
TextCal.setText(s);
clear[0]=false;
    }
public void Fundot()
    {	
	String s= (TextCal.getText()+".");
TextCal.setText(s);
    }
public void Funpow()
    {	
   
    	String s= (TextCal.getText()+"^");
    	TextCal.setText(s);
    	clear[0]=false;
     }
public void Funreminder()
    {
    	String s= (TextCal.getText()+"% ");
    	TextCal.setText(s);
    	clear[0]=false;
    }
public void Funarcleft()
    { 
        if(clear[0]==true)
	{
		TextCal.clear();
		
	}
	clear[0]=false;
    	String s= (TextCal.getText()+" (");
    	TextCal.setText(s);
    	
    }
public void Funarcright()
    { 
        if(clear[0]==true)
	{
		TextCal.clear();
		
	}
	clear[0]=false;
    	String s= (TextCal.getText()+") ");
    	TextCal.setText(s);
    }
    
public void Funroot()
    {
    	String s= (TextCal.getText()+"√");
       	TextCal.setText(s);
       	clear[0]=false;
      }
public void Funequal()
 {	
    	clear[0]=false;
    	try
        {
    		
String s=TextCal.getText();
String cal=""+Operation.toPost(Operation.root(s));
TextCal.setText(cal);
clear[0]=true;
       }
    	catch(Exception e)
        { 
    		if(TextCal.getText().isEmpty())
    		{
    		 	TextCal.setText("");
    		}
    		
    		else
        {
    	TextCal.setText("Error");
    	clear[0]=true;
    	}}

}
public void Funmiunsnumber() ///////// miuns Button
    {
    	String s= (TextCal.getText()+'-');
    	TextCal.setText(s);
    	clear[0]=false;
    	
    }

public void Funclear()
{	

TextCal.clear(); /////////////////////clear if text is empty do nothing
}
public void Funclearone() 
{
	try
        {
	TextCal.deleteText(TextCal.getText().length()-1, TextCal.getText().length());
        }
         catch(Exception s)
        {
	TextCal.setText(" ");
        }
}
public void Funsin()
{
 	  if(clear[0]==true)
   	{
   		TextCal.clear();
   		
   	}
   	clear[0]=false;
String s= (TextCal.getText()+"log(");
TextCal.setText(s);
}

public void Funtan()
{
 	  if(clear[0]==true)
   	{
   		TextCal.clear();
   		
   	}
   	clear[0]=false;
String s= (TextCal.getText()+"ln(");
TextCal.setText(s);
}
public void Funfact()
{
 	  if(clear[0]==true)
   	{
   		TextCal.clear();
   		
   	}
   	clear[0]=false;
String s= (TextCal.getText()+"!");
TextCal.setText(s);
}
    public static void main(String[] args) 
    
    {
    
        launch(args);
    }
  

}
