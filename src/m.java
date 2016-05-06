
import java.util.Stack;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class m {
	

		
///////////////////////////» ÕÊ· „‰ infix «·Ï postfix///////////////////////// 
	public static double toPost(String inp){
		String result="";
		String copy='('+inp+')';
		Stack<Character> operator=new Stack<>();
		int size=copy.length();
		char ch,chh;
		boolean b=false;
		for(int i=1;i<size;i++)
		{
			
			ch=copy.charAt(i-1);
			chh=copy.charAt(i);
			if(isOperand(ch))
			{
				if(isOperator(chh)||chh==')'||chh==')')
				result+=ch+" ";
				else result+=ch;
			}
		
			else if(isOperator(ch)){
				if(!operator.empty())
					{
					while(!operator.empty())
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
			

			
		return evalPost(result);//evalPost(result.split(" "));
	
	}

	
	public static double evalPost(String exp)
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
                     n1 = Double.parseDouble(("" + list.pop()));
                     n2 = Double.parseDouble(("" + list.pop()));

                     switch (ch) {
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
                            	
                             }
                             
                             break;

                         default:
                             System.out.println("Invalid operator order!");
                     }  
            	 }
    else
    {}
    }
            
        

    res = Double.parseDouble(("" + list.pop()));

    return res;
}	

 

}
