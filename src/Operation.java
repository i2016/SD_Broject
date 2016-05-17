



import java.util.Stack;
public class Operation 
{
    static Stack<Double> list = new Stack<Double>();// use to evaluation postfix Expression
    
	// Determine if character is number or not 
public static <E> boolean isOperand(E ch)
	{
	 if(ch.equals('.')||ch.equals('0')||ch.equals('1')||ch.equals('2')||ch.equals('3')||ch.equals('4')||ch.equals('5')||ch.equals('6')||ch.equals('7')||ch.equals('8')||ch.equals('9')||ch.equals('#'))
	 return true;
	 else 
         return false;
	 
	}
// Determine if character is Operator or not  
public static <E> boolean isOperator(E ch)
	{
          if(ch.equals('=')||ch.equals('+')||ch.equals('-')||ch.equals('/')||ch.equals('*')||ch.equals('^')||ch.equals('%')||ch.equals('√')||ch.equals('!')||ch.equals('l')||ch.equals('g'))
	 return true;
	 else 
         return false;
	 }
	// Determine the priority of operator
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
		Stack<Character> operator=new Stack<>();/*Create Generic Stack To Store 
                Operator And Organize Priority Of Operators */
		int size=copy.length();//size of operation
		char ch,chh;
		for(int i=1;i<size;i++)
		{                             /* if ch is an operand then
                                              append it to the output postfix string */
			
			ch=copy.charAt(i-1);
			chh=copy.charAt(i);
			if(isOperand(ch))
			{                             /*if ch is an operand then
                                              append it to the output postfix string */
				if(isOperator(chh)||chh==')'||chh==')')//to determined the full number and the end of number
				result+=ch+" ";  //add the number flowing by space to separate the elements
				else result+=ch;//if number still complete it
			}
		
                        else if(isOperator(ch))   //if element is operator then check if :
                        {  
				if(!operator.empty())       //the stack is not empty
					{
					while(!operator.empty())  
                               /* while operator stack not empty ,pop operator
                                    append it to the postfix string*/
                                     {        
						if(prority(ch)>prority((Character)operator.peek())) //determined the priority of operand
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
			else if(ch==')')//end of braces 
			{
				while((Character)operator.peek()!='(')
				{
					result+=operator.pop()+" ";
				}
				operator.pop();
			}
			
			}
			while(operator.size()>1)
				result+=operator.pop();       // to make sure that no thing in stack
			
		return result(evalPost(result));//evalPost(result.split(" ")); 
	}





//compute the postfix expression 
	public static double evalPost(String exp) throws Exception
	{
	   double res = 0;//final result

    double n1;     //result of 1st popping
    double n2;     // result of 2nd popping
    char ch = 0 ;
    String number="";
    for (int i = 1; i <= exp.length(); i++) {
         ch = exp.charAt(i-1);


            if (isOperand(ch)) {
            	if(isOperand(exp.charAt(i)))
            	{
            		number+=ch;//collect full number
           		}
            	else 
            	{
            		number+=ch;
            		String s= number.replace("#", "-");//replace the # by minus if found 
            		list.push (Double.parseDouble(s));
            		number="";
            		s="";
            	}
            		
            	
            }
             
    else if (isOperator(ch)) //if operator do the operation on number according to the kind of it
            
            	 {   if(ch=='!'||ch=='√'||ch=='l'||ch=='g') //operations that have single pop number
                 {
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
            		 //operations that have two pop number
            		 n1 = Double.parseDouble(("" + list.pop()));
                          n2 = Double.parseDouble(("" + list.pop()));
                     switch (ch) 
                     {
                         case '+':
                             list.push(n1 + n2);//adding
                             break;
                         case '-':
                             list.push(n2 - n1);//Subtracting
                             break;
                         case '*':
                             list.push(n1 * n2);//Multiply
                             break;
                         case '/':
                             try{
                            	 
                        	 list.push(n2 / n1);//Division
                             }catch(Exception ex)
                             {
                                                         
                             }   break;
                         case '^':
                            list.push( Math.pow(n2,n1));//n2 power of n1 
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
    res = Double.parseDouble(("" + list.pop()));//pop the result from the stack
    return res;
}
	

	
	
	
	
	
	
	
		public static String SpetialCases (String n)
	{
		String s=n;

		

		s=s.replaceAll(" ", "");//remove the space
		
		char []cr=s.toCharArray();
		
		
		
		//determined the minus numbers 
		for(int i=1;i<s.length();i++)
		{
			if(i==1&&cr[i-1]=='-')//if - in the first expression ,  then replace - by #
				cr[i-1]='#';
				
			if(isOperator(cr[i-1])||cr[i-1]=='(') //if an operator follow by -  , then replace - by #
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

		for(int i=1;i<s.length();i++)//to handle the cases of 7√2 ,(2*3)2 , 2(5-1), 5 !4 , 3 log(10) and 5 ln8 for Example.
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
		
		x=full.replace("ln","l");//replace ln to l in Expression
		x=full.replace("log","g");//replace log to g in Expression

				
				full=x.replace("#*(", "#1*(");//to handle the "-()"
				full=full.replace("#*l", "#1*l");//to handle the "-ln"
				full=full.replace("#*g", "#1*g");//to handle the "-log()"
				full=full.replace("#*!", "#1*!");
				full=full.replace(")√", ")*√");//to handle the "-!num "
				return full;
		
		
		
			
        }
		
		
		//calculate the factorial for a number
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
	 
	
	 
	 
	 
	 
	//determined if the output is floating number or integer number 
 public static String result(double n)
	{
		int b= (int)n;
		double v=(n-b);
				if(v==0)
					return String.valueOf(b);
				else
					return String.valueOf(n);
				
	}








//to avoid duplicate dot
 public static boolean duplicateDot(String n,String c)
 {
	 if(n.length()==0)
	 {
		 return false;//add operator
	 }
	String []d=n.split(" ");
	String f=d[d.length-1];
	 if(f.contains(c))
	 {
		 return true;//dont add operator
	 }
	 else
		 return false;// add operator
 }
 
 //to avoid duplicate operator
 public static boolean duplicateOperator(String n,char c)
 {

	 if(n.length()==0)
	 {
		 return true;//dont add operator
	 }
		String []d=n.split(" ");
		String f=d[d.length-1];
		if(f.charAt(f.length()-1)=='+'||f.charAt(f.length()-1)=='/'||
				f.charAt(f.length()-1)=='*'||f.charAt(f.length()-1)=='^'||
				f.charAt(f.length()-1)=='%'||f.charAt(f.length()-1)=='-')
		{
			return true;
		}
		else
			return false;// add operator
	 
 }
 
 
 //avoid duplicate of minus
 public static boolean duplicateMinus(String n,String c)
 {
	 if(n.length()==0)
	 {
		 return false;
	 }
	 if(n.charAt(n.length()-1)==' ')
	 {
		 return false;
	 }
	 else{
	String []d=n.split(" ");
	String f=d[d.length-1];
	 if(f.contains(c))
	 {
		 return true;
	 }
	 else
		 return false;}
 }
 
}
