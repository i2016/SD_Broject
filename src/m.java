package com.gluonapplication;
import java.util.Stack;
public class Operation 
{
    static Stack list = new Stack();
	// detremine if character is number or not 
public static <E> boolean isOperand(E ch)
	{
	 if(ch.equals('.')||ch.equals('0')||ch.equals('1')||ch.equals('2')||ch.equals('3')||ch.equals('4')||ch.equals('5')||ch.equals('6')||ch.equals('7')||ch.equals('8')||ch.equals('9')||ch.equals('#'))
	 return true;
	 else 
         return false;
	 
	}
// detremine if character is Operator or not  
public static <E> boolean isOperator(E ch)
	{
          if(ch.equals('=')||ch.equals('+')||ch.equals('-')||ch.equals('/')||ch.equals('*')||ch.equals('^')||ch.equals('%')||ch.equals('√')||ch.equals('!')||ch.equals('l')||ch.equals('g'))
	 return true;
	 else 
         return false;
	 }
	// detremine the prority of operator
public static <E> int prority(E ch)
	{
		
		switch ((Character)ch)
		{
		case'+':case'-': return 1;
		
		case'*':case'/':case'%': return 2;
		
		case'^':case'√': case'!':case'l':case'g':return 3;
		
		default :return 0;
		}
	}
public static String toPost(String inp) throws Exception
       {
		String result="";       //Create Empty Postfix String
		String copy='('+inp+')';  //Given Infix To Store String
		Stack<Character> operator=new Stack<>();//Create Generic Stack To Store Operator
		int size=copy.length();
		char ch,chh;
		boolean b=false;
		for(int i=1;i<size;i++)
		{                             /*if ch is an operand then
                                              append it to the output postfix string */
			
			ch=copy.charAt(i-1);
			chh=copy.charAt(i);
			if(isOperand(ch))
			{                             /*if ch is an operator then
                                              append it to the output postfix string */
				if(isOperator(chh)||chh==')'||chh==')')
				result+=ch+" ";
				else result+=ch;
			}
		
			else if(isOperator(ch))
                        {  
				if(!operator.empty())
					{
					while(!operator.empty())  
                               /* while operator stack not emptypop operator
                                    append it to the postfix string*/
                                     {        
						if(prority(ch)>prority((Character)operator.peek()))
								{
								operator.push(ch);
								break;
								}
						else
							result+=operator.pop( )+" ";
					}
					}
				else 
			    operator.push(ch);
			}
			else if(ch=='('){
				operator.push(ch);}
			else if(ch==')')
			{
				while((Character)operator.peek()!='(')
				{
					result+=operator.pop()+" ";
				}
				operator.pop();
			}
			
			}
			while(operator.size()>1)
				result+=operator.pop();
			
		return result(evalPost(result));//evalPost(result.split(" "));
	}
	public static double evalPost(String exp) throws Exception
	{
	   double res = 0;

    
    double n1;     //result of 1st popping
    double n2;     // result of 2nd popping
    char ch = 0 ;
String number="";
    for (int i = 1; i <= exp.length(); i++) {
         ch = exp.charAt(i-1);


            if (isOperand(ch)) {
            	if(isOperand(exp.charAt(i)))
            	{
            		number+=ch;
           		}
            	else 
            	{
            		number+=ch;
            		String s= number.replace("#", "-");
            		list.push (Double.parseDouble(s));
            		number="";
            		s="";
            	}
            		
            	
            }
             
    else if (isOperator(ch)) 
            
            	 {  
    	     if(ch=='!'||ch=='√'||ch=='l'||ch=='g'){
    	    	
                     n1 = Double.parseDouble(("" + list.pop()));
                    switch (ch) {  
            	 case '√':
                   {         
                    	 list.push(Math.sqrt(n1));
                    	 break;
                   }
                   
            	
            	 case 'l':
                 {
                  	 list.push(Math.log((n1)));
                  	break;
                 }
            	 case 'g':
                 {
                  	 list.push(Math.log10(n1));
                  	break;
                 }
            	 case '!':
            	
            	 {	
            		  list.push(fact(n1));break;
            		 
            	
               	 }
         
            	 
                  
                
                   }
            	          }
            	 else
            		{
            		 n1 = Double.parseDouble(("" + list.pop()));
                          n2 = Double.parseDouble(("" + list.pop()));
                     switch (ch) 
                     {
                         case '+':
                             list.push(n1 + n2);
                             break;
                         case '-':
                             list.push(n2 - n1);
                             break;
                         case '*':
                             list.push(n1 * n2);
                             break;
                         case '/':
                             try{
                            	 
                        	 list.push(n2 / n1);
                             }catch(Exception ex)
                             {
                                                         
                             }   break;
                         case '^':
                            list.push( Math.pow(n2,n1));
                        	 break;
                    
                         case '%':
                        	 list.push(n2 % n1);
                            	 break;
                        
                         default:
                             System.out.println("Invalid operator order!");
                     }  }
            	 }
    else
    {
    }
    }
    res = Double.parseDouble(("" + list.pop()));
    return res;
}
	
	
	// function handling user enter two operators sequential *****************
public void checkOperators(String e)
{
	char ch;
	String number = "";
	for(int i=0;i<e.length();i++)
	{
		ch=e.charAt(i-1);
		if(isOperator(ch))
		{
			if(isOperator(e.charAt(i)))
			{
				try {
					throw new Exception("this wrong behave");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.getMessage();
				}
			}
			else
			{
				number+=ch;
        		list.push (Double.parseDouble(number));
        		number="";
			}
			
		}
	}
}
//determined if the final result is int or float number
	
