
import java.util.Stack;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

public class m {
	
	static Stack list = new Stack();
	///////////////////////////» ‘Ê› Â· œÂ —ﬁ„ Ê·« ⁄·«„…///////////////////////// 
	public static <E> boolean isOperand(E ch)
	{
	 if(ch.equals('.')||ch.equals('0')||ch.equals('1')||ch.equals('2')||ch.equals('3')||ch.equals('4')||ch.equals('5')||ch.equals('6')||ch.equals('7')||ch.equals('8')||ch.equals('9')||ch.equals('#'))
	 return true;
	 else 
		 return false;
	 
	}
///////////////////////////» ‘Ê› Â· œÂ —ﬁ„ Ê·« ⁄·«„…///////////////////////// 
	public static<E> boolean isOperator(E ch)
	{
	 if(ch.equals('+')||ch.equals('-')||ch.equals('/')||ch.equals('*')||ch.equals('^')||ch.equals('%'))
	 return true;
	 else 
		 return false;
	 
	}
	///////////////////» Õœœ «·«Ê·ÊÌ… ///////////////////////
	public static<E> int prority(E ch)
	{
		
		switch ((Character)ch)
		{
		
		case'+':case'-': return 1;
		
		case'*':case'/':case'%': return 2;
		
		case'^':return 3;
		
		default :return 0;
		
		}
	}
		
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

 

}