	public static String root (String n)
	{
		String s=n;

		

		s=s.replaceAll(" ", "");
		char []cr=s.toCharArray();

		for(int i=1;i<s.length();i++)
		{
			if(i==1&&cr[i-1]=='-')
				cr[i-1]='#';
				
			if(isOperator(cr[i-1])||cr[i-1]=='(')
			{
				if(cr[i]=='-')
					cr[i]='#';
			}
		}
		s="";
		for (Character c : cr)
		    s += c.toString();
		int[] index=new int[s.length()];
		index[0]=0;
		int indexOf=0;
		char []ccr=s.toCharArray();

		for(int i=1;i<s.length();i++)
		{if((isOperand(ccr[i-1])&&(ccr[i]=='√'||ccr[i]=='('))||
				(isOperand(ccr[i])&&ccr[i-1]==')')||
				(ccr[i-1]==')'&&ccr[i]=='(')||isOperand(ccr[i-1])
				&&(ccr[i]=='!')||isOperand(ccr[i-1])&&(ccr[i]=='g')
				||isOperand(ccr[i-1])&&(ccr[i]=='l'))
		index[indexOf++]=i;
			
		}
		indexOf=0;
		String full="";
		if(index[indexOf]!=0){
		for(int i=0;i<ccr.length;i++)
		{
			if(i==index[indexOf])
			{
				if(ccr[i]==')'){
				full+=ccr[i]+"*";
				indexOf++;}
				else
				{
					full+="*"+ccr[i];
					indexOf++;
					}
			}
			else
				full+=ccr[i];
		}
		}
		else
			full=s;
		
		String x="";
		x=full.replace("ln","l");
		x=full.replace("log","g");
		

 return x;
        }
	 public static double fact(double c )throws Exception
		{
		
			 if(c<0){throw new Exception("sss");}
		 double facres;
			if(c==1)
			{
				return 1;
			}
			facres=fact(c-1)*c;
			return facres;
		
		}
 public static String result(double n)
	{
		int b= (int)n;
		double v=(n-b);
				if(v==0)
					return String.valueOf(b);
				else
					return String.valueOf(n);
				
	}
}
